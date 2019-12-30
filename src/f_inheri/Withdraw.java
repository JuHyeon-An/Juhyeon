package f_inheri;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Withdraw extends JPanel {
	private JLabel lblNewLabel;
	private JTextField mName;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JTextField sno;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JTextField amount;
	private JTextField wAmt;
	private JButton btnNewButton_1;
	
	private int pos;
	private JLabel status;

	/**
	 * Create the panel.
	 */
	public Withdraw() {
		setBackground(new Color(255, 218, 185));
		setLayout(null);
		add(getLblNewLabel());
		add(getMName());
		add(getBtnNewButton());
		add(getLblNewLabel_1());
		add(getSno());
		add(getLabel());
		add(getLabel_1());
		add(getLabel_2());
		add(getAmount());
		add(getWAmt());
		add(getBtnNewButton_1());
		add(getStatus());

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uCD9C\uAE08");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setForeground(new Color(0, 128, 128));
			lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
			lblNewLabel.setBounds(12, 10, 426, 50);
		}
		return lblNewLabel;
	}
	private JTextField getMName() {
		if (mName == null) {
			mName = new JTextField();
			mName.setEditable(false);
			mName.setBounds(76, 140, 144, 21);
			mName.setColumns(10);
		}
		return mName;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("검색");
			btnNewButton.setBackground(new Color(240, 128, 128));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DecimalFormat df = new DecimalFormat("##,###,###,###.#");
					String find = sno.getText();
					pos = -1;
					
					for(int i = 0; i < Bank.count; i++) {
						Account a = Bank.ac[i];
						if(find.equals(a.getsNo())) {
							mName.setText(a.getmName());
							amount.setText(df.format(a.getAmount()));
							pos = i;
							break;							
						}else if(find.equals("")) {
							status.setText("계좌정보를 입력하세요.");
						}else status.setText("해당 계좌번호가 없습니다.");
					}
					
				}
			});
			btnNewButton.setBounds(196, 107, 97, 23);
		}
		return btnNewButton;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uACC4\uC88C\uBC88\uD638");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(12, 111, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JTextField getSno() {
		if (sno == null) {
			sno = new JTextField();
			sno.setBounds(76, 108, 116, 21);
			sno.setColumns(10);
		}
		return sno;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uC608\uAE08\uC8FC");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setBounds(12, 143, 57, 15);
		}
		return label;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uD604 \uC794\uC561");
			label_1.setHorizontalAlignment(SwingConstants.CENTER);
			label_1.setBounds(12, 174, 57, 15);
		}
		return label_1;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("\uCD9C\uAE08\uC561");
			label_2.setHorizontalAlignment(SwingConstants.CENTER);
			label_2.setBounds(12, 205, 57, 15);
		}
		return label_2;
	}
	private JTextField getAmount() {
		if (amount == null) {
			amount = new JTextField();
			amount.setEditable(false);
			amount.setColumns(10);
			amount.setBounds(76, 171, 144, 21);
		}
		return amount;
	}
	private JTextField getWAmt() {
		if (wAmt == null) {
			wAmt = new JTextField();
			wAmt.setColumns(10);
			wAmt.setBounds(76, 202, 198, 21);
		}
		return wAmt;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("출금");
			btnNewButton_1.setBackground(new Color(240, 128, 128));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					long amt = Long.parseLong(wAmt.getText());
					if (pos >= 0) {
						Account a = Bank.ac[pos];
						if (a.getAmount() < amt) {
							status.setText("잔액이 부족합니다.");
						} else {
							long temp = a.getAmount() - amt;
							a.setAmount(temp);
							status.setText("출금이 완료되었습니다.");
						}
					}
				}
			});
			btnNewButton_1.setBounds(76, 233, 115, 36);
		}
		return btnNewButton_1;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setHorizontalTextPosition(SwingConstants.CENTER);
			status.setOpaque(true);
			status.setBackground(new Color(255, 160, 122));
			status.setBounds(12, 279, 426, 21);
		}
		return status;
	}
}
