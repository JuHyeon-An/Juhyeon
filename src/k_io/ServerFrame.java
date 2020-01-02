package k_io;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

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
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ServerFrame extends JFrame implements Runnable{

	
	ServerSocket server;
	HTMLEditorKit kit = new HTMLEditorKit();
	HTMLDocument doc = new HTMLDocument();
	// document �� ���󿡼� ������ ������ ���´� �� (�������� �ѷ����� ���)
	
	List<ServerThread> clients = new ArrayList<ServerThread>();
	DefaultListModel<String> model = new DefaultListModel<>();
	
	
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JTextField port;
	private JButton startBtn;
	private JButton closeBtn;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_2;
	private JScrollPane scrollPane_1;
	private JTextPane textPane;
	private JButton btnNewButton_2;
	private JButton button;
	private JComboBox comboBox;
	private JTextField message;
	private JButton btnNewButton_3;
	private JLabel lblNewLabel_3;
	private JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) { // ���ν�����
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerFrame frame = new ServerFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ServerFrame() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				serverStop();
				
			}
		});
		setTitle("\uCC44\uD305 \uC11C\uBC84");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getTextField());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getPort());
		contentPane.add(getStartBtn());
		contentPane.add(getCloseBtn());
		contentPane.add(getScrollPane());
		contentPane.add(getScrollPane_1());
		contentPane.add(getBtnNewButton_2());
		contentPane.add(getButton());
		contentPane.add(getComboBox());
		contentPane.add(getMessage());
		contentPane.add(getBtnNewButton_3());
	}
	
	@Override
	public void run() {
		
		try{
			startBtn.setEnabled(false);
			closeBtn.setEnabled(true);
			int p = Integer.parseInt(port.getText());
			server = new ServerSocket(p);
			String html = "<font size='5' color='#4C301D'>������ ���۵�</font>";
			kit.insertHTML(doc, doc.getLength(), html, 0, 0, null);
			
			while(true) {
				html = "<font size='3' color='#4C301D'>[Ŭ���̾�Ʈ ���� �����]</font>";
				kit.insertHTML(doc, doc.getLength(), html, 0, 0, null);

				Socket clientSocket = server.accept();
				ServerThread st = new ServerThread(ServerFrame.this, clientSocket);
				st.start();
				clients.add(st); // ���ӵǾ��ִ� ��� Ŭ���̾�Ʈ�� clients List�� ����
				
				
				InetSocketAddress addr = (InetSocketAddress)clientSocket.getRemoteSocketAddress();
				
				html = "<div style='border:3px solid #5d4433;padding:5px;width:150px'>"
						+addr.getAddress().getHostAddress() + "���� ������"
						+"</div>";
				
				kit.insertHTML(doc, doc.getLength(), html, 0, 0, null);
				textPane.scrollRectToVisible(
						new Rectangle(0, textPane.getHeight()+100, 1, 1) );
				
			}
			
		}catch(Exception ex) {
			System.out.println("���� ���� ������");
		}
		
	}

	public void send() {
		try {
//		���۵� ������ �����
		ChattData cd = new ChattData();
		cd.setmId("���");
		cd.setCommand(ChattData.MESSAGE);
		cd.setMessage(message.getText());
		
		String html = "<div style='border:3px solid #6f594a;padding:3px;"
				+ "background-color:#e0daf0;width:150px'>"
				+ cd.toString()
				+ "</div>";
		
		kit.insertHTML(doc, doc.getLength(), html, 0, 0, null);
		
		if (comboBox.getSelectedIndex() == 0) {
//		��ü�޽��� ������
			sendAll(cd);
		} else {
			int[] indexs = getList_1().getSelectedIndices();
			sendAll(cd, indexs);
		}
		}catch(Exception ex) {
			
		}
	}
	
	public void sendAll(ChattData cd) { // ��ü �޽���
		for(ServerThread st : clients) {
			try {
				st.oos.writeObject(cd);
				st.oos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void sendAll(ChattData cd, int[] to) { // �ӼӸ�
		for (int i = 0; i < to.length; i++) {
			ServerThread st = clients.get(to[i]);
			try {
				st.oos.writeObject(cd);
				st.oos.flush();
			} catch (IOException e) {
				System.out.println("ServerFrame - sendAll()");
			}
			
		}
	}
	
	/*
	 * 1. ��� �����鿡�� ���� ���� �뺸 (GETOUT)
	 * 2. Client�� ServerThread�� ����
	 * 3. ������ ����� ��� ����
	 * 4. serverSocket ����
	 */
	
	public void serverStop() {
		ChattData cd = new ChattData();
		cd.setCommand(ChattData.GETOUT);
		cd.setmId("SERVER");
		sendAll(cd);
		
		clients.clear();
		clients = new ArrayList<ServerThread>();
		
		model.clear(); // �������
		try {
			server.close(); // �������� ����
			server = null;
		} catch (IOException e) {
		}
		
	}
	
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("IP");
			lblNewLabel.setFont(new Font("������������� Regular", Font.PLAIN, 13));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(158, 26, 24, 15);
		}
		return lblNewLabel;
	}
	public JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setFont(new Font("������������� Regular", Font.PLAIN, 13));
			textField.setBounds(184, 23, 137, 21);
			textField.setColumns(10);
			
			try {
				InetAddress local = InetAddress.getLocalHost();
				textField.setText(local.getHostAddress());
			}catch(Exception ex){
				
			}
		}
		return textField;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("PORT");
			lblNewLabel_1.setFont(new Font("������������� Regular", Font.PLAIN, 13));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(333, 26, 41, 15);
		}
		return lblNewLabel_1;
	}
	public JTextField getPort() {
		if (port == null) {
			port = new JTextField();
			port.setText("4444");
			port.setFont(new Font("������������� Regular", Font.PLAIN, 13));
			port.setBounds(377, 23, 86, 21);
			port.setColumns(10);
		}
		return port;
	}
	public JButton getStartBtn() {
		if (startBtn == null) {
			startBtn = new JButton("����");
			startBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Thread t = new Thread(ServerFrame.this);
//					�������� �Ű������� Runnable Ÿ��
					t.start();
					
				}
			});
			startBtn.setFont(new Font("������������� Regular", Font.PLAIN, 13));
			startBtn.setBounds(472, 10, 78, 34);
		}
		return startBtn;
	}
	public JButton getCloseBtn() {
		if (closeBtn == null) {
			closeBtn = new JButton("����");
			closeBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
				closeBtn.setEnabled(false);
				serverStop();
				startBtn.setEnabled(true);
				
				}
			});
			closeBtn.setFont(new Font("������������� Regular", Font.PLAIN, 13));
			closeBtn.setBounds(553, 10, 78, 34);
		}
		return closeBtn;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 48, 185, 343);
			scrollPane.setColumnHeaderView(getLblNewLabel_2());
			scrollPane.setViewportView(getList_1());
		}
		return scrollPane;
	}
	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC811\uC18D\uC790 \uBAA9\uB85D");
			lblNewLabel_2.setFont(new Font("������������� Regular", Font.PLAIN, 13));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_2;
	}
	public JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(209, 49, 422, 375);
			scrollPane_1.setViewportView(getTextPane());
			scrollPane_1.setColumnHeaderView(getLblNewLabel_3());
		}
		return scrollPane_1;
	}
	public JTextPane getTextPane() {
		if (textPane == null) {
			textPane = new JTextPane();
			textPane.setBackground(new Color(255, 250, 250));
			textPane.setFont(new Font("������������� Bold", Font.PLAIN, 12));
			textPane.setContentType("text/html");
			
			textPane.setEditorKit(kit); // ��� ���ڴ� kit��
			textPane.setDocument(doc); // �װͿ� ���� ����
			
		}
		return textPane;
	}
	public JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("����");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
				Object[] indexs = getList_1().getSelectedValues();
				ChattData cd = new ChattData();
				cd.setCommand(ChattData.GETOUT);
				cd.setmId("SERVER");
				List<String> users = new ArrayList<String>();
				for(int i = 0; i<indexs.length; i++) {
					users.add((String)indexs[i]);
				}
				cd.setUsers(users);
				sendAll(cd);
				}
			});
			btnNewButton_2.setFont(new Font("������������� Regular", Font.PLAIN, 13));
			btnNewButton_2.setBounds(12, 395, 84, 29);
		}
		return btnNewButton_2;
	}
	public JButton getButton() {
		if (button == null) {
			button = new JButton("\uC120\uD0DD\uD574\uC81C");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					getList_1().clearSelection();
					
				}
			});
			button.setFont(new Font("������������� Regular", Font.PLAIN, 13));
			button.setBounds(102, 395, 97, 29);
		}
		return button;
	}
	public JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setFont(new Font("������������� Regular", Font.PLAIN, 13));
			comboBox.setBounds(12, 434, 185, 23);
			
			comboBox.addItem("��ü");
			comboBox.addItem("�ӼӸ�");
			
		}
		return comboBox;
	}
	public JTextField getMessage() {
		if (message == null) {
			message = new JTextField();
			message.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					
					if(e.getKeyCode() ==  KeyEvent.VK_ENTER) {
						send();
						message.setText("");
						}
				}
			});
			message.setFont(new Font("������������� Regular", Font.PLAIN, 13));
			message.setBounds(209, 435, 332, 21);
			message.setColumns(10);
		}
		return message;
	}
	public JButton getBtnNewButton_3() {
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("����");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					send();
					message.setText("");
				}
			});
			btnNewButton_3.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
				
				}
			});
			btnNewButton_3.setFont(new Font("������������� Regular", Font.PLAIN, 13));
			btnNewButton_3.setBounds(545, 434, 86, 23);
		}
		return btnNewButton_3;
	}
	public JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uBA54\uC2DC\uC9C0");
			lblNewLabel_3.setFont(new Font("������������� Regular", Font.PLAIN, 13));
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_3;
	}
	public JList getList_1() {
		if (list == null) {
			list = new JList();
			list.setModel(model);
			//ServerThread�� command�� login�� ��������, cd.getmID�� �������� ��
			//ServerThread���� �۾�
		}
		return list;
	}
	

	}
