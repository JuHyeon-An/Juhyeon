package MemberAndProductApp;

import java.awt.EventQueue;
import java.util.Date;
import java.util.Set;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Color;

public class ProductInput extends JInternalFrame {
	
	Set <ProductVo> piList; 
	private JLabel lblNewLabel;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JTextField pCode;
	private JTextField pName;
	private JTextField ea;
	private JTextField nal;
	private JButton btnNewButton;
	private JLabel status;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductInput frame = new ProductInput();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	public ProductInput() {
		super("��ǰ �԰�", false, true, true, true);
		setVisible(true);
		getContentPane().setBackground(new Color(173, 216, 230));
		getContentPane().setFont(new Font("�������", Font.PLAIN, 12));
		setBounds(100, 100, 327, 249);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLabel());
		getContentPane().add(getLabel_1());
		getContentPane().add(getLabel_2());
		getContentPane().add(getPCode());
		getContentPane().add(getPName());
		getContentPane().add(getEa());
		getContentPane().add(getNal());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getStatus());
	}

	public ProductInput(Set <ProductVo> pi) {
		this(); // �̰� ������ UI�� �������� ������
		this.piList = pi;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC81C\uD488\uCF54\uB4DC");
			lblNewLabel.setFont(new Font("�����ٸ����", Font.PLAIN, 12));
			lblNewLabel.setBounds(12, 25, 57, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uC81C\uD488\uBA85");
			label.setFont(new Font("�����ٸ����", Font.PLAIN, 12));
			label.setBounds(12, 50, 57, 15);
		}
		return label;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uC218\uB7C9");
			label_1.setFont(new Font("�����ٸ����", Font.PLAIN, 12));
			label_1.setBounds(12, 75, 57, 15);
		}
		return label_1;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("\uC785\uACE0\uC77C\uC790");
			label_2.setFont(new Font("�����ٸ����", Font.PLAIN, 12));
			label_2.setBounds(12, 100, 57, 15);
		}
		return label_2;
	}
	private JTextField getPCode() {
		if (pCode == null) {
			pCode = new JTextField();
			pCode.setBounds(81, 22, 116, 21);
			pCode.setColumns(10);
		}
		return pCode;
	}
	private JTextField getPName() {
		if (pName == null) {
			pName = new JTextField();
			pName.setColumns(10);
			pName.setBounds(81, 47, 181, 21);
		}
		return pName;
	}
	private JTextField getEa() {
		if (ea == null) {
			ea = new JTextField();
			ea.setColumns(10);
			ea.setBounds(81, 72, 75, 21);
		}
		return ea;
	}
	private JTextField getNal() {
		if (nal == null) {
			nal = new JTextField();
			nal.setColumns(10);
			nal.setBounds(81, 97, 116, 21);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			nal.setText(sdf.format(new Date()));
		}
		return nal;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("�԰�");
			btnNewButton.setBackground(new Color(245, 255, 250));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					
					if(pCode.getText().equals("")|pName.getText().equals("")|ea.getText().equals("")) {
						status.setText("�� �׸��� �ֽ��ϴ�");
						pCode.requestFocus();
						pCode.selectAll();
						return; // �ؿ� ����Ǳ� ���� if���� ���� ����ǰ� �ϱ� ���ؼ� (�ؿ� ����Ǹ� status ��°��� �ٲ�)
					} 
					
					try {
						String tempSerial = sdf.format(new Date()) + "-" + MemberMain.iSerial;

						String c = pCode.getText();
						String n = pName.getText();
						int qt = Integer.parseInt(ea.getText());
						Date d = sdf.parse(nal.getText()); // ���ڿ��� �Ǿ��ִ� ������ ��¥��ü��

						ProductVo vo = new ProductVo(tempSerial, c, n, qt, d);
						piList.add(vo); // vo�� �ؽ��ڵ带 ȣ���ؼ� �ø����ȣ�� ������ �Ǵ��Ͽ� �߰������� ���� X

						pCode.setText("");
						pName.setText("");
						ea.setText("");

						status.setText("�Է��� �Ϸ�Ǿ����ϴ�");
						MemberMain.iSerial++;
					} catch (ParseException ex) {
						status.setText("�ùٸ� ��¥���� �Է�");
					} catch (NumberFormatException ex2) {
						status.setText("������ ���ڸ� ����");
					}
				}
			});
			btnNewButton.setFont(new Font("������������� Bold", Font.PLAIN, 13));
			btnNewButton.setBounds(81, 128, 104, 32);
		}
		return btnNewButton;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setOpaque(true);
			status.setBackground(new Color(175, 238, 238));
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setFont(new Font("�������", Font.PLAIN, 13));
			status.setBounds(12, 178, 287, 32);
		}
		return status;
	}
}
