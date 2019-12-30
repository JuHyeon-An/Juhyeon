package MemberAndProductApp;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MemberMain extends JFrame {

	static String idCheck = "\\w{4,10}";
	static String pwdCheck = "[\\w!$] {4,10}";
	static String nameCheck = "[가-휗] {2,20}";
	static String phoneCheck = "\\d{2,3}-\\d{3,4}-\\d{4}";
	
	List<MemberVo> list = new ArrayList<MemberVo>();
	Set<ProductVo> piList = new HashSet<ProductVo>(); // 입고리스트
	Set<ProductVo> peList = new HashSet<ProductVo>(); // 출고리스트
	
//	입고 순번을 나타내는 시리얼
	static int iSerial = 1;
//	출고 순번을 나타내는 시리얼
	static int eSerial = 1;

	Map<String, List<ScoreVo>> map = new HashMap<String, List<ScoreVo>>();

	private JDesktopPane contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNewMenuItem_5;
	private JMenuItem mntmNewMenuItem_6;
	private JMenu mnNewMenu_2;
	private JMenuItem mntmNewMenuItem_7;	
	private JMenuItem mntmNewMenuItem_8;
	private JMenu mnNewMenu_3;
	private JMenuItem mntmNewMenuItem_9;
	private JMenuItem mntmNewMenuItem_10;
	private JMenuItem mntmNewMenuItem_11;
	private JMenuItem mntmNewMenuItem_12;
	private JMenuItem mntmNewMenuItem_13;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { // EventQueue.invokeLater에서 스타트를 했을것
			public void run() {
				try {
					MemberMain frame = new MemberMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MemberMain() {
		setBackground(new Color(255, 248, 220));
		setForeground(new Color(255, 255, 224));
		setTitle("\uD68C\uC6D0\uAD00\uB9AC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 864, 665);
		setJMenuBar(getMenuBar_1());
		contentPane = new JDesktopPane();
		contentPane.setBackground(new Color(25, 25, 112));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// sample data insert
		for (int i = 0; i < 500; i++) {
			MemberVo vo = new MemberVo("no" + i, "pwd" + i, "name" + i, "010-1111-" + i);
			list.add(vo);
//			입고, 출고 sample data
		}
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (int j = 0; j < 100; j++) {
			String tempSerial = sdf.format(new Date()) + "-" + MemberMain.iSerial;
//				시리얼번호의 형태 "yyyy-MM-dd-번호"
			ProductVo pv = new ProductVo(tempSerial, "pCode" + j, "pName" + j, 3000, new Date());
			piList.add(pv);
			peList.add(pv);
			MemberMain.iSerial++;
			MemberMain.eSerial++;
		}
	
//	성적관리 sample data
		ScoreVo sv = new ScoreVo("1", "kim", "중간", 1, 90, 90, 90);
		List<ScoreVo> list1 = new ArrayList();
		list1.add(sv);
		list1.add(new ScoreVo("1", "kim", "기말", 1, 80, 70, 60));
		list1.add(new ScoreVo("1", "kim", "기말", 2, 50, 60, 70));
		map.put("1", list1); 
//		동일한 사람(kim, 1번)의 서로 다른 정보가 세건 들어감
		
		list1 = new ArrayList<ScoreVo>();
		list1.add(new ScoreVo("2", "lee", "중간", 3, 50, 60, 40));
		list1.add(new ScoreVo("2", "lee", "기말", 3, 40, 30, 40));
		map.put("2", list1);
		
		list1 = new ArrayList<ScoreVo>();
		list1.add(new ScoreVo("3", "hong", "중간", 2, 80, 90, 100));
		list1.add(new ScoreVo("3", "hong", "기말", 2, 60, 20, 40));
		list1.add(new ScoreVo("3", "hong", "중간", 3, 90, 30, 20));
		map.put("3", list1);
		
		
		
		
	
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnNewMenu());
			menuBar.add(getMnNewMenu_1());
			menuBar.add(getMnNewMenu_2());
			menuBar.add(getMnNewMenu_3());
		}
		return menuBar;
	}
	private JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("\uD68C\uC6D0\uAD00\uB9AC");
			mnNewMenu.add(getMntmNewMenuItem());
			mnNewMenu.add(getMntmNewMenuItem_1());
			mnNewMenu.add(getMntmNewMenuItem_2());
		}
		return mnNewMenu;
	}
	private JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("\uC785\uB825");
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					MemberInput m = new MemberInput(list);
					contentPane.add(m);
					m.toFront();
				}
				
			});
		}
		return mntmNewMenuItem;
	}
	private JMenuItem getMntmNewMenuItem_1() {
		if (mntmNewMenuItem_1 == null) {
			mntmNewMenuItem_1 = new JMenuItem("조회");
			mntmNewMenuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					MemberSearch m = new MemberSearch(list); // list를 받아 Search로 넘긴다
					contentPane.add(m);
					m.toFront();

					
				}
			});
		}
		return mntmNewMenuItem_1;
	}
	private JMenuItem getMntmNewMenuItem_2() {
		if (mntmNewMenuItem_2 == null) {
			mntmNewMenuItem_2 = new JMenuItem("수정/삭제");
			mntmNewMenuItem_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
				MemberModify m = new MemberModify(list);
				contentPane.add(m);
				m.toFront();
				
				}
			});
		}
		return mntmNewMenuItem_2;
	}
	private JMenu getMnNewMenu_1() {
		if (mnNewMenu_1 == null) {
			mnNewMenu_1 = new JMenu("자재관리");
			mnNewMenu_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			mnNewMenu_1.add(getMntmNewMenuItem_3());
			mnNewMenu_1.add(getMntmNewMenuItem_4());
			mnNewMenu_1.add(getMntmNewMenuItem_5());
			mnNewMenu_1.add(getMntmNewMenuItem_6());
		}
		return mnNewMenu_1;
	}
	private JMenuItem getMntmNewMenuItem_3() {
		if (mntmNewMenuItem_3 == null) {
			mntmNewMenuItem_3 = new JMenuItem("입고");
			mntmNewMenuItem_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					ProductInput panel = new ProductInput(piList);
					contentPane.add(panel);
					panel.toFront();

					
				}
			});
		}
		return mntmNewMenuItem_3;
	}
	private JMenuItem getMntmNewMenuItem_4() {
		if (mntmNewMenuItem_4 == null) {
			mntmNewMenuItem_4 = new JMenuItem("출고");
			mntmNewMenuItem_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					ProductOutput panel = new ProductOutput(peList);
					contentPane.add(panel);
					panel.toFront();

				}
			});
		}
		return mntmNewMenuItem_4;
	}
	private JMenuItem getMntmNewMenuItem_5() {
		if (mntmNewMenuItem_5 == null) {
			mntmNewMenuItem_5 = new JMenuItem("조회");
			mntmNewMenuItem_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					ProductSearch panel = new ProductSearch(piList, peList);
					contentPane.add(panel);
					panel.toFront();
					
				}
			});
		}
		return mntmNewMenuItem_5;
	}
	private JMenuItem getMntmNewMenuItem_6() {
		if (mntmNewMenuItem_6 == null) {
			mntmNewMenuItem_6 = new JMenuItem("수정/삭제");
			mntmNewMenuItem_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					ProductModify panel = new ProductModify(piList, peList);
					contentPane.add(panel);
					panel.toFront();

					
				}
			});
		}
		return mntmNewMenuItem_6;
	}
	private JMenu getMnNewMenu_2() {
		if (mnNewMenu_2 == null) {
			mnNewMenu_2 = new JMenu("성적관리");
			mnNewMenu_2.add(getMntmNewMenuItem_7());
			mnNewMenu_2.add(getMntmNewMenuItem_8());
		}
		return mnNewMenu_2;
	}
	private JMenuItem getMntmNewMenuItem_7() {
		if (mntmNewMenuItem_7 == null) {
			mntmNewMenuItem_7 = new JMenuItem("입력");
			mntmNewMenuItem_7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					ScoreInput pane = new ScoreInput(map, MemberMain.this); // membermain의 자기자신
//					메인프레임이 가지고 있는 인터널 프레임들에 접근하게 하기 위해 성적입력창을 띄울 때 자기자신을 성적입력창에 레퍼런싱
					contentPane.add(pane);
					contentPane.updateUI();
					pane.toFront();
					
				}
			});
		}
		return mntmNewMenuItem_7;
	}
	private JMenuItem getMntmNewMenuItem_8() {
		if (mntmNewMenuItem_8 == null) {
			mntmNewMenuItem_8 = new JMenuItem("조회");
			mntmNewMenuItem_8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					ScoreSearch pane = new ScoreSearch(map); // ScoreSearch의 생성자를 통해서 전달
					contentPane.add(pane);
					contentPane.updateUI();
					pane.toFront();
					
				}
			});
		}
		return mntmNewMenuItem_8;
	}
	private JMenu getMnNewMenu_3() {
		if (mnNewMenu_3 == null) {
			mnNewMenu_3 = new JMenu("기타 컬렉션");
			mnNewMenu_3.add(getMntmNewMenuItem_9());
			mnNewMenu_3.add(getMntmNewMenuItem_10());
			mnNewMenu_3.add(getMntmNewMenuItem_11());
			mnNewMenu_3.add(getMntmNewMenuItem_12());
			mnNewMenu_3.add(getMntmNewMenuItem_13());
		}
		return mnNewMenu_3;
	}
	private JMenuItem getMntmNewMenuItem_9() {
		if (mntmNewMenuItem_9 == null) {
			mntmNewMenuItem_9 = new JMenuItem("Properties");
			mntmNewMenuItem_9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PropertiesFrame panel = new PropertiesFrame();
					contentPane.add(panel);
					panel.toFront();
				}
			});
		}
		return mntmNewMenuItem_9;
	}
	private JMenuItem getMntmNewMenuItem_10() {
		if (mntmNewMenuItem_10 == null) {
			mntmNewMenuItem_10 = new JMenuItem("TreeSet");
			mntmNewMenuItem_10.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TreeSetFrame panel = new TreeSetFrame();
					contentPane.add(panel);
					panel.toFront();
				}
			});
		}
		return mntmNewMenuItem_10;
	}
	private JMenuItem getMntmNewMenuItem_11() {
		if (mntmNewMenuItem_11 == null) {
			mntmNewMenuItem_11 = new JMenuItem("TreeMap");
			mntmNewMenuItem_11.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TreeMapFrame panel = new TreeMapFrame();
					contentPane.add(panel);
					panel.toFront();
				}
			});
		}
		return mntmNewMenuItem_11;
	}
	private JMenuItem getMntmNewMenuItem_12() {
		if (mntmNewMenuItem_12 == null) {
			mntmNewMenuItem_12 = new JMenuItem("Stack");
			mntmNewMenuItem_12.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					StackFrame panel = new StackFrame();
					contentPane.add(panel);
					panel.toFront();
					
				}
			});
		}
		return mntmNewMenuItem_12;
	}
	private JMenuItem getMntmNewMenuItem_13() {
		if (mntmNewMenuItem_13 == null) {
			mntmNewMenuItem_13 = new JMenuItem("Queue");
			mntmNewMenuItem_13.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					QueueFrame panel = new QueueFrame();
					contentPane.add(panel);
					panel.toFront();
				
				}
			});
		}
		return mntmNewMenuItem_13;
	}
}
