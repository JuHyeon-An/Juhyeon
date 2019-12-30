package f_inheri;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AccountList extends JPanel {
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JLabel lblNewLabel_1;

	/**
	 * Create the panel.
	 */
	public AccountList() {
		setLayout(null);
		add(getLblNewLabel());
		add(getScrollPane());
		showList();
	}

	public void showList() {
		String str = "";
		DecimalFormat df = new DecimalFormat("##,###,###,###.#"); // 100억 + 소수점 1자리까지
//		객체 df 생성
		for (int i = 0; i < Bank.count; i++) {
			Account a = Bank.ac[i];
			str += "\t" + a.getsNo();
			str += "\t" + a.getmName();
			str += "\t" + df.format(a.getAmount()); // format은 String 타입
			str += "\n";
		}
		textArea.setText(str);
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uACC4\uC815 \uBAA9\uB85D");
			lblNewLabel.setForeground(new Color(0, 128, 128));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
			lblNewLabel.setBounds(12, 10, 426, 50);
		}
		return lblNewLabel;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(22, 70, 416, 220);
			scrollPane.setViewportView(getTextArea());
			scrollPane.setColumnHeaderView(getLblNewLabel_1());
		}
		return scrollPane;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uACC4\uC88C\uBC88\uD638                    \uC608\uAE08\uC8FC                     \uC608\uAE08 \uC794\uC561     ");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_1;
	}
}
