package h_api;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;

public class SimpleDateExam extends JInternalFrame {
	private JButton btnNewButton;
	private JLabel status;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleDateExam frame = new SimpleDateExam();
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
	public SimpleDateExam() {
		super("Simple Date Format", false, true, true, true);
		getContentPane().setBackground(new Color(135, 206, 235));
		setVisible(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getStatus());
		getContentPane().add(getLblNewLabel());

	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC624\uB298 \uB0A0\uC9DC \uD074\uB9AD");
			btnNewButton.setBackground(new Color(230, 230, 250));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				Date now = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd (E)요일 hh:mm:ss");
				status.setText(sdf.format(now));
				
				
				}
			});
			btnNewButton.setFont(new Font("나눔스퀘어라운드 Bold", Font.PLAIN, 16));
			btnNewButton.setBounds(194, 25, 187, 39);
		}
		return btnNewButton;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("\uC624\uB298\uC758 \uB0A0\uC9DC\uB294?");
			status.setForeground(new Color(248, 248, 255));
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setFont(new Font("배달의민족 도현", Font.PLAIN, 25));
			status.setBounds(12, 80, 410, 130);
		}
		return status;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\JHTA\\Downloads\\calendar.png"));
			lblNewLabel.setBounds(121, 0, 79, 84);
		}
		return lblNewLabel;
	}
}
