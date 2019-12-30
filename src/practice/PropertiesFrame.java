package practice;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
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
		super(null, true, true, true, true);
		setVisible(true);
		setBounds(100, 100, 450, 300);
		getContentPane().add(getBtnNewButton(), BorderLayout.NORTH);
		getContentPane().add(getScrollPane(), BorderLayout.CENTER);

	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Process");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					try {
						Properties properties = new Properties();
						String path = PropertiesFrame.class.getResource("database.properties").getPath();
						path = URLDecoder.decode(path, "utf-8");
						properties.load(new FileInputStream(path));
						
						String driver = properties.getProperty("driver");
						String url = properties.getProperty("url");
						String username = properties.getProperty("username");
						String password = properties.getProperty("password");
						
						textArea.setText("");
						textArea.append(driver+"\n");
						textArea.append(url + "\n");
						textArea.append(username+"\n");
						textArea.append(password+"\n");
						
					} catch (Exception ex) {

					}

				}
			});
		}
		return btnNewButton;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
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
