package i_thread;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class TimeWatch extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private static JTextField textField;
	private JLabel label;
	private JPanel panel;
	private JButton btnNewButton;
	private JButton btnSto;
	static StopWatchThread st = new StopWatchThread();
	static Thread tr = new Thread(st);
	boolean stop = false;
	
	
	public TimeWatch(JTextField txt){
		this.textField = txt;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimeWatch frame = new TimeWatch();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		DateTimeThread dt = new DateTimeThread();
		dt.start();
		
		
	}

	public TimeWatch() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getTextField());
		contentPane.add(getLabel());
		contentPane.add(getPanel());
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnSto());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC2DC\uACC4");
			lblNewLabel.setFont(new Font("배달의민족 도현", Font.PLAIN, 20));
			lblNewLabel.setBounds(12, 10, 68, 22);
		}
		return lblNewLabel;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

				
				}
			});
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setText("2019-12-18(\uC218) 17:08:01");
			textField.setBackground(new Color(240, 255, 240));
			textField.setFont(new Font("나눔스퀘어라운드 Regular", Font.BOLD, 20));
			textField.setBounds(22, 42, 410, 63);
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uC2A4\uD1B1\uC6CC\uCE58");
			label.setFont(new Font("배달의민족 도현", Font.PLAIN, 17));
			label.setBounds(12, 108, 110, 31);
		}
		return label;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new StopWatchThread();
			panel.setBackground(new Color(245, 255, 250));
			panel.setBounds(12, 135, 410, 79);
		}
		return panel;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("START");
			btnNewButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					if(!stop)
					{tr.start();}
					
					
				}
			});
			btnNewButton.setBackground(new Color(143, 188, 143));
			btnNewButton.setFont(new Font("배달의민족 주아", Font.PLAIN, 14));
			btnNewButton.setBounds(65, 224, 97, 23);
		}
		return btnNewButton;
	}
	private JButton getBtnSto() {
		if (btnSto == null) {
			btnSto = new JButton("STOP");
			btnSto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					StopWatchThread s1 = new StopWatchThread();
					s1.stop = true;
				}
			});
			btnSto.setBackground(new Color(143, 188, 143));
			btnSto.setFont(new Font("배달의민족 주아", Font.PLAIN, 14));
			btnSto.setBounds(176, 224, 97, 23);
		}
		return btnSto;
	}
}
