package h_api2_StudentApp;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.Objects;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;

public class SortBySno extends JPanel {
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JLabel label;
	public JLabel status;

	/**
	 * Create the panel.
	 */
	public SortBySno(JLabel status) {
		this();
		this.status = status;
		sortList();
	}
	
	public SortBySno() {
		setBackground(new Color(250, 240, 230));
		setLayout(null);
		add(getLblNewLabel());
		add(getScrollPane());
	}
	
	public void sortList() {
		String str="";
		Student temp = null;
		
		for(int i = 0; i<StudentApp.count-1; i++) {
			for(int j = (i+1); j<StudentApp.count; j++) {
				int result = Objects.compare(StudentApp.st[i], StudentApp.st[j], new StudentComp('n'));
				if(result>0) { 
					temp = StudentApp.st[i];
					StudentApp.st[i] = StudentApp.st[j];
					StudentApp.st[j] = temp;
				} // end of if
			} // end of for j
		} // end of for i
		textArea.setText(""); // 기존에 표시된 내용을 모두 삭제
		for(int i = 0; i<StudentApp.count; i++) {
			textArea.append(StudentApp.st[i]+"\n");
		}
		status.setText("데이터가 학번순으로 정렬되었습니다");
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uD559\uBC88\uC21C\uC73C\uB85C \uC815\uB82C");
			lblNewLabel.setForeground(new Color(255, 255, 240));
			lblNewLabel.setOpaque(true);
			lblNewLabel.setBackground(new Color(216, 191, 216));
			lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(22, 10, 416, 56);
		}
		return lblNewLabel;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(22, 70, 416, 220);
			scrollPane.setViewportView(getTextArea());
			scrollPane.setColumnHeaderView(getLabel());
		}
		return scrollPane;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setText("");
		}
		return textArea;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uD559\uBC88                   \uC131\uC801                     \uC774\uB984     ");
			label.setOpaque(true);
			label.setBackground(new Color(240, 255, 255));
			label.setForeground(new Color(147, 112, 219));
			label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			label.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return label;
	}
}
