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
//		프로퍼티 프레임이 있는 위치에 소스들 중에서 database properties가 있는걸 path에 연결

			path = URLDecoder.decode(path, "utf-8");
//			한글이 포함되어있는 경우 utf-8로 디코딩
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
			textArea.setText("오류 발생...");
			textArea.append("\n");
			textArea.append(e.toString());
//			어떤 오류인지 뿌려주기
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
