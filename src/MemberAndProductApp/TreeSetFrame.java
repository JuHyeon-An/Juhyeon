package MemberAndProductApp;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.NavigableSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TreeSetFrame extends JInternalFrame {
	private JTextField textField;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	
	TreeSet<Integer> scores = new TreeSet<Integer>();

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TreeSetFrame frame = new TreeSetFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void process() {
		
		StringTokenizer tokens = new StringTokenizer(textField.getText(),",");
//		한번 사용한 토큰은 재사용 X
		
		textArea.setText("");
		while(tokens.hasMoreTokens()) {
//			textArea.append(tokens.nextToken()+"\n");
			scores.add(Integer.parseInt(tokens.nextToken()));
		}
		textArea.append("\n최소값 : "+scores.first());
		textArea.append("\n최대값 : "+scores.last());
		
		textArea.append("\n60점 이하 : "+scores.lower(60));
		textArea.append("\n90점 이상 : "+scores.higher(90));
		
		textArea.append("\n60점 이거나 60점 바로 밑 값 : "+scores.floor(60));
		textArea.append("\n90점 이거나 90점 바로 위 값: "+scores.ceiling(90));
		
		textArea.append("\n--------------------------------");
		
		while(!scores.isEmpty()) { // 비어있지 않으면 실행
			textArea.append("\n"+scores.pollFirst()+"::: (남은 객체 수 :"+scores.size()+")");
//			데이터 첫번째값부터 끄집어내기
			
			
		}
	}
	
	public void desc() {
		StringTokenizer tokens = new StringTokenizer(textField.getText(),",");
		textArea.setText("");
		while (tokens.hasMoreTokens()) {
			scores.add(Integer.parseInt(tokens.nextToken()));
		}
		NavigableSet<Integer> descendingSet = scores.descendingSet();
	
		while(!scores.isEmpty()) {
			textArea.append("\n"+descendingSet.pollFirst()+" / 남은 객체의 수 "+scores.size());
		}
	}
	
	public void asc() {
		StringTokenizer tokens = new StringTokenizer(textField.getText(), ",");
		while(tokens.hasMoreElements()) {
			scores.add(Integer.parseInt((String) tokens.nextElement())); // ClassCastingException
//			java.lang.String cannot be cast to java.lang.Integer
		}
		
		NavigableSet<Integer> descendingSet = scores.descendingSet();
		NavigableSet<Integer> ascendingSet = descendingSet.descendingSet();
		
		while(!scores.isEmpty()) {
			textArea.append("\n"+ascendingSet.pollFirst()+" / 남은 객체 수 : "+scores.size());
		}
		
	}
	
	public TreeSetFrame() {
		super("TreeSet", false, true, true, true);
		setVisible(true);
		setBounds(100, 100, 450, 347);
		getContentPane().setLayout(null);
		getContentPane().add(getTextField());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getScrollPane());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getBtnNewButton_2());
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setText("23,4,56,78,9,76,9,5,45,3,67,7,,2,2,65,4,32,2,667,54,34,231,64,55,7,2,45");
			textField.setBounds(12, 10, 309, 21);
			textField.setColumns(10);
		}
		return textField;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				process();
				
				}

				
			});
			btnNewButton.setBounds(325, 9, 97, 23);
		}
		return btnNewButton;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 75, 410, 233);
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
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("ASC");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
				asc();
				
				}

		
			});
			btnNewButton_1.setBounds(224, 42, 97, 23);
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("DESC");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
				
					desc();
				
				}

			
			});
			btnNewButton_2.setBounds(325, 42, 97, 23);
		}
		return btnNewButton_2;
	}
}
