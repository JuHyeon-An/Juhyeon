package MemberAndProductApp;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductOutput extends JInternalFrame {
	
	Set<ProductVo> peList;
	
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JTextField pCode;
	private JTextField pName;
	private JTextField ea;
	private JTextField nal;
	private JButton button;
	private JLabel status;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductOutput frame = new ProductOutput();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ProductOutput() {
		super("출고", false, true, true, true);
		setVisible(true);
		getContentPane().setBackground(new Color(240, 255, 255));
		setTitle("\uC81C\uD488 \uCD9C\uACE0");
		setBounds(100, 100, 351, 240);
		getContentPane().setLayout(null);
		getContentPane().add(getLabel());
		getContentPane().add(getLabel_1());
		getContentPane().add(getLabel_2());
		getContentPane().add(getLabel_3());
		getContentPane().add(getPCode());
		getContentPane().add(getPName());
		getContentPane().add(getEa());
		getContentPane().add(getNal());
		getContentPane().add(getButton());
		getContentPane().add(getStatus());
		getContentPane().add(getLblNewLabel());

	}

	public ProductOutput(Set<ProductVo> peList) {
		this();
		this.peList = peList;
	}
	
	
	public void output() {
//		폼의 값을 가져다 ProductVo 생성
//		peList에 추가하는 작업
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
//		입력항목이 공백인 경우 (무결성 체크)
		
		try {
			String tempSerial = sdf.format(new Date()) + "-"+ MemberMain.eSerial;

			String c = pCode.getText();
			String n = pName.getText();
			int qt = Integer.parseInt(ea.getText());
			Date d = sdf.parse(nal.getText());

			if(c.equals("")||n.equals("")||ea.getText().equals("")||nal.getText().equals("")) {
				status.setText("모든 항목을 입력해주세요");
			} else {
			
			ProductVo vo = new ProductVo(tempSerial, c, n, qt, d);
			peList.add(vo);

			pCode.setText("");
			pName.setText("");
			ea.setText("");

			status.setText("출고 자료가 정상적으로 입력되었습니다");
			MemberMain.eSerial++;
			}
		} catch (ParseException ex) {
			status.setText("날짜 형식을 yyyy-MM-dd 으로 입력해주세요");
			nal.requestFocus();
			nal.selectAll();
		} catch (NumberFormatException e2) {
			status.setText("수량에 공백이나 문자가 있습니다");
			ea.requestFocus();
			ea.selectAll();
		}
	}
	
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uC81C\uD488\uCF54\uB4DC");
			label.setForeground(new Color(0, 139, 139));
			label.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
			label.setBounds(12, 13, 57, 15);
		}
		return label;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uC81C\uD488\uBA85");
			label_1.setForeground(new Color(0, 139, 139));
			label_1.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
			label_1.setBounds(12, 38, 57, 15);
		}
		return label_1;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("\uCD9C\uACE0 \uC218\uB7C9");
			label_2.setForeground(new Color(0, 139, 139));
			label_2.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
			label_2.setBounds(12, 63, 57, 15);
		}
		return label_2;
	}
	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("\uCD9C\uACE0\uC77C\uC790");
			label_3.setForeground(new Color(0, 139, 139));
			label_3.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
			label_3.setBounds(12, 88, 57, 15);
		}
		return label_3;
	}
	private JTextField getPCode() {
		if (pCode == null) {
			pCode = new JTextField();
			pCode.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
			pCode.setColumns(10);
			pCode.setBounds(81, 10, 116, 21);
		}
		return pCode;
	}
	private JTextField getPName() {
		if (pName == null) {
			pName = new JTextField();
			pName.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
			pName.setColumns(10);
			pName.setBounds(81, 35, 181, 21);
		}
		return pName;
	}
	private JTextField getEa() {
		if (ea == null) {
			ea = new JTextField();
			ea.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
			ea.setColumns(10);
			ea.setBounds(81, 60, 75, 21);
		}
		return ea;
	}
	private JTextField getNal() {
		if (nal == null) {
			nal = new JTextField();
			nal.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
			nal.setColumns(10);
			nal.setBounds(81, 85, 116, 21);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 필드로 빼도 됨
			nal.setText(sdf.format(new Date()));
		}
		return nal;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("\uCD9C\uACE0");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					output();
				}

				
			});
			button.setBackground(new Color(176, 224, 230));
			button.setFont(new Font("나눔스퀘어라운드 Bold", Font.PLAIN, 13));
			button.setBounds(81, 116, 104, 32);
		}
		return button;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.addAncestorListener(new AncestorListener() {
				public void ancestorAdded(AncestorEvent event) {
				}
				public void ancestorMoved(AncestorEvent event) {
				}
				public void ancestorRemoved(AncestorEvent event) {
				}
			});
			status.setOpaque(true);
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setFont(new Font("나눔고딕", Font.PLAIN, 13));
			status.setBackground(new Color(135, 206, 235));
			status.setBounds(12, 171, 311, 27);
		}
		return status;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\JHTA\\Downloads\\cargo (1).png"));
			lblNewLabel.setBounds(231, 88, 104, 74);
		}
		return lblNewLabel;
	}
}
