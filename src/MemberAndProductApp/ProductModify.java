package MemberAndProductApp;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class ProductModify extends JInternalFrame {
	
	Set<ProductVo> piList;
	Set<ProductVo> peList;
	Set<ProductVo> list; // 검색, 수정, 삭제에서 다함께 사용해야함
//	클래스의 공용으로 사용 (메소드에서 실행)
	
	ButtonGroup group = new ButtonGroup();
	ProductVo oldVo; // 수정, 삭제 전 데이터
	
	private JLabel lblNewLabel;
	private JRadioButton imBtn;
	private JRadioButton exBtn;
	private JLabel lblNewLabel_1;
	private JTextField serial;
	private JButton btnNewButton;
	private JSeparator separator;
	private JLabel lblNewLabel_2;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JTextField pCode;
	private JTextField pName;
	private JTextField ea;
	private JTextField nal;
	private JButton btnNewButton_1;
	private JButton button;
	private JLabel status;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductModify frame = new ProductModify();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}

	public ProductModify() {
		super("제품 수정/삭제", false, true, true, true);
		getContentPane().setBackground(new Color(255, 240, 245));
		setVisible(true);
		setBounds(100, 100, 343, 300);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getImBtn());
		getContentPane().add(getExBtn());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getSerial());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getSeparator_1());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getLabel());
		getContentPane().add(getLabel_1());
		getContentPane().add(getLabel_2());
		getContentPane().add(getPCode());
		getContentPane().add(getPName());
		getContentPane().add(getEa());
		getContentPane().add(getNal());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getButton());
		getContentPane().add(getStatus());
	}

	public ProductModify(Set<ProductVo> pi, Set<ProductVo> pe) {
		this();
		this.piList = pi;
		this.peList = pe;
	}
	
	public void search() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String findSerial = serial.getText();

		if (imBtn.isSelected()) {
			list = piList;
		} else
			list = peList;

