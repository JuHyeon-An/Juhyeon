package k_io;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.util.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MemberSearch extends JInternalFrame {
	
	List<MemberVo> list;
	
	private JPanel panel;
	public JTextField findStr;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JLabel lblNewLabel;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberSearch frame = new MemberSearch();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}
	
	public MemberSearch() {
		super("회원정보 조회", false, true, true, true);
		setVisible(true);
		setBounds(500, 300, 445, 377);
		getContentPane().add(getPanel(), BorderLayout.NORTH);
		getContentPane().add(getScrollPane(), BorderLayout.CENTER);
	}
	
	
	public void search() {
		textArea.setText(""); // 깨끗하게 텍스트창 지워주기
		MemberDao dao = new MemberDao();
		List<MemberVo> list = dao.search(this);
		//this : MemberSearch라고 부르는 클래스 자체를 뜻함 (MemberSearch.this)
		for(MemberVo vo : list) {
			textArea.append(vo.toString());
		}
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(10, 30));
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getFindStr(), BorderLayout.CENTER);
			panel.add(getBtnNewButton(), BorderLayout.EAST);
		}
		return panel;
	}
	private JTextField getFindStr() {
		if (findStr == null) {
			findStr = new JTextField();
			findStr.setColumns(10);
		}
		return findStr;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					search();
					
				}
				
			});
			btnNewButton.setBackground(new Color(204, 204, 255));
			btnNewButton.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 12));
		}
		return btnNewButton;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTextArea());
			scrollPane.setColumnHeaderView(getLblNewLabel());
		}
		return scrollPane;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setBackground(new Color(255, 255, 255));
		}
		return textArea;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uD68C\uC6D0ID                \uBE44\uBC00\uBC88\uD638                  \uC774\uB984                   \uC5F0\uB77D\uCC98              ");
			lblNewLabel.setOpaque(true);
			lblNewLabel.setBackground(new Color(153, 153, 255));
		}
		return lblNewLabel;
	}
}
