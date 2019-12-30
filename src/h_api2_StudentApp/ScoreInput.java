package h_api2_StudentApp;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

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
	
	public ScoreInput(JLabel status) {
		this();
		this.status = status;
	}
	
	public ScoreInput() {
		setBackground(new Color(255, 228, 196));
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
			lblNewLabel.setForeground(new Color(250, 250, 210));
			lblNewLabel.setOpaque(true);
			lblNewLabel.setBackground(new Color(233, 150, 122));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
			lblNewLabel.setBounds(12, 10, 426, 64);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uD559\uBC88 :");
			lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(12, 91, 57, 21);
		}
		return lblNewLabel_1;
	}
	private JTextField getSno() {
		if (sno == null) {
			sno = new JTextField();
			sno.setBounds(81, 94, 262, 21);
			sno.setColumns(10);
		}
		return sno;
	}
	private JTextField getIrum() {
		if (irum == null) {
			irum = new JTextField();
			irum.setColumns(10);
			irum.setBounds(81, 141, 262, 21);
		}
		return irum;
	}
	private JTextField getScore() {
		if (score == null) {
			score = new JTextField();
			score.setColumns(10);
			score.setBounds(81, 191, 262, 21);
		}
		return score;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uC774\uB984 :");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
			label.setBounds(12, 139, 57, 21);
		}
		return label;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uC810\uC218 :");
			label_1.setHorizontalAlignment(SwingConstants.CENTER);
			label_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
			label_1.setBounds(12, 189, 57, 21);
		}
		return label_1;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("성적 입력");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(!sno.getText().equals("") && !irum.getText().equals("") && 
							!score.getText().equals("")) {
					
					try {
					
					int n = Integer.parseInt(sno.getText()); // 학번은 정수형이라서 Integer로 만들기
					int s = Integer.parseInt(score.getText());// 마찬가지로 성적도 정수형 parsing
					Student st = new Student(n, irum.getText(), s);
					StudentApp.st[StudentApp.count] = st;
					StudentApp.count++;
					
					status.setText(StudentApp.count+"번째 학생이 입력되었습니다.");
					sno.setText("");
					irum.setText("");
					score.setText("");
						} catch (Exception ex) {
							status.setText("학번과 성적에는 숫자만 입력할 수 있습니다");
						}
					} else
						status.setText("항목을 모두 입력하세요.");
					
				}
			});
			btnNewButton.setBounds(152, 222, 140, 43);
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
