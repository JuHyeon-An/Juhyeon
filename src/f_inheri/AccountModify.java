package f_inheri;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class AccountModify extends JPanel {
	private JLabel lblNewLabel;
	private JTextField sno;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JTextField mName;
	private JLabel label;
	private JTextField amount;
	private JButton btnNewButton_1;
	private int pos;
	private JLabel status;

	/**
	 * Create the panel.
	 */
	public AccountModify() {
		setLayout(null);
		add(getLblNewLabel());
		add(getSno());
		add(getBtnNewButton());
		add(getLblNewLabel_1());
		add(getMName());
		add(getLabel());
		add(getAmount());
		add(getBtnNewButton_1());
		add(getStatus());

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uACC4\uC815 \uC815\uBCF4 \uC218\uC815");
			lblNewLabel.setForeground(new Color(0, 128, 128));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
			lblNewLabel.setBounds(12, 10, 426, 50);
		}
		return lblNewLabel;
	}

	private JTextField getSno() {
		if (sno == null) {
			sno = new JTextField();
			sno.setBounds(178, 83, 151, 23);
			sno.setColumns(10);
		}
		return sno;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("검색");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String find = sno.getText();
					pos = -1;
					for (int i = 0; i < Bank.count; i++) {
						Account a = Bank.ac[i];
						if (a.getsNo().equals(find)) {
							mName.setText(a.getmName());
							amount.setText(a.getAmount() + "");
							pos = i;
							status.setText("");
							break;
						}else if(find.equals("")) status.setText("계좌정보를 입력하세요.");
						else status.setText("해당 계좌정보가 없습니다.");
					}
				}
			});
			btnNewButton.setBounds(341, 82, 97, 25);
		}
		return btnNewButton;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC608\uAE08\uC8FC");
			lblNewLabel_1.setBounds(45, 142, 57, 15);
		}
		return lblNewLabel_1;
	}

	private JTextField getMName() {
		if (mName == null) {
			mName = new JTextField();
			mName.setBounds(97, 139, 116, 21);
			mName.setColumns(10);
		}
		return mName;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uC608\uAE08\uC561");
			label.setBounds(45, 170, 57, 15);
		}
		return label;
	}

	private JTextField getAmount() {
		if (amount == null) {
			amount = new JTextField();
			amount.setColumns(10);
			amount.setBounds(97, 167, 163, 21);
		}
		return amount;
	}

	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("수정 확인");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					try {
						if (pos >= 0) {
							Account a = Bank.ac[pos];
							Long amt = Long.parseLong(amount.getText());
							a.setmName(mName.getText());
							a.setAmount(amt);
						}
						if (mName.getText().equals("") || amount.getText().equals("")) {
							throw new IOException("내용을 입력하세요.");
						}
					}

					catch (IOException ex2) {
						status.setText(ex2.getMessage());
						sno.requestFocus();
						sno.selectAll();

					} catch (Exception ex) {
						status.setText("예금액에 문자나 공백이 있습니다.");
					}

				}
			});
			btnNewButton_1.setBounds(97, 213, 163, 32);
		}
		return btnNewButton_1;
	}

	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setOpaque(true);
			status.setBackground(new Color(240, 128, 128));
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setBounds(12, 267, 426, 23);
		}
		return status;
	}
}
