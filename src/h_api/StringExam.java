package h_api;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StringExam extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField idNum;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JLabel status;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StringExam frame = new StringExam();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void showText() {
		String id = idNum.getText(); // 입력창에 주민등록번호 입력받은 값
		int a = id.length(); // 문자열의 길이
		String b = id.substring(0, 6); // 생년월일
		char c = id.charAt(7); // 7번째 문자열 반환 (성별 구분)
		String d; // "남자" "여자" 담을 문자열 변수
		
		
		d = (c % 2 == 0)? "여자" : "남자";
		String str = "";
		str += "문자열의 길이 : "+a+"\n";
		str += "생년 : " + id.substring(0, 2) +"\n";
		str += "생월 : " + id.substring(2,4) + "\n";
		str += "생일 : " + id.substring(4,6) + "\n";
		str += "성별 : "+d;
		
		
		textArea.setText(str);
		status.setText("");
	}
	
	
	public StringExam() {
		setTitle("\uBB38\uC790\uC5F4 Exam");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getIdNum());
		contentPane.add(getBtnNewButton());
		contentPane.add(getScrollPane());
		contentPane.add(getStatus());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC8FC\uBBFC\uBC88\uD638");
			lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
			lblNewLabel.setBounds(24, 47, 73, 25);
		}
		return lblNewLabel;
	}
	private JTextField getIdNum() {
		if (idNum == null) {
			idNum = new JTextField();
			idNum.setBounds(97, 49, 234, 25);
			idNum.setColumns(10);
		}
		return idNum;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uD655\uC778");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				showText();
				}

				
			});
			btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			btnNewButton.setBounds(337, 47, 85, 27);
		}
		return btnNewButton;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 82, 410, 170);
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("\uC8FC\uBBFC\uB4F1\uB85D\uBC88\uD638\uB97C \uC785\uB825\uD558\uC138\uC694.");
			status.setBounds(24, 22, 322, 15);
		}
		return status;
	}
}
