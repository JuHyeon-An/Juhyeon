package MemberAndProductApp;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import j_collection.InputPanel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScoreSearch extends JInternalFrame {
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JList listSno;
	private JScrollPane scrollPane_1;
	private JList listExam;
	private InputPanel panel;
	private JTextField textField;
	public JButton btnFind;
	private JButton btnNewButton_1;
	private JButton button;
	private JLabel status;

	Map<String, List<ScoreVo>> map;
	DefaultListModel<String> modelSno = new DefaultListModel<>();
	DefaultListModel<String> modelExam = new DefaultListModel<String>();
	
	List<ScoreVo> list;
	private JLabel label;
	private JLabel label_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreSearch frame = new ScoreSearch();
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
	public ScoreSearch() {
		super("������ȸ", true, true, true, true);
		getContentPane().setBackground(new Color(178, 34, 34));
		setVisible(true);
		setBounds(80, 30, 752, 522);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getScrollPane());
		getContentPane().add(getScrollPane_1());
		getContentPane().add(getPanel());
		getContentPane().add(getTextField());
		getContentPane().add(getBtnFind());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getButton());
		getContentPane().add(getStatus());
		getContentPane().add(getLabel());
		getContentPane().add(getLabel_1());

	}
	
	public ScoreSearch(Map<String, List<ScoreVo>> map) {
		this();
		this.map = map;
		
//		�й��� �����Ͽ� JList�� ǥ��
		Set<String> set = map.keySet();

//		JList�� �߰�
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()){
			modelSno.addElement(iter.next()); // model�� �����͸� �߰�
		}
		
		listSno.setModel(modelSno); // setModel : ���� ����Ʈ�� ����
	}

	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC131\uC801 \uC218\uC815 & \uC0AD\uC81C");
			lblNewLabel.setForeground(new Color(248, 248, 255));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("����ǹ��� ����", Font.PLAIN, 30));
			lblNewLabel.setBounds(85, 28, 251, 65);
		}
		return lblNewLabel;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(22, 85, 173, 340);
			scrollPane.setViewportView(getListSno());
			scrollPane.setColumnHeaderView(getLblNewLabel_2());
		}
		return scrollPane;
	}
	private JList getListSno() {
		if (listSno == null) {
			listSno = new JList();
			listSno.setFont(new Font("������������� Regular", Font.PLAIN, 14));
			listSno.setForeground(new Color(255, 255, 255));
			listSno.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
					
					String sno = (String)listSno.getSelectedValue();
					if(sno == null) return;
//					�׸��� ���õ��� �ʾ����� �ؿ� �ڵ� ������� �ʵ���
					
					// object Ÿ���� String���� ĳ����
					list = map.get(sno); //�й�
					
					modelExam = new DefaultListModel<>();
					for(int i = 0; i<list.size(); i++) {
						ScoreVo vo = list.get(i); // �Ѱ��� ������ ��������
						String temp =
								String.format("%s : %d�г� (%s)", vo.getmName(), vo.getGrade(), vo.getExam());
						modelExam.addElement(temp);
					} // end of for
					listExam.setModel(modelExam);
				}
			});
			listSno.setBackground(new Color(0, 100, 0));
		}
		return listSno;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(207, 85, 216, 340);
			scrollPane_1.setViewportView(getListExam());
			scrollPane_1.setColumnHeaderView(getLblNewLabel_3());
		}
		return scrollPane_1;
	}
	private JList getListExam() {
		if (listExam == null) {
			listExam = new JList();
			listExam.setFont(new Font("������������� Regular", Font.PLAIN, 14));
			listExam.setForeground(new Color(245, 255, 250));
			listExam.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
				
				int index = listExam.getSelectedIndex();
				int grade = -1;
//					������ �׸��� �ε����� ��������
					if (index < 0) {
						return;
					}
				ScoreVo vo = list.get(index);
//				�ش� �ε����� ���� ScoreVoŸ�� ������ ���
				
				panel.tSno.setText(vo.getSno());
				panel.tmName.setText(vo.getmName());
				panel.tKor.setText(vo.getKor()+"");
				panel.tEng.setText(vo.getEng()+"");
				panel.tMat.setText(vo.getMat()+"");
				panel.tTot.setText(vo.getTot()+"");
				panel.tAvg.setText(String.format("%4.1f", vo.getAvg()));
				
//				* �������� ����
				if (vo.getExam().equals("�߰�")) {
					panel.rExam1.setSelected(true);
				} else {
					panel.rExam2.setSelected(true);
				}
				
//				* �г� ����
				grade = vo.getGrade()-1;
//				4�г��� 3��° �ε���, 3�г��� 2��° �ε���
				panel.cGrade.setSelectedIndex(grade);
				
				
				}
			});
			listExam.setBackground(new Color(0, 100, 0));
		}
		return listExam;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new InputPanel();
			panel.rExam2.setForeground(new Color(248, 248, 255));
			panel.rExam1.setForeground(new Color(248, 248, 255));
			panel.rExam2.setBackground(new Color(0, 100, 0));
			panel.rExam1.setBackground(new Color(0, 100, 0));
			panel.setBackground(new Color(0, 100, 0));
			panel.setBounds(435, 85, 280, 340);
		}
		return panel;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(435, 54, 173, 21);
			textField.setColumns(10);
		}
		return textField;
	}
	public JButton getBtnFind() { // �ܺο��� �����ؾ��ϴ� private -> public ����
		if (btnFind == null) {
			btnFind = new JButton("�˻�");
			btnFind.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String findStr = textField.getText();					
					ScoreDao dao = new ScoreDao(map);
					Map<String, List<ScoreVo>> newMap = dao.list(findStr); // �˻��� ���
					
					Set<String> set = newMap.keySet();
					modelSno = new DefaultListModel<String>();
					//modelSno.clear(); �ص���
					
					Iterator<String> iter = set.iterator();
					while(iter.hasNext()) {
						modelSno.addElement(iter.next());
						
					}
					listSno.setModel(modelSno);
					modelExam.clear();
					
//					������ ����
					panel.tSno.setText("");
					panel.tmName.setText("");
					panel.tKor.setText("");
					panel.tEng.setText("");
					panel.tMat.setText("");
					panel.tTot.setText("");
					panel.tAvg.setText("");
					
				}
			});
			btnFind.setForeground(new Color(0, 0, 0));
			btnFind.setBackground(new Color(255, 255, 255));
			btnFind.setFont(new Font("���������� Bold", Font.PLAIN, 13));
			btnFind.setBounds(618, 53, 97, 23);
		}
		return btnFind;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC0AD\uC81C");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String sno= panel.tSno.getText();
					int index = listExam.getSelectedIndex();
					
					ScoreDao dao = new ScoreDao(map);
					boolean b = dao.delete(sno, index);
					
					if(b) {
						status.setText("�ڷᰡ �����Ǿ����ϴ�");
					}else {
						status.setText("���� �� ���� �߻�");
					}
					
					if(modelExam.size()>0) {
					modelExam.remove(index);
					}
