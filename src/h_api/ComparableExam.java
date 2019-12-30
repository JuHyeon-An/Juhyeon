package h_api;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ComparableExam extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JPanel panel_1;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComparableExam frame = new ComparableExam();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ComparableExam() {
		setTitle("ComparableExam");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.NORTH);
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
		
	}
	
	public void sortNum() { // 숫자 정렬
		String[] temp = textField.getText().split(",");
		Integer[] intArray = new Integer[temp.length];

		for (int i = 0; i < temp.length; i++) {
			intArray[i] = Integer.parseInt(temp[i]);
		}
		
		Arrays.sort(intArray);
		
		StringBuilder sb = new StringBuilder(1024);
		for (int i = 0; i < intArray.length; i++) {
			String str = String.format("[%2d] = %s\n", i, intArray[i]);
			sb.append(str);
		}
		
		//how1 (bubble sort 방법으로 내림차 정렬)
		boolean sort = true;
		int lastIndex = intArray.length-1; //lastIndex 회전수당 비교하는 범위 어디까지인지
		
		while(sort) {
			sort = false;
			for(int i = 0; i<lastIndex; i++) {
				if(intArray[i] < intArray[i+1]) { //  descending 내림차순 : 뒤에 있는 값이 더 작은지 비교
					int t = intArray[i]; // 잠시 대피
					intArray[i] = intArray[i+1];
					intArray[i+1] = t;
					sort = true; // array 교환이 한번 이루어졌으면 한번 더 돌아라
				}
			}
			lastIndex--; // 한번 돌고 나면 맨 마지막 값은 비교할 필요가 없으므로
		}
		sb.append("\n\n버블 소트 내림차 정렬 결과------\n\n");
		for (int i = 0; i < intArray.length; i++) {
			String str = String.format("[%2d] = %s\n", i, intArray[i]);
			sb.append(str);
		}
		
		// how2 (java API 사용해서 정렬)
		// reverse하면 다시 오름차순 (원본이 내림차순 정렬되었기 때문에)
		Collections.reverse(Arrays.asList(intArray)); // 안쪽에 있는 매개변수를 list라는 콜렉션으로 바꿈 -> reverse
		sb.append("\n\nJava API를 사용한 reverse\n\n");
		for (int i = 0; i < intArray.length; i++) {
			String str = String.format("[%2d] = %s\n", i, intArray[i]);
			sb.append(str);
		}
		textArea.setText(sb.toString());
	}
	
	public void sortStr() { // 문자 정렬
		String[] temp = textField.getText().split(",");
		Arrays.sort(temp);
		textArea.setText("");
		
		for(int i = 0; i<temp.length; i++) {
			textArea.append(i + " = " + temp[i] + "\n");
		}
		
		textArea.append("\n\n java API를 사용한 내림차순\n\n");
		Arrays.sort(temp, Collections.reverseOrder());
		
		for(int i = 0; i<temp.length; i++) {
			textArea.append(i + " = " + temp[i]+"\n");
		}
	}
	
	
	public void sortObj() { // object 정렬
		String[] temp = textField.getText().split(",");
		Score[] sArray = new Score[temp.length];
		
		for(int i = 0; i<temp.length; i++) {
			sArray[i] = new Score(temp[i]);  // l 전달받은 문자를 Score에서 int로 parsing하기 (for문 돌리지 않아도 된다는 장점)
		}
		Collections.sort(Arrays.asList(sArray));
		Collections.reverse(Arrays.asList(sArray)); // reverse 매개변수에 올 수 있는 타입이 List타입이라
		textArea.setText("");
		
		for (int i = 0; i < sArray.length; i++) {
			textArea.append(sArray[i].toString());
		}
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(250, 235, 215));
			panel.setPreferredSize(new Dimension(10, 80));
			panel.setLayout(null);
			panel.add(getTextField());
			panel.add(getBtnNewButton());
			panel.add(getBtnNewButton_1());
			panel.add(getBtnNewButton_2());
		}
		return panel;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			textField.setText("76,32,7,56,324,67,43,23,67,8,54,21,34,67,69,87,4334,7,4,23,65,73,5,6767,2,56,67");
			textField.setBounds(12, 10, 400, 21);
			textField.setColumns(10);
		}
		return textField;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC22B\uC790\uC815\uB82C");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				
					String[] strArray = textField.getText().split(",");
					int[] intArray = new int[strArray.length];

					for (int i = 0; i < strArray.length; i++) {
							intArray[i] = Integer.parseInt(strArray[i]);
					} // end of for

					String str = "";
					Arrays.sort(intArray);
