package h_api;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScoreInput extends JPanel {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField sno;
	private JTextField irum;
	private JTextField score;
	private JLabel label;
	private JLabel label_1;
	private JButton btnNewButton;
	private JLabel status;

	/**
	 * Create the panel.
	 */
	public ScoreInput() {
		setLayout(null);
		add(getLblNewLabel());
		add(getLblNewLabel_1());
		add(getSno());
		add(getIrum());
		add(getScore());
		add(getLabel());
		add(getLabel_1());
		add(getBtnNewButton());
		add(getStatus());

	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC131\uC801\uC785\uB825");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
			lblNewLabel.setBounds(12, 10, 426, 64);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uD559\uBC88");
			lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(12, 91, 57, 21);
		}
		return lblNewLabel_1;
	}
	private JTextField getSno() {
		if (sno == null) {
			sno = new JTextField();
			sno.setBounds(81, 94, 168, 21);
			sno.setColumns(10);
		}
		return sno;
	}
	private JTextField getIrum() {
		if (irum == null) {
			irum = new JTextField();
			irum.setColumns(10);
			irum.setBounds(81, 141, 168, 21);
		}
		return irum;
	}
	private JTextField getScore() {
		if (score == null) {
			score = new JTextField();
			score.setColumns(10);
			score.setBounds(81, 191, 168, 21);
		}
		return score;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uC774\uB984");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
			label.setBounds(12, 139, 57, 21);
		}
		return label;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uC810\uC218");
			label_1.setHorizontalAlignment(SwingConstants.CENTER);
			label_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
			label_1.setBounds(12, 189, 57, 21);
		}
		return label_1;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC785\uB825");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int n = Integer.parseInt(sno.getText());
					int s = Integer.parseInt(score.getText());
					Student st = new Student(n, irum.getText(), s);
					StudentApp.st[StudentApp.count] = st;
					StudentApp.count++;
					sno.setText("");
					irum.setText("");
					score.setText("");
					status.setText("ÀÔ·ÂÀÌ ¿Ï·áµÇ¾ú½À´Ï´Ù.");
				}
			});
			btnNewButton.setBounds(140, 222, 130, 36);
		}
		return btnNewButton;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setBounds(12, 275, 426, 15);
		}
		return status;
	}
}
