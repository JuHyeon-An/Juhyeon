package f_inheri;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class AccountCreate extends JPanel {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField sno;
	private JLabel label;
	private JLabel label_1;
	private JButton btnNewButton;
	private JTextField mName;
	private JTextField amount;
	private JLabel status;

	/**
	 * Create the panel.
	 */
	public AccountCreate() {
		setLayout(null);
		add(getLblNewLabel());
		add(getLblNewLabel_1());
		add(getSno());
		add(getLabel());
		add(getLabel_1());
		add(getBtnNewButton());
		add(getTextField_1_1());
		add(getTextField_2_1());
		add(getStatus());

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uACC4\uC815 \uC0DD\uC131");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setForeground(new Color(0, 128, 128));
			lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
			lblNewLabel.setBounds(12, 10, 426, 50);
		}
		return lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uACC4\uC88C\uBC88\uD638");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
			lblNewLabel_1.setBounds(23, 84, 65, 21);
		}
		return lblNewLabel_1;
	}

	private JTextField getSno() {
		if (sno == null) {
			sno = new JTextField();
			sno.setBounds(100, 86, 159, 23);
			sno.setColumns(10);
		}
		return sno;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uC608\uAE08\uC8FC");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
			label.setBounds(23, 128, 65, 21);
		}
		return label;
	}

	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uC608\uAE08\uC561");
			label_1.setHorizontalAlignment(SwingConstants.CENTER);
			label_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
			label_1.setBounds(23, 173, 65, 21);
		}
		return label_1;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("추가");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 모든 항목이 입력되었는지 체크
					if (!sno.getText().equals("") && !mName.getText().equals("") &&
							!amount.getText().equals("")) { // 모든 항목이 입력됐다면.
						
						try {
							// 계좌번호의 중복 여부 체크	
							for(int i=0; i<Bank.count; i++) {
								Account a = Bank.ac[i];
								if(a.getsNo().equals(sno.getText())){
									throw new IOException("계좌번호가 중복되었습니다.");
								}
							}
							
							// 예금액이 숫자로만 이루어졌는지 체크
							Long amt = Long.parseLong(amount.getText()); // amount Long 타입으로 변환
							Account ac = new Account(mName.getText(), sno.getText(), amt); // 클래스 객체 생성
							Bank.ac[Bank.count] = ac;
							Bank.count++;
							
							status.setText(Bank.count + " 번째 고객이 등록되었습니다.");
							mName.setText("");
							amount.setText("");
							sno.requestFocus();
							sno.selectAll();
							
						}catch(IOException ex2) {
							status.setText(ex2.getMessage());
							sno.requestFocus();
							sno.selectAll();
							
						}catch(Exception ex) {
							status.setText("예금액에 문자나 공백이 있습니다.");
							amount.requestFocus();
							amount.selectAll();
						}
					} // end of if
					else {status.setText("입력항목을 확인하세요");}
				}
			});
			btnNewButton.setFont(new Font("돋움", Font.PLAIN, 14));
			btnNewButton.setBounds(100, 219, 113, 36);
		}
		return btnNewButton;
	}

	private JTextField getTextField_1_1() {
		if (mName == null) {
			mName = new JTextField();
			mName.setColumns(10);
			mName.setBounds(100, 130, 131, 23);
		}
		return mName;
	}

	private JTextField getTextField_2_1() {
		if (amount == null) {
			amount = new JTextField();
			amount.setColumns(10);
			amount.setBounds(100, 175, 159, 23);
		}
		return amount;
	}

	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setOpaque(true);
			status.setBackground(new Color(255, 228, 181));
			status.setBounds(12, 267, 426, 23);
		}
		return status;
	}
}
