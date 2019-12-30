package h_api;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class TokenAndSplit extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField str;
	private JLabel label;
	private JTextField deli;
	private JButton btnNewButton;
	private JButton btnSplit;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TokenAndSplit frame = new TokenAndSplit();
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
	public TokenAndSplit() {
		setTitle("token and split");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getStr());
		contentPane.add(getLabel());
		contentPane.add(getDeli());
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnSplit());
		contentPane.add(getScrollPane());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uBB38\uC790\uC5F4");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(12, 10, 57, 15);
		}
		return lblNewLabel;
	}
	private JTextField getStr() {
		if (str == null) {
			str = new JTextField();
			str.setText("apple,dog, cat, 145,24, 532, 52, happy, , and, bb,,, \uB9C8, \uB0E5, \uB2E8, \u3163\u3147, ,,,rabbit");
			str.setBounds(80, 7, 330, 21);
			str.setColumns(10);
		}
		return str;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uAD6C\uBD84\uC790");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setBounds(12, 41, 57, 15);
		}
		return label;
	}
	private JTextField getDeli() {
		if (deli == null) {
			deli = new JTextField();
			deli.setText(",");
			deli.setBounds(80, 38, 116, 21);
			deli.setColumns(10);
		}
		return deli;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Token");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String value = str.getText();
					String d = deli.getText(); // delimeter
					StringTokenizer st = new StringTokenizer(value, d);
					//ctrl + shift + o : 자동 import
					textArea.setText("");
					
					//1 (for문)
					int cnt = st.countTokens();
					for(int i = 0; i<cnt ; i++) {
						textArea.append(st.nextToken()+"\n");
					}
					
					//2 (while문)
					textArea.append("---------------------------\n");
					st = new StringTokenizer(value, d);
					while(st.hasMoreTokens()) { // 꺼낼 토큰이 더 남아있으면 루핑
						textArea.append(st.nextToken()+"\n");
					}
				}
			});
			btnNewButton.setBounds(204, 38, 97, 23);
		}
		return btnNewButton;
	}
	private JButton getBtnSplit() {
		if (btnSplit == null) {
			btnSplit = new JButton("Split");
			btnSplit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String[] values = str.getText().split(deli.getText());
					String r = "Split____________________\n";
					for(int i = 0; i<values.length; i++) {
						r += String.format("values[%d]=%s\n", i, values[i]);
					}
					r+= "-----------------------------\n";
					r+= Arrays.toString(values)+"\n";
					r+= "-----------------------------\n";
					textArea.setText(r);
					
				}
			});
			btnSplit.setBounds(313, 38, 97, 23);
		}
		return btnSplit;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(22, 66, 389, 186);
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
}
