package io_App;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.EmptyBorder;

import k_io.FileCopy;

public class FileExam2 extends JFrame {

	static String idCheck = "\\d\\w{4,10}";
	static String pwdCheck = "[\\d\\w!$]{4,10}";
	static String nameCheck = "[가-휗]{2,20}";
	static String phoneCheck = "\\d{2,3}-\\d{3,4}-\\d{4}";
	
	private JDesktopPane contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_1;
	private JMenu mnNewMenu_2;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNewMenuItem_5;
	private JMenuItem mntmNewMenuItem_6;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileExam2 frame = new FileExam2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FileExam2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 487);
		setJMenuBar(getMenuBar_1());
		contentPane = new JDesktopPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnNewMenu());
			menuBar.add(getMnNewMenu_1());
			menuBar.add(getMnNewMenu_2());
		}
		return menuBar;
	}
	private JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("File");
			mnNewMenu.add(getMntmNewMenuItem());
		}
		return mnNewMenu;
	}
	private JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("\uD30C\uC77C\uBCF5\uC0AC");
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				FileCopy panel = new FileCopy();
				contentPane.add(panel);
				panel.toFront();
				}
			});
		}
		return mntmNewMenuItem;
	}
	private JMenu getMnNewMenu_1() {
		if (mnNewMenu_1 == null) {
			mnNewMenu_1 = new JMenu("\uD30C\uC77C\uD3B8\uC9D1");
			mnNewMenu_1.add(getMntmNewMenuItem_1());
			mnNewMenu_1.add(getMntmNewMenuItem_2());
			mnNewMenu_1.add(getMntmNewMenuItem_3());
		}
		return mnNewMenu_1;
	}
	private JMenuItem getMntmNewMenuItem_2() {
		if (mntmNewMenuItem_2 == null) {
			mntmNewMenuItem_2 = new JMenuItem("\uBD88\uB7EC\uC624\uAE30");
			mntmNewMenuItem_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					JFileChooser fc = new JFileChooser();
					int flag = fc.showOpenDialog(FileExam2.this);
					if(flag==JFileChooser.APPROVE_OPTION) {
						String fileName = fc.getSelectedFile().getPath();
						TextEditor panel = new TextEditor(fileName);
						contentPane.add(panel);
						panel.toFront();
					}
					
					
				}
			});
		}
		return mntmNewMenuItem_2;
	}
	private JMenuItem getMntmNewMenuItem_3() {
		if (mntmNewMenuItem_3 == null) {
			mntmNewMenuItem_3 = new JMenuItem("\uC800\uC7A5\uD558\uAE30");
			mntmNewMenuItem_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				JInternalFrame frame = contentPane.getSelectedFrame();
				// contentPane이 가지고 있는 요소들 중에서 활성화되어있는 Frame
				
				if(frame instanceof TextEditor) {
					// frame이 TextEditor로 만들어졌을때(다른 클래스 종류일 가능성도 있어서)
					TextEditor te = (TextEditor)frame;
					// textEditor가 가지고 있는 load, save 쓰려면 frame을 캐스팅해줘야됨
					// InternalFrame이 부모, TextEditor가 자식이기때문에 자식에서 추가한 기능은 사용 X
					
					//새로만들기 한 경우엔 TextEditor의 fileName()이 null
					if(te.fileName == null) {
						JFileChooser fc = new JFileChooser();
						int flag = fc.showSaveDialog(FileExam2.this);
						if(flag == JFileChooser.APPROVE_OPTION) {
							te.fileName = fc.getSelectedFile().getPath();
							te.setTitle(te.fileName);
						}else {
							te.getStatus().setText("파일 저장 작업이 취소됨.");
							return;
						}
					}
					
					boolean b = te.save();
					if(b) {
						te.getStatus().setText("파일이 정상적으로 저장되었습니다");
					}else {
						te.getStatus().setText("파일 저장 중 오류 발생");
					}
				}
				
				
				}
			});
		}
		return mntmNewMenuItem_3;
	}
	private JMenuItem getMntmNewMenuItem_1() {
		if (mntmNewMenuItem_1 == null) {
			mntmNewMenuItem_1 = new JMenuItem("\uC0C8\uB85C\uB9CC\uB4E4\uAE30");
			mntmNewMenuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					TextEditor panel = new TextEditor();
					contentPane.add(panel);
					panel.toFront();
					
				}
			});
		}
		return mntmNewMenuItem_1;
	}
	public JMenu getMnNewMenu_2() {
		if (mnNewMenu_2 == null) {
			mnNewMenu_2 = new JMenu("회원관리");
			mnNewMenu_2.add(getMntmNewMenuItem_4());
			mnNewMenu_2.add(getMntmNewMenuItem_5());
			mnNewMenu_2.add(getMntmNewMenuItem_6());
		}
		return mnNewMenu_2;
	}
	public JMenuItem getMntmNewMenuItem_4() {
		if (mntmNewMenuItem_4 == null) {
			mntmNewMenuItem_4 = new JMenuItem("회원입력");
			mntmNewMenuItem_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
	
					MemberInput panel = new MemberInput();
				contentPane.add(panel);
				panel.toFront();
				
				}
			});
		}
		return mntmNewMenuItem_4;
	}
	public JMenuItem getMntmNewMenuItem_5() {
		if (mntmNewMenuItem_5 == null) {
			mntmNewMenuItem_5 = new JMenuItem("회원조회");
			mntmNewMenuItem_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
				MemberSearch panel = new MemberSearch();
				contentPane.add(panel);
				panel.toFront();
				
				}
			});
		}
		return mntmNewMenuItem_5;
	}
	public JMenuItem getMntmNewMenuItem_6() {
		if (mntmNewMenuItem_6 == null) {
			mntmNewMenuItem_6 = new JMenuItem("회원수정/삭제");
			mntmNewMenuItem_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
				MemberModify panel = new MemberModify();
				contentPane.add(panel);
				panel.toFront();
				
				}
			});
		}
		return mntmNewMenuItem_6;
	}
}
