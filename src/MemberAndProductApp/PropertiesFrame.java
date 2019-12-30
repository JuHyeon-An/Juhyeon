package MemberAndProductApp;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PropertiesFrame extends JInternalFrame {
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PropertiesFrame frame = new PropertiesFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PropertiesFrame() {
		super("Properties", false, true, true, true);
		setVisible(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getScrollPane());

	}
	
	public void load() {
		try {
			Properties properties = new Properties();
			String path = PropertiesFrame.class.getResource("database.properties").getPath();
//		������Ƽ �������� �ִ� ��ġ�� �ҽ��� �߿��� database properties�� �ִ°� path�� ����

			path = URLDecoder.decode(path, "utf-8");
//			�ѱ��� ���ԵǾ��ִ� ��� utf-8�� ���ڵ�
			properties.load(new FileReader(path));
			String driver = properties.getProperty("driver");
			String url = properties.getProperty("url");
			String userName = properties.getProperty("username");
			String pwd = properties.getProperty("password");
			
			textArea.setText("");
			textArea.append("driver : "+driver + "\n");
			textArea.append("url : "+url + "\n");
			textArea.append("userName : "+userName + "\n");
			textArea.append("pwd : "+pwd + "\n");
			
			
		} catch (Exception e) {
			textArea.setText("���� �߻�...");
			textArea.append("\n");
			textArea.append(e.toString());
//			� �������� �ѷ��ֱ�
		}
	}
	
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Load");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					load();
				}

				
			});
			btnNewButton.setBounds(325, 10, 97, 30);
		}
		return btnNewButton;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 50, 410, 211);
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
}
