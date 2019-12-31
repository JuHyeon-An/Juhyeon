package k_io;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.net.InetAddress;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InetAddressFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTextField textField;
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
					InetAddressFrame frame = new InetAddressFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InetAddressFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 321);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.NORTH);
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
		
		try {
			InetAddress local = InetAddress.getLocalHost();
//			로컬 컴퓨터의 InetAddress 얻기
			setTitle(local.getHostAddress());
		}catch(Exception ex) {}
	}

	
	
	
	public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(10, 26));
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getTextField(), BorderLayout.CENTER);
			panel.add(getBtnNewButton(), BorderLayout.EAST);
		}
		return panel;
	}
	public JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
		}
		return textField;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("검색");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					String domain = textField.getText();
					try {
						InetAddress[] addr = InetAddress.getAllByName(domain);
//						DNS에 등록된 모든 ip주소 (리턴타입은 InerAddress 배열)
						textArea.setText("");
						for (InetAddress ad : addr) {
							textArea.append(ad.getHostAddress() + "\n");
//							InetAddress 객체에서 IP 주소를 얻는 작업
						}
					} catch (Exception ex) {
						textArea.setText(ex.toString());
					}
				}
			});
		}
		return btnNewButton;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	public JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
}
