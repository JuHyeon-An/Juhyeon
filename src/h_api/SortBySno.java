package h_api;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.Objects;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SortBySno extends JPanel {
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JLabel label;

	/**
	 * Create the panel.
	 */
	
	
	public SortBySno() {
		setLayout(null);
		add(getLblNewLabel());
		add(getScrollPane());
		sortList();

	}
	
	public void sortList() {
		String str="";
		Student temp = null;
		
		for(int i = 0; i<StudentApp.count-1; i++) {
			for(int j = i+1; j<StudentApp.count; j++) {
				int result = Objects.compare(StudentApp.st[i], StudentApp.st[j], new StudentComp());
				if(result>0) { 
					temp = StudentApp.st[i];
					StudentApp.st[i] = StudentApp.st[j];
					StudentApp.st[j] = temp;
				}
			}
		}
		for(int i = 0; i<StudentApp.count; i++) {
			Student st3 = StudentApp.st[i];
			str += "\t"+st3.getSno();
			str += "\t"+st3.getScore();
			str += "\t"+st3.getName();
			str += "\n";
		}
		textArea.setText(str);
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uD559\uBC88\uC21C\uC73C\uB85C \uC815\uB82C");
			lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(12, 10, 426, 56);
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
			label.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return label;
	}
}
