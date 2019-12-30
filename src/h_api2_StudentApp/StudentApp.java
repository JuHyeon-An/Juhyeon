package h_api2_StudentApp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;

public class StudentApp extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem menuItem;
	JPanel panel;

	static Student[] st;
	static int count;
	private JLabel status; // 상태표시줄
	private JMenuItem mntmHome;

	static {
		st = new Student[100];

		st[0] = new Student(15, "hong", 30);
		st[1] = new Student(67, "kim", 70);
		st[2] = new Student(28, "choi", 90);
		st[3] = new Student(35, "lee", 20);

		count = 4;

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentApp frame = new StudentApp();
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
	public StudentApp() {
		setTitle("\uC131\uC801\uAD00\uB9AC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 382);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panel = new Main();
		contentPane.add(getStatus(), BorderLayout.SOUTH);
		contentPane.add(panel, BorderLayout.CENTER);

	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnNewMenu());
		}
		return menuBar;
	}

	private JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("\uC131\uC801\uAD00\uB9AC");
			mnNewMenu.add(getMntmHome());
			mnNewMenu.add(getMntmNewMenuItem());
			mnNewMenu.add(getMntmNewMenuItem_1());
			mnNewMenu.add(getMenuItem());
		}
		return mnNewMenu;
	}

	private JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("성적입력");
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if (panel != null) {
						contentPane.remove(panel);
					}
					panel = new ScoreInput(status);
					contentPane.add(panel);
					contentPane.updateUI();
					status.setText("성적을 입력하세요");
				}
			});
		}
		return mntmNewMenuItem;
	}

	private JMenuItem getMntmNewMenuItem_1() {
		if (mntmNewMenuItem_1 == null) {
			mntmNewMenuItem_1 = new JMenuItem("학번순 정렬");
			mntmNewMenuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if (panel != null) {
						contentPane.remove(panel);
					}
					panel = new SortBySno(status);
					contentPane.add(panel);
					contentPane.updateUI();
					status.setText("학번순으로 정렬이 되었습니다.");

				}
			});
		}
		return mntmNewMenuItem_1;
	}

	private JMenuItem getMenuItem() {
		if (menuItem == null) {
			menuItem = new JMenuItem("성적순 정렬");
			menuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (panel != null) {
						contentPane.remove(panel);
					}
					panel = new SortByScore(status);
					contentPane.add(panel);
					contentPane.updateUI();
					status.setText("성적순으로 정렬이 되었습니다.");
				}
			});
		}
		return menuItem;
	}

	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("\uBA54\uB274\uB97C \uC120\uD0DD\uD558\uC138\uC694~~~~~~");
			status.setForeground(new Color(105, 105, 105));
			status.setPreferredSize(new Dimension(154, 20));
			status.setFont(new Font("맑은 고딕", Font.BOLD, 14));
			status.setOpaque(true);
			status.setBackground(new Color(250, 240, 230));
			status.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return status;
	}

	private JMenuItem getMntmHome() {
		if (mntmHome == null) {
			mntmHome = new JMenuItem("Home");
			mntmHome.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (panel != null) { // panel이 있다면 삭제해라.
						contentPane.remove(panel);
					}
					panel = new Main();
					contentPane.add(panel);
					contentPane.updateUI();
					status.setText("홈입니다. 메뉴를 선택하세요~~");
				}
			});
		}
		return mntmHome;
	}
}
