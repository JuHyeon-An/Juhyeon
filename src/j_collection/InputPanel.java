package j_collection;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class InputPanel extends JPanel {
	
	ButtonGroup group = new ButtonGroup();
	
	private JLabel lblNewLabel;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	public JTextField tSno;
	public JTextField tmName;
	public JRadioButton rExam1;
	public JRadioButton rExam2;
	public JTextField tKor;
	public JTextField tEng;
	public JTextField tMat;
	public JTextField tTot;
	public JTextField tAvg;
	public JComboBox cGrade;

	public InputPanel() {
		setBackground(new Color(144, 238, 144));
		setLayout(null);
		add(getLblNewLabel());
		add(getLabel());
		add(getLabel_1());
		add(getLabel_2());
		add(getLabel_3());
		add(getLabel_4());
		add(getLabel_5());
		add(getLabel_6());
		add(getLabel_7());
		add(getTSno());
		add(getTmName());
		add(getRExam1());
		add(getRExam2());
		add(getTKor());
		add(getTEng());
		add(getTMat());
		add(getTTot());
		add(getTAvg());
		add(getCGrade());

	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uD559\uBC88");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 14));
			lblNewLabel.setBounds(12, 21, 57, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uC131\uBA85");
			label.setForeground(new Color(255, 255, 255));
			label.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 14));
			label.setBounds(12, 57, 57, 15);
		}
		return label;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uC2DC\uD5D8 \uC885\uB958");
			label_1.setForeground(new Color(255, 255, 255));
			label_1.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 14));
			label_1.setBounds(12, 93, 57, 15);
		}
		return label_1;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("\uD559\uB144");
			label_2.setForeground(new Color(255, 255, 255));
			label_2.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 14));
			label_2.setBounds(12, 129, 57, 15);
		}
		return label_2;
	}
	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("\uAD6D\uC5B4");
			label_3.setForeground(new Color(255, 255, 255));
			label_3.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 14));
			label_3.setBounds(12, 165, 57, 15);
		}
		return label_3;
	}
	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("\uC601\uC5B4");
			label_4.setForeground(new Color(255, 255, 255));
			label_4.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 14));
			label_4.setBounds(12, 201, 57, 15);
		}
		return label_4;
	}
	private JLabel getLabel_5() {
		if (label_5 == null) {
			label_5 = new JLabel("\uC218\uD559");
			label_5.setForeground(new Color(255, 255, 255));
			label_5.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 14));
			label_5.setBounds(12, 237, 57, 15);
		}
		return label_5;
	}
	private JLabel getLabel_6() {
		if (label_6 == null) {
			label_6 = new JLabel("\uCD1D\uC810");
			label_6.setForeground(new Color(255, 255, 255));
			label_6.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 14));
			label_6.setBounds(12, 273, 57, 15);
		}
		return label_6;
	}
	private JLabel getLabel_7() {
		if (label_7 == null) {
			label_7 = new JLabel("\uD3C9\uADE0");
			label_7.setForeground(new Color(255, 255, 255));
			label_7.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 14));
			label_7.setBounds(12, 309, 57, 15);
		}
		return label_7;
	}
	private JTextField getTSno() {
		if (tSno == null) {
			tSno = new JTextField();
			tSno.setBounds(81, 16, 116, 21);
			tSno.setColumns(10);
		}
		return tSno;
	}
	private JTextField getTmName() {
		if (tmName == null) {
			tmName = new JTextField();
			tmName.setColumns(10);
			tmName.setBounds(81, 53, 101, 21);
		}
		return tmName;
	}
	private JRadioButton getRExam1() {
		if (rExam1 == null) {
			rExam1 = new JRadioButton("\uC911\uAC04");
			rExam1.setBackground(new Color(144, 238, 144));
			rExam1.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 13));
			rExam1.setBounds(77, 90, 57, 23);
			group.add(rExam1);
			rExam1.setSelected(true);
		}
		return rExam1;
	}
	private JRadioButton getRExam2() {
		if (rExam2 == null) {
			rExam2 = new JRadioButton("\uAE30\uB9D0");
			rExam2.setBackground(new Color(144, 238, 144));
			rExam2.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 13));
			rExam2.setBounds(140, 90, 57, 23);
			group.add(rExam2);

		}
		return rExam2;
	}
	private JTextField getTKor() {
		if (tKor == null) {
			tKor = new JTextField();
			tKor.setColumns(10);
			tKor.setBounds(81, 164, 61, 21);
		}
		return tKor;
	}
	private JTextField getTEng() {
		if (tEng == null) {
			tEng = new JTextField();
			tEng.setColumns(10);
			tEng.setBounds(81, 201, 61, 21);
		}
		return tEng;
	}
	private JTextField getTMat() {
		if (tMat == null) {
			tMat = new JTextField();
			tMat.setColumns(10);
			tMat.setBounds(81, 238, 61, 21);
		}
		return tMat;
	}
	private JTextField getTTot() {
		if (tTot == null) {
			tTot = new JTextField();
			tTot.setEditable(false);
			tTot.setColumns(10);
			tTot.setBounds(81, 275, 76, 21);
		}
		return tTot;
	}
	private JTextField getTAvg() {
		if (tAvg == null) {
			tAvg = new JTextField();
			tAvg.setEditable(false);
			tAvg.setColumns(10);
			tAvg.setBounds(81, 312, 91, 21);
		}
		return tAvg;
	}
	private JComboBox getCGrade() {
		if (cGrade == null) {
			cGrade = new JComboBox();
			cGrade.setBounds(81, 129, 116, 19);
			
			cGrade.addItem("1ÇÐ³â");
			cGrade.addItem("2ÇÐ³â");
			cGrade.addItem("3ÇÐ³â");
			cGrade.addItem("4ÇÐ³â");
			cGrade.setSelectedIndex(0); //1ÇÐ³âÀ» ±âº»°ªÀ¸·Î
			
		}
		return cGrade;
	}
}
