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
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_2;
	private JScrollPane scrollPane_1;
	private JTextPane textPane;
	private JButton btnNewButton_2;
	private JButton button;
	private JComboBox comboBox;
	private JTextField textField_2;
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
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnNewButton_1());
		contentPane.add(getScrollPane());
		contentPane.add(getScrollPane_1());
		contentPane.add(getBtnNewButton_2());
		contentPane.add(getButton());
		contentPane.add(getComboBox());
		contentPane.add(getTextField_2());
		contentPane.add(getBtnNewButton_3());
	}
	
	@Override
	public void run() {
		
		try{
			int p = Integer.parseInt(port.getText());
			server = new ServerSocket(p);
			String html = "<font size='5' color='#4C301D'>������ ���۵�</font>";
			kit.insertHTML(doc, doc.getLength(), html, 0, 0, null);
			
			while(true) {
				html = "[Ŭ���̾�Ʈ ���� �����]";
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
			ex.printStackTrace();
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
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("����");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Thread t = new Thread(ServerFrame.this);
//					�������� �Ű������� Runnable Ÿ��
					t.start();
					
				}
			});
			btnNewButton.setFont(new Font("������������� Regular", Font.PLAIN, 13));
			btnNewButton.setBounds(472, 10, 78, 34);
		}
		return btnNewButton;
	}
	public JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC885\uB8CC");
			btnNewButton_1.setFont(new Font("������������� Regular", Font.PLAIN, 13));
			btnNewButton_1.setBounds(553, 10, 78, 34);
		}
		return btnNewButton_1;
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
			btnNewButton_2 = new JButton("\uAC15\uD1F4");
			btnNewButton_2.setFont(new Font("������������� Regular", Font.PLAIN, 13));
			btnNewButton_2.setBounds(12, 395, 84, 29);
		}
		return btnNewButton_2;
	}
	public JButton getButton() {
		if (button == null) {
			button = new JButton("\uC120\uD0DD\uD574\uC81C");
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
	public JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setFont(new Font("������������� Regular", Font.PLAIN, 13));
			textField_2.setBounds(209, 435, 332, 21);
			textField_2.setColumns(10);
		}
		return textField_2;
	}
	public JButton getBtnNewButton_3() {
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("\uC804\uC1A1");
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