//		oldVo = null; // 두번째 검색 후에도 못 찾았어도 이전 데이터를 갖고 있기 때문에 null로 셋팅
//		status.setText("자료를 검색중입니다.");
//		for (ProductVo vo : list) {
//			if(vo.getSerial().equals(findSerial)) {
//				oldVo = vo;
//				pCode.setText(vo.getpCode());
//				pName.setText(vo.getpName());
//				ea.setText(vo.getEa()+"");
////				ea.setText( String.valueOf(vo.getEa()) );
//				nal.setText(sdf.format(oldVo.getNal()));
//				status.setText("자료를 찾았습니다");
//				break;
//			}
//		}
//		
//		if(oldVo == null) {
//			pCode.setText("");
//			pName.setText("");
//			ea.setText("");
//			nal.setText("");
//			status.setText("자료가 없습니다.");
//			serial.requestFocus();
//			serial.selectAll();
//		}
		oldVo = null;
		int flag = -1;
		Iterator<ProductVo> iter = list.iterator();
		while (iter.hasNext()) {
			ProductVo pv = iter.next();
			oldVo = pv;
			if (findSerial.equals(pv.getSerial())) {
				pCode.setText(pv.getpCode());
				pName.setText(pv.getpName());
				ea.setText(pv.getEa() + "개");
				nal.setText(sdf.format(pv.getNal()));
				status.setText("조회가 완료되었습니다");
				flag++;
				break;
			}
		}
			if(flag == -1) {
			status.setText("검색어를 다시 입력해주세요");
			pCode.setText("");
			pName.setText("");
			ea.setText("");
			nal.setText("");
			serial.requestFocus();
			serial.selectAll();
			}
		
	}
	
	public void modify(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			if (oldVo != null) {
				String s = serial.getText();
				String pC = pCode.getText();
				String pN = pName.getText();
				int e = Integer.parseInt(ea.getText());
				Date n = sdf.parse(nal.getText());

				list.remove(oldVo);

				ProductVo newPv = new ProductVo(s, pC, pN, e, n);
				list.add(newPv);
				status.setText("자료가 수정되었습니다");
				serial.requestFocus();
				serial.selectAll();
			} else {
				status.setText("먼저 검색 후 수정하세요");
			}
		} catch (ParseException e) {
			status.setText("날짜 형식이 잘못되었습니다.");
			nal.requestFocus();
			nal.selectAll();
		} catch (NumberFormatException ex) {
			status.setText("수량을 확인해주세요");
			ea.requestFocus();
			ea.selectAll();
		}
	}
	
	public void delete() {
		if(oldVo != null) { // 검색에서 찾았을 경우
			list.remove(oldVo); // 이때 hashCode를 실행, 똑같으면 equals 호출
//			hashCode가 재정의되어있지 않다면 제대로 실행되지 X
			pCode.setText("");
			pName.setText("");
			ea.setText("");
			nal.setText("");
			status.setText("자료가 삭제되었습니다");
		}else {
			status.setText("먼저 검색 후 삭제하세요");
		}
	}
	
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uAD6C\uBD84");
			lblNewLabel.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
			lblNewLabel.setBounds(12, 24, 57, 15);
		}
		return lblNewLabel;
	}
	private JRadioButton getImBtn() {
		if (imBtn == null) {
			imBtn = new JRadioButton("\uC785\uACE0");
			imBtn.setBackground(new Color(255, 240, 245));
			imBtn.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
			imBtn.setBounds(68, 20, 57, 23);
			group.add(imBtn);
			imBtn.setSelected(true);
		}
		return imBtn;
	}
	private JRadioButton getExBtn() {
		if (exBtn == null) {
			exBtn = new JRadioButton("\uCD9C\uACE0");
			exBtn.setBackground(new Color(255, 240, 245));
			exBtn.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
			exBtn.setBounds(136, 20, 57, 23);
			group.add(exBtn);
		}
		return exBtn;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC2DC\uB9AC\uC5BC");
			lblNewLabel_1.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(12, 49, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JTextField getSerial() {
		if (serial == null) {
			serial = new JTextField();
			serial.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
			serial.setBounds(68, 46, 150, 21);
			serial.setColumns(10);
		}
		return serial;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					search();
				}
			});
			btnNewButton.setForeground(new Color(248, 248, 255));
			btnNewButton.setBackground(new Color(186, 85, 211));
			btnNewButton.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
			btnNewButton.setBounds(230, 45, 67, 23);
		}
		return btnNewButton;
	}
	private JSeparator getSeparator_1() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(12, 74, 294, 2);
		}
		return separator;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC81C\uD488\uCF54\uB4DC");
			lblNewLabel_2.setFont(new Font("나눔고딕", Font.PLAIN, 13));
			lblNewLabel_2.setBounds(12, 86, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uC81C\uD488\uBA85");
			label.setFont(new Font("나눔고딕", Font.PLAIN, 13));
			label.setBounds(12, 111, 57, 15);
		}
		return label;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uC218\uB7C9");
			label_1.setFont(new Font("나눔고딕", Font.PLAIN, 13));
			label_1.setBounds(12, 136, 57, 15);
		}
		return label_1;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("\uB0A0\uC9DC");
			label_2.setFont(new Font("나눔고딕", Font.PLAIN, 13));
			label_2.setBounds(12, 161, 57, 15);
		}
		return label_2;
	}
	private JTextField getPCode() {
		if (pCode == null) {
			pCode = new JTextField();
			pCode.setBounds(68, 83, 116, 21);
			pCode.setColumns(10);
		}
		return pCode;
	}
	private JTextField getPName() {
		if (pName == null) {
			pName = new JTextField();
			pName.setColumns(10);
			pName.setBounds(68, 111, 155, 21);
		}
		return pName;
	}
	private JTextField getEa() {
		if (ea == null) {
			ea = new JTextField();
			ea.setColumns(10);
			ea.setBounds(68, 136, 78, 21);
		}
		return ea;
	}
	private JTextField getNal() {
		if (nal == null) {
			nal = new JTextField();
			nal.setColumns(10);
			nal.setBounds(68, 161, 116, 21);
			
			
		}
		return nal;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC218\uC815");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				
				modify();
				
				}
			});
			btnNewButton_1.setForeground(new Color(248, 248, 255));
			btnNewButton_1.setBackground(new Color(147, 112, 219));
			btnNewButton_1.setBounds(68, 192, 97, 23);
		}
		return btnNewButton_1;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("\uC0AD\uC81C");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
				delete();
				
				}
			});
			button.setForeground(new Color(248, 248, 255));
			button.setBackground(new Color(147, 112, 219));
			button.setBounds(177, 192, 97, 23);
		}
		return button;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setOpaque(true);
			status.setBackground(new Color(216, 191, 216));
			status.setBounds(12, 235, 303, 26);
		}
		return status;
	}
}
