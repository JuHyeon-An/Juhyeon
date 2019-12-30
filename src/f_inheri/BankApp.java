package f_inheri;

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

public class BankApp extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu menu;
	private JMenu mnNewMenu_1;
	private JMenuItem menuItem;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem menuItem_1;
	private JMenuItem mntmNewMenuItem_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankApp frame = new BankApp();
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
	public BankApp() {
		setTitle("\uC740\uD589\uAD00\uB9AC(Ver.0.9)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 400);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnNewMenu());
			menuBar.add(getMenu());
			menuBar.add(getMnNewMenu_1());
		}
		return menuBar;
	}
	private JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("\uACC4\uC88C");
			mnNewMenu.add(getMenuItem());
			mnNewMenu.add(getMntmNewMenuItem());
			mnNewMenu.add(getMntmNewMenuItem_1());
		}
		return mnNewMenu;
	}
	private JMenu getMenu() {
		if (menu == null) {
			menu = new JMenu("");
		}
		return menu;
	}
	private JMenu getMnNewMenu_1() {
		if (mnNewMenu_1 == null) {
			mnNewMenu_1 = new JMenu("\uC785\uCD9C\uAE08");
			mnNewMenu_1.add(getMenuItem_1());
			mnNewMenu_1.add(getMntmNewMenuItem_2());
		}
		return mnNewMenu_1;
	}
	private JMenuItem getMenuItem() {
		if (menuItem == null) {
			menuItem = new JMenuItem("계정생성");
			menuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					contentPane.removeAll();
					AccountCreate ac = new AccountCreate();
					contentPane.add(ac);
					contentPane.updateUI();
				}
			});
		}
		return menuItem;
	}
	private JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("계정목록");
			mntmNewMenuItem.addActionListener(
					new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					contentPane.removeAll();
					AccountList al = new AccountList();
					contentPane.add(al);
					contentPane.updateUI();
					
				}
			});
		}
		return mntmNewMenuItem;
	}
	private JMenuItem getMntmNewMenuItem_1() {
		if (mntmNewMenuItem_1 == null) {
			mntmNewMenuItem_1 = new JMenuItem("\uACC4\uC815\uC218\uC815");
			mntmNewMenuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					contentPane.removeAll();
					AccountModify am = new AccountModify();
					contentPane.add(am);
					contentPane.updateUI();
					
				}
			});
		}
		return mntmNewMenuItem_1;
	}
	private JMenuItem getMenuItem_1() {
		if (menuItem_1 == null) {
			menuItem_1 = new JMenuItem("\uC785\uAE08");
			menuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					contentPane.removeAll();
					Deposit d = new Deposit();
					contentPane.add(d);
					contentPane.updateUI();
					
				}
			});
			menuItem_1.setActionCommand("\uC785\uAE08");
		}
		return menuItem_1;
	}
	private JMenuItem getMntmNewMenuItem_2() {
		if (mntmNewMenuItem_2 == null) {
			mntmNewMenuItem_2 = new JMenuItem("\uCD9C\uAE08");
			mntmNewMenuItem_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					contentPane.removeAll();
					Withdraw wd = new Withdraw();
					contentPane.add(wd);
					contentPane.updateUI();
					
				}
			});
		}
		return mntmNewMenuItem_2;
	}
}
