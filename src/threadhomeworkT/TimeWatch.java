package threadhomeworkT;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class TimeWatch extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel label;
	private JPanel panel;
	private JButton btnNewButton;
	private JButton btnSto;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private JLabel label_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimeWatch frame = new TimeWatch();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public TimeWatch() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getTextField());
		contentPane.add(getLabel());
		contentPane.add(getPanel());
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnSto());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLabel_1());
		
		DateTimeThread dt = new DateTimeThread(textField);
		dt.setDaemon(true); // 메인 종료시키면 dt 스레드도 중지시키도록!
		dt.start();
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC2DC\uACC4");
			lblNewLabel.setFont(new Font("배달의민족 도현", Font.PLAIN, 20));
			lblNewLabel.setBounds(54, 10, 68, 22);
		}
		return lblNewLabel;
	}

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setForeground(new Color(240, 255, 255));
			textField.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setText("2019-12-18(\uC218) 17:08:01");
			textField.setBackground(new Color(102, 205, 170));
			textField.setFont(new Font("나눔스퀘어라운드 Regular", Font.BOLD, 20));
			textField.setBounds(12, 42, 410, 63);
			textField.setColumns(10);
		}
		return textField;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uC2A4\uD1B1\uC6CC\uCE58");
			label.setFont(new Font("배달의민족 도현", Font.PLAIN, 17));
			label.setBounds(12, 103, 110, 31);
		}
		return label;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new StopWatchThread();
			panel.setBackground(new Color(245, 255, 250));
			panel.setBounds(12, 135, 410, 79);
		}
		return panel;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("START");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					StopWatchThread st = (StopWatchThread)panel; // panel을 강제 캐스팅
					st.flag = false;
					Thread t = new Thread(st);
					t.setDaemon(true);
					t.start();
				}
			});
			btnNewButton.setBackground(new Color(143, 188, 143));
			btnNewButton.setFont(new Font("배달의민족 주아", Font.PLAIN, 14));
			btnNewButton.setBounds(118, 224, 97, 23);
		}
		return btnNewButton;
	}

	private JButton getBtnSto() {
		if (btnSto == null) {
			btnSto = new JButton("STOP");
			btnSto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					StopWatchThread st = (StopWatchThread)panel;
					st.flag = true;
				}
			});
			btnSto.setBackground(new Color(143, 188, 143));
			btnSto.setFont(new Font("배달의민족 주아", Font.PLAIN, 14));
			btnSto.setBounds(247, 224, 97, 23);
		}
		return btnSto;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setBounds(12, 0, 54, 44);
		}
		return lblNewLabel_1;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("New label");
			label_1.setBounds(12, 42, 57, 15);
		}
		return label_1;
	}
}