//					������ ����
					panel.tSno.setText("");
					panel.tmName.setText("");
					panel.tKor.setText("");
					panel.tEng.setText("");
					panel.tMat.setText("");
					panel.tTot.setText("");
					panel.tAvg.setText("");
					
				}
			});
			btnNewButton_1.setForeground(new Color(0, 0, 0));
			btnNewButton_1.setBackground(new Color(255, 255, 255));
			btnNewButton_1.setFont(new Font("���������� Bold", Font.PLAIN, 13));
			btnNewButton_1.setBounds(616, 435, 97, 30);
		}
		return btnNewButton_1;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("����");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String key = panel.tSno.getText();
					int index = listExam.getSelectedIndex();
					
//					vo �� ��� �۾�
					String mName = panel.tmName.getText();
					String exam ="";
					
					int kor = Integer.parseInt(panel.tKor.getText());
					int eng = Integer.parseInt(panel.tEng.getText());
					int mat = Integer.parseInt(panel.tMat.getText());
					int grade = 0;
					
					if(panel.rExam1.isSelected()) {
						exam = "�߰�";
					} else exam = "�⸻";
					
					grade = panel.cGrade.getSelectedIndex()+1;

					ScoreVo vo = new ScoreVo(key, mName, exam, grade, kor, eng, mat);
					panel.tTot.setText(vo.getTot()+"");
					panel.tAvg.setText(String.format("%6.1f", vo.getAvg()));
					
					ScoreDao dao = new ScoreDao(map); // ���� �������ش�
					boolean b = dao.update(key, index, vo);
					
					if(b) {
						status.setText("���������� �����Ǿ����ϴ�");
					}else {
						status.setText("������ �߻��߽��ϴ�.");
					}
					
				}
			});
			button.setForeground(new Color(0, 0, 0));
			button.setBackground(new Color(255, 255, 255));
			button.setFont(new Font("���������� Bold", Font.PLAIN, 13));
			button.setBounds(509, 435, 97, 30);
		}
		return button;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setOpaque(true);
			status.setBackground(new Color(255, 240, 245));
			status.setBounds(22, 435, 472, 30);
		}
		return status;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setIcon(new ImageIcon("C:\\Users\\JHTA\\Downloads\\37712\\christmas-2194\\png_64\\santa clause,santa,claus,character,xmas,christmas,1619894.png"));
			label.setBounds(22, 21, 92, 65);
		}
		return label;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("");
			label_1.setIcon(new ImageIcon("C:\\Users\\JHTA\\Downloads\\37712\\christmas-2194\\png_64\\christmas-ball,decoration,ball,party,christmas decoration,christmas,xmas,1619930.png"));
			label_1.setBounds(325, -11, 111, 75);
		}
		return label_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uD559\uBC88");
			lblNewLabel_2.setOpaque(true);
			lblNewLabel_2.setBackground(new Color(255, 255, 255));
			lblNewLabel_2.setFont(new Font("������������� Bold", Font.PLAIN, 13));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC2DC\uD5D8 \uC120\uD0DD");
			lblNewLabel_3.setOpaque(true);
			lblNewLabel_3.setBackground(new Color(255, 255, 255));
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3.setFont(new Font("���������� Bold", Font.PLAIN, 13));
		}
		return lblNewLabel_3;
	}
}
