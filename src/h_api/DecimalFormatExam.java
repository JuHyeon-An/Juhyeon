package h_api;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DecimalFormatExam extends JInternalFrame {
	private JLabel lblNewLabel;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton button;
	private JButton button_1;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DecimalFormatExam frame = new DecimalFormatExam();
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
	public DecimalFormatExam() {
		super("Decimal Format", true, true, true, true);
		
		setTitle("DecimalFormat");
		setBounds(100, 100, 450, 357);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getTextField());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getButton());
		getContentPane().add(getButton_1());
		getContentPane().add(getScrollPane());
		setVisible(true);

	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC785\uAE08\uC561");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 13));
			lblNewLabel.setBounds(12, 13, 57, 15);
		}
		return lblNewLabel;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(81, 9, 246, 21);
			textField.setColumns(10);
		}
		return textField;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uCC9C\uB2E8\uC704");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					long v = Long.parseLong(textField.getText()); // 소수점이라 long은 x
					
					DecimalFormat df = new DecimalFormat("00,000,000,000.00");
					String r = df.format(v);
					
					textArea.append(r+"\n");
				}
			});
			btnNewButton.setBackground(new Color(216, 191, 216));
			btnNewButton.setFont(new Font("배달의민족 주아", Font.PLAIN, 14));
			btnNewButton.setBounds(12, 47, 97, 23);
		}
		return btnNewButton;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("\uC18C\uC22B\uC810 \uD45C\uC2DC");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				double v = Double.parseDouble(textField.getText());
				DecimalFormat df = new DecimalFormat("#,###,###,###.##");
				
				textArea.append(df.format(v)+"\n");
				
				}
			});
			button.setFont(new Font("배달의민족 주아", Font.PLAIN, 14));
			button.setBackground(new Color(216, 191, 216));
			button.setBounds(121, 47, 97, 23);
		}
		return button;
	}
	private JButton getButton_1() {
		if (button_1 == null) {
			button_1 = new JButton("\uC6D0\uD654\uD45C\uC2DC");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
				double v = Double.parseDouble(textField.getText());
				DecimalFormat df = new DecimalFormat("\u00a4 #,###.##");
				
				textArea.append(df.format(v) + "\n");
				}
			});
			button_1.setFont(new Font("배달의민족 주아", Font.PLAIN, 14));
			button_1.setBackground(new Color(216, 191, 216));
			button_1.setBounds(230, 47, 97, 23);
		}
		return button_1;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 80, 410, 238);
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
