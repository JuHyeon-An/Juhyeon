package k_io;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

public class ClientFrame extends JFrame implements Runnable{

	Socket socket;
//	ObjectOutputStream oos;
//	ObjectInputStream ois;
	ClientThread ct;
	
	HTMLEditorKit kit = new HTMLEditorKit();
	HTMLDocument doc = new HTMLDocument();
	
	DefaultListModel<String> model = new DefaultListModel<String>();
	
	private JPanel contentPane;
	private JLabel label;
	private JTextField serverIP;
	private JLabel label_1;
	private JTextField port;
	private JButton button;
	private JButton button_1;
	private JScrollPane scrollPane_1;
	private JButton button_2;
	private JComboBox comboBox;
	private JTextField message;
	private JButton button_4;
	private JLabel label_2;
	private JTextField tmId;
	private JLabel label_3;
	private JTextField tPwd;
	private JTextPane textPane;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_1;
	private JList list;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientFrame frame = new ClientFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ClientFrame() {
		setTitle("\uCC44\uD305 \uD074\uB77C\uC774\uC5B8\uD2B8");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLabel());
		contentPane.add(getServerIP());
		contentPane.add(getLabel_1());
		contentPane.add(getPort());
		contentPane.add(getButton());
		contentPane.add(getButton_1());
		contentPane.add(getScrollPane_1());
		contentPane.add(getButton_2());
		contentPane.add(getComboBox());
		contentPane.add(getMessage());
		contentPane.add(getButton_4());
		contentPane.add(getLabel_2());
		contentPane.add(getTmId());
		contentPane.add(getLabel_3());
		contentPane.add(getTPwd());
		contentPane.add(getScrollPane());
	}
	
	@Override
	public void run() {
		try {
			String ip = serverIP.getText();
			int p = Integer.parseInt(port.getText());
			socket = new Socket(ip, p);
			//socket이 만들어지는 순간 Thread
			
			ct = new ClientThread(ClientFrame.this, socket);
			ct.start();
			
//			oos = new ObjectOutputStream(socket.getOutputStream());
//			ois = new ObjectInputStream(socket.getInputStream());
			
		}catch(Exception ex){
			System.out.println("ClientFrame.run()");
			ex.printStackTrace();
		}
	}
	

	public void login() throws Exception{
		String mid = tmId.getText();
		String pwd = tPwd.getText(); // 현재는 일단 불필요
		String msg = "방가 방가";
		int cmd = ChattData.LOGIN;
		
		ChattData cd = new ChattData(mid, cmd, msg);
		ct.oos.writeObject(cd); // ClientThread에 있는 스트림을 가져와서 씀
		ct.oos.flush();
		// flush만 (한번 생성된 소켓 계속 떠야돼서 close는 X)
	}
	
	public void send(){
		
		try {
			String mid = tmId.getText();
			String msg = message.getText();
			int cmd = ChattData.MESSAGE;
			
			ChattData cd = new ChattData(mid, cmd, msg);
			
			if(socket.isConnected()) {
				ct.oos.writeObject(cd);
				ct.oos.flush();
			}
			
		}catch(Exception ex) {
			
		}finally {
			message.setText("");
		}
		
	}

	public JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uC11C\uBC84");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 13));
			label.setBounds(12, 14, 46, 15);
		}
		return label;
	}
	public JTextField getServerIP() {
		if (serverIP == null) {
			serverIP = new JTextField();
			serverIP.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 13));
			serverIP.setColumns(10);
			serverIP.setBounds(58, 10, 137, 21);
			
			try {
				InetAddress local = InetAddress.getLocalHost();
				serverIP.setText(local.getHostAddress());
			}catch(Exception ex){
				
			}
			
		}
		return serverIP;
	}
	public JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("PORT");
			label_1.setHorizontalAlignment(SwingConstants.CENTER);
			label_1.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 13));
			label_1.setBounds(207, 14, 41, 15);
		}
		return label_1;
	}
	public JTextField getPort() {
		if (port == null) {
			port = new JTextField();
			port.setText("4444");
			port.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 13));
			port.setColumns(10);
			port.setBounds(250, 10, 113, 21);
		}
		return port;
	}
	public JButton getButton() {
		if (button == null) {
			button = new JButton("접속");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
				Thread t = new Thread(ClientFrame.this);
				t.run();
				
				}
			});
			button.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 13));
			button.setBounds(375, 10, 78, 46);
		}
		return button;
	}
	public JButton getButton_1() {
		if (button_1 == null) {
			button_1 = new JButton("\uC885\uB8CC");
			button_1.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 13));
			button_1.setBounds(464, 10, 78, 46);
		}
		return button_1;
	}
	public JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(209, 84, 422, 340);
			scrollPane_1.setViewportView(getTextPane());
			scrollPane_1.setColumnHeaderView(getLblNewLabel());
		}
		return scrollPane_1;
	}
	public JButton getButton_2() {
		if (button_2 == null) {
			button_2 = new JButton("\uD574\uC81C");
			button_2.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 13));
			button_2.setBounds(12, 395, 183, 29);
		}
		return button_2;
	}
	public JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 13));
			comboBox.setBounds(12, 434, 185, 23);
			
			comboBox.addItem("전체");
			comboBox.addItem("귓속말");
		}
		return comboBox;
	}
	public JTextField getMessage() {
		if (message == null) {
			message = new JTextField();
			message.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				send();
				
				
					
				}
			});
			message.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 13));
			message.setColumns(10);
			message.setBounds(209, 435, 332, 21);
		}
		return message;
	}
	public JButton getButton_4() {
		if (button_4 == null) {
			button_4 = new JButton("\uC804\uC1A1");
			button_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					send();
					
				}
			});
			button_4.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 13));
			button_4.setBounds(545, 434, 86, 23);
		}
		return button_4;
	}
	public JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("\uC544\uC774\uB514");
			label_2.setHorizontalAlignment(SwingConstants.CENTER);
			label_2.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 13));
			label_2.setBounds(12, 45, 46, 15);
		}
		return label_2;
	}
	public JTextField getTmId() {
		if (tmId == null) {
			tmId = new JTextField();
			tmId.setText("Juhyeon");
			tmId.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 13));
			tmId.setColumns(10);
			tmId.setBounds(58, 41, 137, 21);
		}
		return tmId;
	}
	public JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("\uC554\uD638");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 13));
			label_3.setBounds(207, 44, 41, 15);
		}
		return label_3;
	}
	public JTextField getTPwd() {
		if (tPwd == null) {
			tPwd = new JTextField();
			tPwd.setText("1234");
			tPwd.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 13));
			tPwd.setColumns(10);
			tPwd.setBounds(250, 41, 113, 21);
		}
		return tPwd;
	}
	public JTextPane getTextPane() {
		if (textPane == null) {
			textPane = new JTextPane();
			textPane.setContentType("text/html"); // mime type
			
			textPane.setEditorKit(kit);
			textPane.setDocument(doc);
			
		}
		return textPane;
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uBA54\uC2DC\uC9C0");
			lblNewLabel.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 13));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 84, 185, 304);
			scrollPane.setColumnHeaderView(getLblNewLabel_1());
			scrollPane.setViewportView(getList());
		}
		return scrollPane;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC811\uC18D\uC790");
			lblNewLabel_1.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 13));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_1;
	}
	public JList getList() {
		if (list == null) {
			list = new JList();
			
			list.setModel(model);
		}
		return list;
	}

	
}
