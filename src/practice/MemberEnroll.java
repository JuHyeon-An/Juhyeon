package practice;

import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberEnroll extends JInternalFrame {
	
	Set<Member> ms = new HashSet<Member>();
	
	private JLabel lblNewLabel;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	public JTextField textField;
	private JTextField mName;
	private JTextField mAge;
	private JTextField mDate;
	private JButton btnNewButton;

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberEnroll frame = new MemberEnroll();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MemberEnroll() {
		super("member 등록", true, true, true, true);
		setVisible(true);
		setBounds(100, 100, 247, 222);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLabel());
		getContentPane().add(getLabel_1());
		getContentPane().add(getLabel_2());
		getContentPane().add(getTextField());
		getContentPane().add(getMName());
		getContentPane().add(getMAge());
		getContentPane().add(getMDate());
		getContentPane().add(getBtnNewButton());

	}
	
	public MemberEnroll(Set<Member> ms) {
		this();
		this.ms = ms;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uB0A0\uC9DC");
			lblNewLabel.setBounds(12, 117, 57, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uD559\uBC88");
			label.setBounds(12, 18, 57, 15);
		}
		return label;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uC774\uB984");
			label_1.setBounds(12, 51, 57, 15);
		}
		return label_1;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("\uB098\uC774");
			label_2.setBounds(12, 84, 57, 15);
		}
		return label_2;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setEditable(false);
			textField.setBounds(54, 14, 116, 21);
			textField.setColumns(10);
			
			textField.setText((Integer.toString(ms.size()+1)));
			
		}
		return textField;
	}
	private JTextField getMName() {
		if (mName == null) {
			mName = new JTextField();
			mName.setColumns(10);
			mName.setBounds(54, 49, 116, 21);
		}
		return mName;
	}
	private JTextField getMAge() {
		if (mAge == null) {
			mAge = new JTextField();
			mAge.setColumns(10);
			mAge.setBounds(54, 84, 116, 21);
		}
		return mAge;
	}
	private JTextField getMDate() {
		if (mDate == null) {
			mDate = new JTextField();
			mDate.setColumns(10);
			mDate.setBounds(54, 119, 116, 21);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			mDate.setText(sdf.format(new Date()));
		}
		return mDate;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uB4F1\uB85D");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int before = ms.size();

					int sno = Integer.parseInt(textField.getText());
					String n = mName.getText();
					int a = Integer.parseInt(mAge.getText());
					String d = mDate.getText();

					Member mm = new Member(n, a, sno, d);
					ms.add(mm);
					int after = ms.size();
					textField.setText(Integer.toString(ms.size() + 1));

					if (before < after) {

						mName.setText("");
						mAge.setText("");
						JOptionPane.showMessageDialog(null, "입력이 완료되었습니다.");
					} else
						JOptionPane.showMessageDialog(null, "중복");
				}
			});
			btnNewButton.setBounds(61, 154, 97, 23);
		}
		return btnNewButton;
	}
}
