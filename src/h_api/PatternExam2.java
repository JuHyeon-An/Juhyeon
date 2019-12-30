package h_api;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class PatternExam2 extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JTextField id;
	private JTextField pwd;
	private JTextField mName;
	private JTextField phone;
	private JTextField email;
	private JTextField zip;
	private JButton btnNewButton;
	private JLabel status;
	private JLabel lblNewLabel_2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatternExam2 frame = new PatternExam2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PatternExam2() {
		setFont(new Font("배달의민족 도현", Font.PLAIN, 12));
		setBackground(new Color(255, 228, 225));
		setTitle("\uD68C\uC6D0\uAC00\uC785(Pattern Check)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 289, 338);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 250, 210));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLabel());
		contentPane.add(getLabel_1());
		contentPane.add(getLabel_2());
		contentPane.add(getLabel_3());
		contentPane.add(getLabel_4());
		contentPane.add(getId());
		contentPane.add(getPwd());
		contentPane.add(getMName());
		contentPane.add(getPhone());
		contentPane.add(getEmail());
		contentPane.add(getZip());
		contentPane.add(getBtnNewButton());
		contentPane.add(getStatus());
		contentPane.add(getLblNewLabel_2());
	}

	public void check() {

		String regexp = "";
		String value = "";
		status.setText("");
		
		if (id.getText().equals("") | pwd.getText().equals("") | mName.getText().equals("") | phone.getText().equals("")
				| zip.getText().equals("") | email.getText().equals("")) {
			status.setText("모든 항목을 입력해줄래용?.?");
		}
		else {
		// 아이디
		regexp = "([\\w+])(?=.*[!$_]).{3,9}"; // 기호 반드시 포함
		regexp = "[\\w+!$]{4,10}"; // 기호 포함 가능
		
		value = id.getText();
		if (!Pattern.matches(regexp, value)) {
			status.setText("아이디는 영숫자와 기호 포함($, !, _) 4~1자 입니다.");
			id.requestFocus();
			id.selectAll();
		}

		// 암호
		regexp = "[\\w+!$]{4,10}"; // 반드시 x 4자에서 10자까지
		value = pwd.getText();
		if (!Pattern.matches(regexp, value)) {
			status.setText("비밀번호는 영숫자와 기호 포함 4~10자 입니다.");
			pwd.requestFocus();
			pwd.selectAll();
		}

		// 성명
		regexp = "[가-힣]{2,20}"; // 한글만 입력
		value = mName.getText();
		if (!Pattern.matches(regexp, value)) {
			status.setText("성명은 한글 2~20자로 입력해주세요.");
			mName.requestFocus();
			mName.selectAll();
		}

		// 연락처
		regexp = "\\d{2,3}-\\d{3,4}-\\d{4}"; // 00 ~ 999 - 000 ~ 9999 - 0000 ~ 9999
		value = phone.getText();
		if (!Pattern.matches(regexp, value)){
			status.setText("연락처를 다시 입력하세요.");
			phone.requestFocus();
			phone.selectAll();
		}
		// 우편번호
		regexp = "\\d{2}-\\d{3}"; // 00 ~ 999
		value = zip.getText();
		if (!Pattern.matches(regexp, value)) {
			status.setText("우편번호를 다시 입력하세요");
			zip.requestFocus();
			zip.selectAll();
		}

		// 이메일
		regexp = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
		value = email.getText();
		if (!Pattern.matches(regexp, value)) {
			status.setText("이메일을 다시 입력하세요");
			email.requestFocus();
			email.selectAll();
		}
		}
	} // end of check()

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC544\uC774\uB514");
			lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 12));
			lblNewLabel.setBounds(12, 33, 57, 15);
		}
		return lblNewLabel;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uC554\uD638");
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 12));
			label.setBounds(12, 58, 57, 15);
		}
		return label;
	}

	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uC131\uBA85");
			label_1.setHorizontalAlignment(SwingConstants.RIGHT);
			label_1.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 12));
			label_1.setBounds(12, 83, 57, 15);
		}
		return label_1;
	}

	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("\uC5F0\uB77D\uCC98");
			label_2.setHorizontalAlignment(SwingConstants.RIGHT);
			label_2.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 12));
			label_2.setBounds(12, 108, 57, 15);
		}
		return label_2;
	}

	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("\uC774\uBA54\uC77C");
			label_3.setHorizontalAlignment(SwingConstants.RIGHT);
			label_3.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 12));
			label_3.setBounds(12, 133, 57, 15);
		}
		return label_3;
	}

	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("\uC6B0\uD3B8\uBC88\uD638");
			label_4.setHorizontalAlignment(SwingConstants.RIGHT);
			label_4.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 12));
			label_4.setBounds(12, 158, 57, 15);
		}
		return label_4;
	}

	private JTextField getId() {
		if (id == null) {
			id = new JTextField();
			id.setBounds(81, 30, 116, 21);
			id.setColumns(10);
		}
		return id;
	}

	private JTextField getPwd() {
		if (pwd == null) {
			pwd = new JTextField();
			pwd.setColumns(10);
			pwd.setBounds(81, 55, 116, 21);
		}
		return pwd;
	}

	private JTextField getMName() {
		if (mName == null) {
			mName = new JTextField();
			mName.setColumns(10);
			mName.setBounds(81, 80, 97, 21);
		}
		return mName;
	}

	private JTextField getPhone() {
		if (phone == null) {
			phone = new JTextField();
			phone.setColumns(10);
			phone.setBounds(81, 105, 97, 21);
		}
		return phone;
	}

	private JTextField getEmail() {
		if (email == null) {
			email = new JTextField();
			email.setColumns(10);
			email.setBounds(81, 130, 157, 21);
		}
		return email;
	}

	private JTextField getZip() {
		if (zip == null) {
			zip = new JTextField();
			zip.setColumns(10);
			zip.setBounds(81, 155, 97, 21);
		}
		return zip;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uCCB4\uD06C");
			btnNewButton.setFont(new Font("배달의민족 주아", Font.PLAIN, 15));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					check();
				}

			});
			btnNewButton.setBounds(81, 186, 97, 29);
		}
		return btnNewButton;
	}

	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setForeground(Color.DARK_GRAY);
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setOpaque(true);
			status.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.BOLD, 13));
			status.setBackground(new Color(240, 230, 140));
			status.setBounds(12, 230, 249, 60);
		}
		return status;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\JHTA\\Downloads\\castle (1).png"));
			lblNewLabel_2.setBounds(204, 30, 69, 68);
		}
		return lblNewLabel_2;
	}
}
