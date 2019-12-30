package f_inheri;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Deposit extends JPanel {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField sno;
	private JButton btnNewButton;
	private JLabel label;
	private JTextField mName;
	private JLabel label_1;
	private JTextField amount;
	private JButton button;
	private int pos = 0;
	private JLabel status;

	/**
	 * Create the panel.
	 */
	public Deposit() {
		setLayout(null);
		add(getLblNewLabel());
		add(getLblNewLabel_1());
		add(getSno());
		add(getBtnNewButton());
		add(getLabel());
		add(getMName());
		add(getLabel_1());
		add(getAmount());
		add(getButton());
		add(getStatus());

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC608\uAE08");
			lblNewLabel.setForeground(new Color(0, 128, 128));
			lblNewLabel.setFont(new Font("���� ���", Font.BOLD, 30));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(12, 10, 426, 50);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uACC4\uC88C\uBC88\uD638");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(26, 90, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JTextField getSno() {
		if (sno == null) {
			sno = new JTextField();
			sno.setBounds(85, 87, 116, 21);
			sno.setColumns(10);
		}
		return sno;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("�˻�");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String find = sno.getText();
					pos = -1;
					
					for (int i = 0; i < Bank.count; i++) {
						Account a = Bank.ac[i];
						if (a.getsNo().equals(find)) {
							mName.setText(a.getmName());
							pos = i;
							status.setText("");
							break;
						} else if (find.equals("")) {
							mName.setText("");
							status.setText("���������� �Է��ϼ���.");
						} else {
							mName.setText("");
							status.setText("��ġ�ϴ� ���������� �����ϴ�.");
						}
					}

				}
			});
			btnNewButton.setBounds(213, 86, 97, 23);
		}
		return btnNewButton;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uC608\uAE08\uC8FC");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setBounds(26, 125, 57, 15);
		}
		return label;
	}
	private JTextField getMName() {
		if (mName == null) {
			mName = new JTextField();
			mName.setEditable(false);
			mName.setColumns(10);
			mName.setBounds(85, 122, 116, 21);
		}
		return mName;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uC608\uAE08\uC561");
			label_1.setHorizontalAlignment(SwingConstants.CENTER);
			label_1.setBounds(26, 156, 57, 15);
		}
		return label_1;
	}
	private JTextField getAmount() {
		if (amount == null) {
			amount = new JTextField();
			amount.setBounds(85, 153, 159, 21);
			amount.setColumns(10);
		}
		return amount;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("�Ա�ó��");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {

						Long amt = Long.parseLong(amount.getText()); // ���� (�߰�) �Աݾ�
						if (pos >= 0) {
							if (amt < 0) {
								status.setText("����� �Է����ּ���");
							} else {
							Account a = Bank.ac[pos];
							long temp = a.getAmount() + amt; // ������ �ݾ�
							a.setAmount(temp);
							status.setText("�Ա��� �Ϸ�Ǿ����ϴ�.");
							mName.setText("");
							sno.setText("");
							amount.setText("");
							sno.requestFocus();
							}
						}
						
					} catch (Exception ex) {
						status.setText("���ݾ׿� ���ڳ� ������ �ֽ��ϴ�.");
					}

				}
			});
			button.setBounds(85, 184, 143, 50);
		}
		return button;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setOpaque(true);
			status.setBackground(new Color(255, 165, 0));
			status.setBounds(12, 269, 426, 21);
		}
		return status;
	}
}
