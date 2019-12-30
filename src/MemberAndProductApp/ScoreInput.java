package MemberAndProductApp;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import j_collection.InputPanel;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;

public class ScoreInput extends JInternalFrame {
	
	Map<String, List<ScoreVo>> map;
	MemberMain mm;
	
	
	private JLabel lblNewLabel;
	private InputPanel panel;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel status;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreInput frame = new ScoreInput();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ScoreInput(Map<String, List<ScoreVo>> map) {
		this();
		this.map = map;
	}
	
	public ScoreInput(Map<String, List<ScoreVo>> map, MemberMain mm) {
		// membermain �� �ִ� ��ſ� JPanel Ŭ���� �Ѱ��൵ ��
		this();
		this.map = map;
		this.mm = mm;
	}
	
	public ScoreInput() {
		super("�����Է�", true, true, true, true);
		setVisible(true);
		getContentPane().setBackground(new Color(178, 34, 34));
		setTitle("\uC131\uC801\uC785\uB825");
		setBounds(80, 30, 331, 515);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getPanel());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getStatus());

	}

	public void sync() {
		Object[] obj = mm.getContentPane().getComponents(); // add�� �Ǿ��ִ� ��� ������Ʈ
//		������ ������ �ִ� ���ͳ� ������ �� �� ������
//		������ component�迭�� ��ȯ���ε�, ������ ĳ�����ؾߵǴ� object�迭�� �޾���
		for (int i = 0; i < obj.length; i++) {
			if(obj[i] instanceof ScoreSearch) {
				ScoreSearch ss = (ScoreSearch)obj[i];
				ss.btnFind.doClick(); // trigger �̺�Ʈ �߻�
			}
		}
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC131\uC801\uC785\uB825");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("����ǹ��� ����", Font.PLAIN, 30));
			lblNewLabel.setBounds(53, 28, 167, 42);
		}
		return lblNewLabel;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new InputPanel();
			panel.rExam2.setForeground(new Color(248, 248, 255));
			panel.rExam1.setForeground(new Color(248, 248, 255));
			panel.rExam2.setBackground(new Color(0, 100, 0));
			panel.rExam1.setBackground(new Color(0, 100, 0));
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBackground(new Color(0, 100, 0));
			panel.setBounds(12, 74, 288, 338);
			panel.add(getLblNewLabel_2());
		}
		return panel;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("����");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				
//				���Ἲ üũ
				// TODO
					
				String sno = panel.tSno.getText();
				String mName = panel.tmName.getText();
				int kor = Integer.parseInt(panel.tKor.getText());
				int eng = Integer.parseInt(panel.tEng.getText());
				int mat = Integer.parseInt(panel.tMat.getText());
				String exam = "";
				int    grade = 0;
				
				
//				 ������ư���� �߰�/�⸻ �� exam ������ ���
				if(panel.rExam1.isSelected()) {
					exam = "�߰�";
				}else {
					exam = "�⸻";
				}
				
//				�޺��ڽ����� ���õ� �ε������� +1
				grade = panel.cGrade.getSelectedIndex()+1;

				ScoreVo vo = new ScoreVo(sno, mName, exam, grade, kor, eng, mat);
				panel.tTot.setText(vo.getTot()+"");
				panel.tAvg.setText(String.format("%6.1f", vo.getAvg()));
//												��ü �����ڸ��� �Ҽ��� 1�ڸ�
				
				ScoreDao dao = new ScoreDao(map);
				boolean b = dao.insert(vo);
				
					if (b) {
						status.setText("�����Ͱ� ����Ǿ����ϴ�");
						sync();
					} else {
						status.setText("���� �� ���� �߻�");
					}
				}
			});
			btnNewButton.setBackground(new Color(216, 191, 216));
			btnNewButton.setFont(new Font("�����ٸ����", Font.PLAIN, 14));
			btnNewButton.setBounds(106, 442, 97, 34);
		}
		return btnNewButton;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setBounds(12, 0, 76, 70);
			lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\JHTA\\Downloads\\37712\\christmas-2194\\png_64\\wreath,xmas wreath,decoration,celebration,christmas,leaf,christmas wreath,1619891.png"));
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\JHTA\\Downloads\\37712\\christmas-2194\\png_64\\christmas socks,candy,toffee,stick,christmas,present,santa,decoration,holiday,1619928.png"));
			lblNewLabel_2.setBounds(184, 261, 101, 79);
		}
		return lblNewLabel_2;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setForeground(new Color(255, 250, 250));
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setBounds(12, 416, 288, 21);
		}
		return status;
	}
}
