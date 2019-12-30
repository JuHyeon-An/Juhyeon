package MemberAndProductApp;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TreeMapFrame extends JInternalFrame {
	
	TreeMap<Integer, String> scores; // proess, asc, desc���� ��� ����� �� �ְ�
//	new�� �����ϱ� ��ü������ ���� ���� ����. �ؿ� new �������� ������ nullpointerexception �߻�
	
	private JButton btnNewButton;
	private JButton btnAsc;
	private JButton btnDesc;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TreeMapFrame frame = new TreeMapFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void process() {
		
		scores = new TreeMap<Integer, String>();

		scores.put(80, "kim");
		scores.put(50, "hong");
		scores.put(90, "park");
		scores.put(30, "gang");
		scores.put(55, "lee");

		textArea.setText("");
		Map.Entry<Integer, String> entry = null;
		
		entry = scores.firstEntry(); // �ּҰ�
		textArea.append("\n�ּҰ�  " + entry.getKey()+" > "+entry.getValue());
		
		entry = scores.lastEntry();
		textArea.append("\n�ִ밪  "+entry.getKey()+" > "+entry.getValue());
		
		entry = scores.lowerEntry(55);
		textArea.append("\n55�� �Ʒ�  : "+entry.getKey()+" > "+entry.getValue());
		
		entry = scores.higherEntry(85);
		textArea.append("\n85�� �� : " + entry.getKey()+ " > "+entry.getValue());
		
	}
	
	public void asc() {
		if(scores != null) { // scores�� ���� ����ִ� ��츸 ����
			textArea.setText("");
			NavigableMap<Integer, String> tempMap = scores.descendingMap();
			NavigableMap<Integer, String> ascMap = tempMap.descendingMap();
			Set<Map.Entry<Integer, String>> set = ascMap.entrySet();
			
			for(Map.Entry<Integer, String> d : set) {
				textArea.append(d.getKey()+" : "+d.getValue()+"\n");
			}
		}else {
			textArea.setText("���� �����ư�� �����ּ���");
		}
	}
	
	public void desc() {
		if(scores!=null) {
			textArea.setText("");
			NavigableMap<Integer, String> map = scores.descendingMap();
			Set<Map.Entry<Integer, String>> entry = map.entrySet();
			
			for(Map.Entry<Integer, String> d : entry) {
				textArea.append(d.getKey()+" : "+d.getValue());
			}
		}else {
			textArea.setText("���� �����ư�� Ŭ���� �� �������ּ���");
		}
		
	}
	
	public TreeMapFrame() {
		super("TreeMap", false, true, true, true);
		setVisible(true);
		setBounds(100, 100, 356, 439);
		getContentPane().setLayout(null);
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getBtnAsc());
		getContentPane().add(getBtnDesc());
		getContentPane().add(getScrollPane());
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC2E4\uD589");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
				process();
				
				}
			});
			btnNewButton.setBounds(12, 10, 97, 23);
		}
		return btnNewButton;
	}
	private JButton getBtnAsc() {
		if (btnAsc == null) {
			btnAsc = new JButton("ASC");
			btnAsc.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
				asc();
				
				}
			});
			btnAsc.setBounds(121, 10, 97, 23);
		}
		return btnAsc;
	}
	private JButton getBtnDesc() {
		if (btnDesc == null) {
			btnDesc = new JButton("DESC");
			btnDesc.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
				desc();
				
				}
			});
			btnDesc.setBounds(230, 10, 97, 23);
		}
		return btnDesc;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(14, 43, 313, 357);
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
}
