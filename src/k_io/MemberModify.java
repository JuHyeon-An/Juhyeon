package io_App;

import java.awt.EventQueue;
import java.util.*;
import java.util.regex.Pattern;

import javax.swing.JInternalFrame;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberModify extends JInternalFrame {

	int index = -1;
//	기본을 찾지 못한것을 베이스로
//	찾은 위치값
	List<MemberVo> list;
//	검색할때, 수정할때. 삭제할때 쓰여지는 list
	
	private JLabel t1;
	private JLabel t2;
	private JLabel t3;
	private JLabel t4;
	private JTextField mId;
	private JTextField pwd;
	private JTextField mName;
	private JTextField phone;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel status;
	private JLabel lblNewLabel;
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberModify frame = new MemberModify();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	
	}
	
	public MemberModify() {
		super("\uD68C\uC6D0\uC815\uBCF4 \uC218\uC815", false, true, true, true);
		getContentPane().setBackground(new Color(255, 255, 224));
		getContentPane().setFont(new Font("Gulim", Font.PLAIN, 12));
		getContentPane().setLayout(null);
		getContentPane().add(getT1());
		getContentPane().add(getT2());
		getContentPane().add(getT3());
		getContentPane().add(getT4());
		getContentPane().add(getMId());
		getContentPane().add(getPwd());
		getContentPane().add(getMName());
		getContentPane().add(getPhone());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getBtnNewButton_2());
		getContentPane().add(getStatus());
		getContentPane().add(getLblNewLabel());
		setVisible(true);
		setBounds(300, 100, 338, 232);
	}
	
	public void search() { // 검색버튼
		pwd.setText("");
		mName.setText("");
		phone.setText("");
		
		pwd.setEditable(true);
		mName.setEditable(true);
		phone.setEditable(true);
		
		String find = mId.getText();
		
		MemberDao dao = new MemberDao();
		MemberVo vo = dao.search(find);
		
		if(vo != null) { // vo가 null이 아니면 데이터 찾은 것
			pwd.setText(vo.getPwd());
			mName.setText(vo.getmName());
			phone.setText(vo.getPhone());
			
			status.setForeground(Color.white);
			status.setBackground(Color.ORANGE);
			status.setText("자료가 검색되었습니다.");
			
		}else {
			status.setBackground(Color.CYAN);
			status.setText("찾는 자료가 없습니다.");
			
			mId.requestFocus();
			mId.selectAll();
		}
		
	}
	
	public void modify() { // 수정 버튼
		
		String i = mId.getText();
		String p = pwd.getText();
		String m = mName.getText();
		String ph = phone.getText();

		boolean flag = // 무결성체크
			Pattern.matches(FileExam2.idCheck, i) &&
			Pattern.matches(FileExam2.pwdCheck, p) &&
			Pattern.matches(FileExam2.nameCheck, m) &&
			Pattern.matches(FileExam2.phoneCheck, ph);
		
		if (flag) {
			MemberVo vo = new MemberVo(i, p, m, ph);
			MemberDao dao = new MemberDao();
			boolean b = dao.modify(vo);
			if(b) {
				status.setText("해당 자료가 수정되었습니다.");
			}else {
				status.setText("저장 중 오류 발생");
			}
		} else {
			status.setText("아이디를 다시 입력해주세요");
		}
	}

	public void delete() { // 삭제버튼

		String findmId = mId.getText();
		MemberDao dao = new MemberDao();
		boolean b = dao.delete(findmId);
		
		if(b) {
			status.setText("해당 자료가 삭제되었습니다.");
			pwd.setText("");
			mName.setText("");
			phone.setText("");
			
			mId.requestFocus();
			mId.selectAll();
		}else {
			status.setText("자료 삭제 중 오류 발생.");}
	}
	
	private JLabel getT1() {
		if (t1 == null) {
			t1 = new JLabel("\uC544\uC774\uB514");
			t1.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
			t1.setBounds(12, 10, 57, 15);
		}
		return t1;
	}
	private JLabel getT2() {
		if (t2 == null) {
			t2 = new JLabel("\uC554\uD638");
			t2.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
			t2.setBounds(12, 35, 57, 15);
		}
		return t2;
	}
	private JLabel getT3() {
		if (t3 == null) {
			t3 = new JLabel("\uC131\uBA85");
			t3.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
			t3.setBounds(12, 60, 57, 15);
		}
		return t3;
	}
	private JLabel getT4() {
		if (t4 == null) {
			t4 = new JLabel("\uC5F0\uB77D\uCC98");
			t4.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
			t4.setBounds(12, 85, 57, 15);
		}
		return t4;
	}
	private JTextField getMId() {
		if (mId == null) {
			mId = new JTextField();
			mId.setBounds(81, 7, 116, 21);
			mId.setColumns(10);
		}
		return mId;
	}
	private JTextField getPwd() {
		if (pwd == null) {
			pwd = new JTextField();
			pwd.setColumns(10);
			pwd.setBounds(81, 32, 116, 21);
		}
		return pwd;
	}
	private JTextField getMName() {
		if (mName == null) {
			mName = new JTextField();
			mName.setColumns(10);
			mName.setBounds(81, 57, 116, 21);
		}
		return mName;
	}
	private JTextField getPhone() {
		if (phone == null) {
			phone = new JTextField();
			phone.setColumns(10);
			phone.setBounds(81, 82, 116, 21);
		}
		return phone;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC218\uC815");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
				modify();
				}
			});
			btnNewButton.setBackground(new Color(240, 230, 140));
			btnNewButton.setFont(new Font("나눔바른고딕", Font.BOLD, 13));
			btnNewButton.setBounds(81, 114, 97, 37);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC0AD\uC81C");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
				delete();
				
				}
			});
			btnNewButton_1.setBackground(new Color(240, 230, 140));
			btnNewButton_1.setFont(new Font("나눔바른고딕", Font.BOLD, 13));
			btnNewButton_1.setBounds(190, 114, 97, 37);
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("\uAC80\uC0C9");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
				search();
				}
			});
			btnNewButton_2.setBackground(new Color(255, 222, 173));
			btnNewButton_2.setFont(new Font("나눔바른고딕", Font.BOLD, 13));
			btnNewButton_2.setBounds(209, 6, 78, 23);
		}
		return btnNewButton_2;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("\uB370\uC774\uD130\uB97C \uAC80\uC0C9\uD558\uC138\uC694");
			status.setForeground(new Color(102, 102, 102));
			status.setFont(new Font("나눔스퀘어라운드 Bold", Font.BOLD, 14));
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setOpaque(true);
			status.setBackground(new Color(255, 204, 102));
			status.setBounds(12, 164, 294, 23);
		}
		return status;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\JHTA\\Downloads\\diamonds.png"));
			lblNewLabel.setBounds(209, 35, 78, 65);
		}
		return lblNewLabel;
	}
}
