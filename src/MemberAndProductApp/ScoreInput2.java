package MemberAndProductApp;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JList;

public class ScoreInput2 extends JInternalFrame {
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JTextField mName;
	private JTextField sno;
	private JButton button;
	private JLabel status;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JTextField kor;
	private JTextField eng;
	private JTextField mat;
	private JTextField tot;
	private JTextField avg;
	private JSeparator separator;
	private JButton btnNewButton;
	private JRadioButton midBtn;
	private JRadioButton finalBtn;

	ButtonGroup group = new ButtonGroup();
	
	Map<String, ScoreVo> midMap = new HashMap<String, ScoreVo>();
	Map<String, ScoreVo> finalMap = new HashMap<String, ScoreVo>();
	private JTextField grade;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreInput2 frame = new ScoreInput2();
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
	
	public ScoreInput2(Map<String, ScoreVo> midMap, Map<String, ScoreVo> finalMap ) {
		this.midMap = midMap;
		this.finalMap = finalMap;
	}
	
	public ScoreInput2() {
		super("¼ºÀûÀÔ·Â", true, true, true, true);
		setVisible(true);
		setBounds(100, 100, 295, 410);
		getContentPane().setLayout(null);
		getContentPane().add(getLabel());
		getContentPane().add(getLabel_1());
		getContentPane().add(getLabel_2());
		getContentPane().add(getLabel_3());
		getContentPane().add(getMName());
		getContentPane().add(getSno());
		getContentPane().add(getButton());
		getContentPane().add(getStatus());
		getContentPane().add(getLabel_5());
		getContentPane().add(getLabel_6());
		getContentPane().add(getLabel_7());
		getContentPane().add(getLabel_8());
		getContentPane().add(getKor());
		getContentPane().add(getEng());
		getContentPane().add(getMat());
		getContentPane().add(getTot());
		getContentPane().add(getAvg());
		getContentPane().add(getSeparator());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getMidBtn());
		getContentPane().add(getFinalBtn());
		getContentPane().add(getGrade());

	}
	
	public void insert() {
		String n = mName.getText();
		String s = sno.getText();
		int g = Integer.parseInt(grade.getText());
		int k = Integer.parseInt(kor.getText());
		int en = Integer.parseInt(eng.getText());
		int m = Integer.parseInt(mat.getText());
		
		int t = k+en+m;
		double ag = t/3.0;
		
			
		Map<String, ScoreVo> map;
		if(midBtn.isSelected()) {
			map = midMap;
		}else map = finalMap;
		
		
		map.put(s, new ScoreVo(s, n, g, k, en, m, t, ag));
		status.setText(map.size()+"¹øÂ° ÇÐ»ýÀÇ ¼ºÀûÀÌ ÀÔ·ÂµÇ¾ú½À´Ï´Ù");
		mName.setText("");
		sno.setText("");
		grade.setText("");
		kor.setText("");
		eng.setText("");
		mat.setText("");
		tot.setText("");
		avg.setText("");
	}
	
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uC774\uB984");
			label.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
			label.setBounds(12, 36, 57, 15);
		}
		return label;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uD559\uBC88");
			label_1.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
			label_1.setBounds(12, 61, 57, 15);
		}
		return label_1;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("\uD559\uB144");
			label_2.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
			label_2.setBounds(12, 86, 57, 15);
		}
		return label_2;
	}
	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("\uAD6D\uC5B4\uC131\uC801");
			label_3.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
			label_3.setBounds(12, 111, 57, 15);
		}
		return label_3;
	}
	private JTextField getMName() {
		if (mName == null) {
			mName = new JTextField();
			mName.setColumns(10);
			mName.setBounds(81, 32, 116, 21);
		}
		return mName;
	}
	private JTextField getSno() {
		if (sno == null) {
			sno = new JTextField();
			sno.setColumns(10);
			sno.setBounds(81, 57, 96, 21);
		}
		return sno;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("\uC785\uB825");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
				insert();
				}

	
			});
			button.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå Bold", Font.PLAIN, 13));
			button.setBackground(new Color(245, 255, 250));
			button.setBounds(93, 291, 104, 38);
		}
		return button;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setOpaque(true);
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 13));
			status.setBackground(new Color(175, 238, 238));
			status.setBounds(18, 339, 241, 32);
		}
		return status;
	}
	private JLabel getLabel_5() {
		if (label_5 == null) {
			label_5 = new JLabel("\uC601\uC5B4\uC131\uC801");
			label_5.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
			label_5.setBounds(12, 136, 57, 15);
		}
		return label_5;
	}
	private JLabel getLabel_6() {
		if (label_6 == null) {
			label_6 = new JLabel("\uC218\uD559\uC131\uC801");
			label_6.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
			label_6.setBounds(12, 161, 57, 15);
		}
		return label_6;
	}
	private JLabel getLabel_7() {
		if (label_7 == null) {
			label_7 = new JLabel("\uCD1D\uC810");
			label_7.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
			label_7.setBounds(63, 233, 57, 15);
		}
		return label_7;
	}
	private JLabel getLabel_8() {
		if (label_8 == null) {
			label_8 = new JLabel("\uD3C9\uADE0");
			label_8.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
			label_8.setBounds(63, 264, 57, 15);
		}
		return label_8;
	}
	private JTextField getKor() {
		if (kor == null) {
			kor = new JTextField();
			kor.setColumns(10);
			kor.setBounds(81, 107, 75, 21);
		}
		return kor;
	}
	private JTextField getEng() {
		if (eng == null) {
			eng = new JTextField();
			eng.setColumns(10);
			eng.setBounds(81, 132, 75, 21);
		}
		return eng;
	}
	private JTextField getMat() {
		if (mat == null) {
			mat = new JTextField();
			mat.setColumns(10);
			mat.setBounds(81, 157, 75, 21);
		}
		return mat;
	}
	private JTextField getTot() {
		if (tot == null) {
			tot = new JTextField();
			tot.setEditable(false);
			tot.setColumns(10);
			tot.setBounds(132, 229, 75, 21);
		}
		return tot;
	}
	private JTextField getAvg() {
		if (avg == null) {
			avg = new JTextField();
			avg.setEditable(false);
			avg.setColumns(10);
			avg.setBounds(132, 260, 75, 21);
		}
		return avg;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(12, 221, 247, 2);
		}
		return separator;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uCD1D\uC810/\uD3C9\uADE0\uACC4\uC0B0");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String n = mName.getText();
					String s = sno.getText();
					int g = Integer.parseInt(grade.getText());
					int k = Integer.parseInt(kor.getText());
					int en = Integer.parseInt(eng.getText());
					int m = Integer.parseInt(mat.getText());
					
					int t = k+en+m;
					double ag = t/3.0;
					
					tot.setText(t+"");
					avg.setText(ag+"");
										
					
				}
			});
			btnNewButton.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå Light", Font.PLAIN, 12));
			btnNewButton.setBounds(81, 188, 126, 23);
		}
		return btnNewButton;
	}
	private JRadioButton getMidBtn() {
		if (midBtn == null) {
			midBtn = new JRadioButton("\uC911\uAC04\uACE0\uC0AC");
			midBtn.setBounds(8, 6, 75, 23);
			group.add(midBtn);
			midBtn.setSelected(true);
		}
		return midBtn;
	}
	private JRadioButton getFinalBtn() {
		if (finalBtn == null) {
			finalBtn = new JRadioButton("\uAE30\uB9D0\uACE0\uC0AC");
			finalBtn.setBounds(81, 6, 121, 23);
			group.add(finalBtn);
			
		}
		return finalBtn;
	}
	private JTextField getGrade() {
		if (grade == null) {
			grade = new JTextField();
			grade.setBounds(81, 82, 96, 21);
			grade.setColumns(10);
		}
		return grade;
	}
}
