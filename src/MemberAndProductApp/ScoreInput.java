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
		// membermain 다 주는 대신에 JPanel 클래스 넘겨줘도 됨
		this();
		this.map = map;
		this.mm = mm;
	}
	
	public ScoreInput() {
		super("성적입력", true, true, true, true);
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
		Object[] obj = mm.getContentPane().getComponents(); // add가 되어있는 모든 컴포넌트
//		메인이 가지고 있는 인터널 프레임 등 다 가져옴
//		원래는 component배열이 반환형인데, 어차피 캐스팅해야되니 object배열로 받았음
		for (int i = 0; i < obj.length; i++) {
			if(obj[i] instanceof ScoreSearch) {
				ScoreSearch ss = (ScoreSearch)obj[i];
				ss.btnFind.doClick(); // trigger 이벤트 발생
			}
		}
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC131\uC801\uC785\uB825");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("배달의민족 도현", Font.PLAIN, 30));
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
			btnNewButton = new JButton("저장");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				
//				무결성 체크
				// TODO
					
				String sno = panel.tSno.getText();
				String mName = panel.tmName.getText();
				int kor = Integer.parseInt(panel.tKor.getText());
				int eng = Integer.parseInt(panel.tEng.getText());
				int mat = Integer.parseInt(panel.tMat.getText());
				String exam = "";
				int    grade = 0;
				
				
//				 라디오버튼으로 중간/기말 값 exam 변수에 담기
				if(panel.rExam1.isSelected()) {
					exam = "중간";
				}else {
					exam = "기말";
				}
				
//				콤보박스에서 선택된 인덱스값에 +1
				grade = panel.cGrade.getSelectedIndex()+1;

				ScoreVo vo = new ScoreVo(sno, mName, exam, grade, kor, eng, mat);
				panel.tTot.setText(vo.getTot()+"");
				panel.tAvg.setText(String.format("%6.1f", vo.getAvg()));
//												전체 여섯자리에 소수점 1자리
				
				ScoreDao dao = new ScoreDao(map);
				boolean b = dao.insert(vo);
				
					if (b) {
						status.setText("데이터가 저장되었습니다");
						sync();
					} else {
						status.setText("저장 중 오류 발생");
					}
				}
			});
			btnNewButton.setBackground(new Color(216, 191, 216));
			btnNewButton.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
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
