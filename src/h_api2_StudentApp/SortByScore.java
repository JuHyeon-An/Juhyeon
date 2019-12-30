package h_api2_StudentApp;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Objects;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;

public class SortByScore extends JPanel {
	private JLabel label;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JLabel label_1;
	public JLabel status;
	
	/**
	 * Create the panel.
	 */
	
	public SortByScore(JLabel status) {
		this();
		this.status = status;
		sortList();
	}
	
	public SortByScore() {
		setBackground(new Color(245, 255, 250));
		setLayout(null);
		add(getLabel());
		add(getScrollPane());
	}
	public void sortList() {
		String str="";
		Student temp = null;
		
		for(int i = 0; i<StudentApp.count-1; i++) {
			for(int j = i+1; j<StudentApp.count; j++) {
				int result = Objects.compare(StudentApp.st[i], StudentApp.st[j], new StudentComp('s'));
				if(result<0) { 
					temp = StudentApp.st[i];
					StudentApp.st[i] = StudentApp.st[j];
					StudentApp.st[j] = temp;
				}
			}
		}
		
		textArea.setText("");
		for(int i = 0; i<StudentApp.count; i++) {
			textArea.append(StudentApp.st[i]+"\n");
		}
		status.setText("¼ºÀû¼øÀ¸·Î Á¤·ÄÀÌ µÇ¾ú½À´Ï´Ù");
	}
	
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uC810\uC218\uC21C\uC73C\uB85C \uC815\uB82C");
			label.setForeground(new Color(255, 255, 224));
			label.setOpaque(true);
			label.setBackground(new Color(102, 205, 170));
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
			label.setBounds(12, 10, 416, 56);
		}
		return label;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 70, 416, 220);
			scrollPane.setViewportView(getTextArea());
			scrollPane.setColumnHeaderView(getLabel_1());
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
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uD559\uBC88                   \uC131\uC801                     \uC774\uB984     ");
			label_1.setOpaque(true);
			label_1.setBackground(new Color(224, 255, 255));
			label_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
			label_1.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return label_1;
	}
}
