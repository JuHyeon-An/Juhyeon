package k_io;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class FileCopy extends JInternalFrame {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField original;
	private JButton btnNewButton;
	private JTextField target;
	private JButton btnNewButton_1;
	private JProgressBar progressBar;
	private JButton btnNewButton_2;
	private JLabel status;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileCopy frame = new FileCopy();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FileCopy() {
		super("파일복사", false, true, true, true);
		getContentPane().setBackground(new Color(240, 255, 240));
		setVisible(true);
		setBounds(100, 100, 501, 220);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getOriginal());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getTarget());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getProgressBar());
		getContentPane().add(getBtnNewButton_2());
		getContentPane().add(getStatus());

	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC6D0\uBCF8\uD30C\uC77C");
			lblNewLabel.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 13));
			lblNewLabel.setBounds(25, 16, 57, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uB300\uC0C1\uD30C\uC77C");
			lblNewLabel_1.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 13));
			lblNewLabel_1.setBounds(25, 49, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JTextField getOriginal() {
		if (original == null) {
			original = new JTextField();
			original.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 13));
			original.setBounds(81, 12, 289, 21);
			original.setColumns(10);
		}
		return original;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uCC3E\uC544\uBCF4\uAE30");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
				JFileChooser fc = new JFileChooser();
				int state = fc.showOpenDialog(FileCopy.this); // 해당메소드 반환형이 int
				if(state == JFileChooser.APPROVE_OPTION) { // 열기버튼 => 상수값
					original.setText(fc.getSelectedFile().getPath());
				}
				}
			});
			btnNewButton.setBackground(new Color(173, 216, 230));
			btnNewButton.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 13));
			btnNewButton.setBounds(376, 12, 97, 23);
		}
		return btnNewButton;
	}
	private JTextField getTarget() {
		if (target == null) {
			target = new JTextField();
			target.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 13));
			target.setBounds(81, 45, 289, 23);
			target.setColumns(10);
		}
		return target;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uB300\uC0C1\uD30C\uC77C");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					JFileChooser fc = new JFileChooser();
					int state = fc.showSaveDialog(FileCopy.this);
					if(state == JFileChooser.APPROVE_OPTION) {
						target.setText(fc.getSelectedFile().getPath());
					}
					
				}
			});
			btnNewButton_1.setBackground(new Color(173, 216, 230));
			btnNewButton_1.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 13));
			btnNewButton_1.setBounds(376, 45, 97, 23);
		}
		return btnNewButton_1;
	}
	private JProgressBar getProgressBar() {
		if (progressBar == null) {
			progressBar = new JProgressBar();
			progressBar.setBounds(12, 82, 461, 15);
		}
		return progressBar;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("\uBCF5\uC0AC\uD558\uAE30");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
				FileCopyThread fct = new FileCopyThread(progressBar);
				fct.setOriginal(original.getText());
				fct.setTarget(target.getText());

				status.setText("파일을 복사중입니다.....");
				
				try {
					fct.join();
					fct.start();
					status.setText("복사가 완료되었습니다");
				}catch(Exception ex) {
				}
				}

			});
			btnNewButton_2.setBackground(new Color(173, 216, 230));
			btnNewButton_2.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 13));
			btnNewButton_2.setBounds(189, 109, 97, 29);
		}
		return btnNewButton_2;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 13));
			status.setOpaque(true);
			status.setBackground(new Color(175, 238, 238));
			status.setBounds(12, 150, 461, 29);
		}
		return status;
	}
}