//					str = Arrays.toString(intArray);

					for (int i = 0; i < intArray.length; i++) {
						str += String.format("배열[%d번째]=%s\n", i, intArray[i]);
					}
					textArea.setText(str);
				}
			});
			btnNewButton.setBackground(new Color(176, 224, 230));
			btnNewButton.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
			btnNewButton.setBounds(12, 41, 97, 23);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uBB38\uC790\uC815\uB82C");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String[] strArray = textField.getText().split(",");

					Arrays.sort(strArray);
					Arrays.sort(strArray, Collections.reverseOrder());
					
					String str = "";
//					str = Arrays.toString(intArray);

					for (int i = 0; i < strArray.length; i++) {
						str += String.format("배열[%d번째]=%s\n", i, strArray[i]);
					}
					textArea.setText(str);
					
				}
			});
			btnNewButton_1.setBackground(new Color(216, 191, 216));
			btnNewButton_1.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
			btnNewButton_1.setBounds(121, 41, 97, 23);
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("\uAC1D\uCCB4\uC815\uB82C");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String[] strArrays = textField.getText().split(",");
					int[] intArrays = new int[strArrays.length];
					Score[] sc = new Score[strArrays.length];
					
					for (int i = 0; i < strArrays.length; i++) {
							intArrays[i] = Integer.parseInt(strArrays[i]);
							Score kor = new Score(intArrays[i]);
							sc[i] = kor;
//							sc[i].kor = intArrays[i]; -> 이 코드 안 되는 이유 : 객체 생성 안 해서!!
					}

					Arrays.sort(sc);
					String str = "";
					str += "---------국어점수 오름차순---------\n";
					for (int j = 0; j < sc.length; j++) {
						if(sc[j].kor>=0 && sc[j].kor<=100)
						str += sc[j].kor + "점\n";
					}
					textArea.setText(str);
				}
			});
			btnNewButton_2.setBackground(new Color(250, 235, 215));
			btnNewButton_2.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
			btnNewButton_2.setBounds(230, 41, 97, 23);
		}
		return btnNewButton_2;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTextArea());
			scrollPane.setColumnHeaderView(getPanel_1());
		}
		return scrollPane;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setPreferredSize(new Dimension(10, 55));
			panel_1.setLayout(null);
			panel_1.add(getButton());
			panel_1.add(getButton_1());
			panel_1.add(getButton_2());
		}
		return panel_1;
	}
	private JButton getButton() { // 숫자정렬 1
		if (button == null) {
			button = new JButton("\uC22B\uC790\uC815\uB82C2");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				sortNum();
				}
			});
			button.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
			button.setBackground(new Color(176, 224, 230));
			button.setBounds(12, 10, 97, 23);
		}
		return button;
	}
	private JButton getButton_1() {
		if (button_1 == null) {
			button_1 = new JButton("\uBB38\uC790\uC815\uB82C2");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					sortStr();
				}
			});
			button_1.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
			button_1.setBackground(new Color(216, 191, 216));
			button_1.setBounds(121, 9, 97, 23);
		}
		return button_1;
	}
	private JButton getButton_2() {
		if (button_2 == null) {
			button_2 = new JButton("\uAC1D\uCCB4\uC815\uB82C2");
			button_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					sortObj();
				}
			});
			button_2.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 12));
			button_2.setBackground(new Color(250, 235, 215));
			button_2.setBounds(230, 9, 97, 23);
		}
		return button_2;
	}
}
