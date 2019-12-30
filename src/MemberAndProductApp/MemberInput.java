package MemberAndProductApp;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JInternalFrame;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class MemberInput extends JInternalFrame {

	List<MemberVo> list; // 생성자로 전달받은 멤버Vo를 가지고 있는 리스트
	private JLabel lblNewLabel;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JTextField mId;
	private JTextField pwd;
	private JTextField mName;
	private JTextField phone;
	private JButton btnNewButton;
	private JLabel status;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberInput frame = new MemberInput();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MemberInput() {
		super("회원입력", false, true, true, true);
		getContentPane().setBackground(new Color(255, 255, 204));
		getContentPane().setForeground(new Color(255, 240, 245));
		getContentPane().setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLabel());
		getContentPane().add(getLabel_1());
		getContentPane().add(getLabel_2());
		getContentPane().add(getMId());
		getContentPane().add(getPwd());
		getContentPane().add(getMName());
		getContentPane().add(getPhone());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getStatus());
		setVisible(true);
		setBounds(100, 100, 334, 257);
	}
	
	public MemberInput(List<MemberVo> list) {
		this();
		this.list = list;
	}
	
	public void input() {
		String id = mId.getText();
		String p = pwd.getText();
		String n = mName.getText();
		String ph = phone.getText();
		
		MemberVo vo = new MemberVo(id, p, n, ph);
		this.list.add(vo);
		
		pwd.setText("");
		mName.setText("");
		phone.setText("");
		
		mId.requestFocus();
		mId.selectAll();
		
		status.setText("회원 정보가 추가 입력되었습니다.(" + list.size() + "건)");
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC544\uC774\uB514");
			lblNewLabel.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
			lblNewLabel.setBounds(12, 10, 57, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uC554\uD638");
			label.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
			label.setBounds(12, 35, 57, 15);
		}
		return label;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uC5F0\uB77D\uCC98");
			label_1.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
			label_1.setBounds(12, 85, 57, 15);
		}
		return label_1;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("\uC131\uBA85");
			label_2.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
			label_2.setBounds(12, 60, 57, 15);
		}
		return label_2;
	}
	private JTextField getMId() {
		if (mId == null) {
			mId = new JTextField();
			mId.setBounds(81, 7, 146, 21);
			mId.setColumns(10);
		}
		return mId;
	}
	private JTextField getPwd() {
		if (pwd == null) {
			pwd = new JTextField();
			pwd.setColumns(10);
			pwd.setBounds(81, 32, 128, 21);
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
			phone.setBounds(81, 82, 146, 21);
		}
		return phone;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC800\uC7A5");
			btnNewButton.setForeground(new Color(0, 0, 0));
			btnNewButton.setBackground(new Color(255, 204, 51));
			btnNewButton.setFont(new Font("나눔바른고딕", Font.BOLD, 12));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					input();
				}
			});
			btnNewButton.setIcon(new ImageIcon("C:\\Users\\JHTA\\Downloads\\folder.png"));
			btnNewButton.setBounds(81, 120, 146, 45);
		}
		return btnNewButton;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("\uBAA8\uB4E0 \uD56D\uBAA9\uC744 \uC785\uB825\uD558\uACE0 \uC800\uC7A5\uD558\uC138\uC694.");
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setFont(new Font("나눔바른고딕", Font.PLAIN, 13));
			status.setOpaque(true);
			status.setBackground(new Color(255, 255, 102));
			status.setBounds(12, 175, 296, 32);
		}
		return status;
	}
}
