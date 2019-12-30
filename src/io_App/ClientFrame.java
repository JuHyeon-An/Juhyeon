package io_App;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.net.InetAddress;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class ClientFrame extends JFrame {

	private JPanel contentPane;
	private JLabel label;
	private JTextField textField;
	private JLabel label_1;
	private JTextField textField_1;
	private JButton button;
	private JButton button_1;
	private JScrollPane scrollPane_1;
	private JButton button_2;
	private JComboBox comboBox;
	private JTextField textField_2;
	private JButton button_4;
	private JLabel label_2;
	private JTextField txtJuhyoen;
	private JLabel label_3;
	private JTextField textField_4;
	private JTextPane textPane;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_1;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientFrame frame = new ClientFrame();
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
	public ClientFrame() {
		setTitle("\uCC44\uD305 \uD074\uB77C\uC774\uC5B8\uD2B8");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLabel());
		contentPane.add(getTextField());
		contentPane.add(getLabel_1());
		contentPane.add(getTextField_1());
		contentPane.add(getButton());
		contentPane.add(getButton_1());
		contentPane.add(getScrollPane_1());
		contentPane.add(getButton_2());
		contentPane.add(getComboBox());
		contentPane.add(getTextField_2());
		contentPane.add(getButton_4());
		contentPane.add(getLabel_2());
		contentPane.add(getTxtJuhyoen());
		contentPane.add(getLabel_3());
		contentPane.add(getTextField_4());
		contentPane.add(getScrollPane());
	}

	public JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uC11C\uBC84");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå Regular", Font.PLAIN, 13));
			label.setBounds(12, 14, 46, 15);
		}
		return label;
	}
	public JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå Regular", Font.PLAIN, 13));
			textField.setColumns(10);
			textField.setBounds(58, 10, 137, 21);
			
			try {
				InetAddress local = InetAddress.getLocalHost();
				textField.setText(local.getHostAddress());
			}catch(Exception ex){
				
			}
			
		}
		return textField;
	}
	public JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("PORT");
			label_1.setHorizontalAlignment(SwingConstants.CENTER);
			label_1.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå Regular", Font.PLAIN, 13));
			label_1.setBounds(207, 14, 41, 15);
		}
		return label_1;
	}
	public JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setText("4444");
			textField_1.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå Regular", Font.PLAIN, 13));
			textField_1.setColumns(10);
			textField_1.setBounds(250, 10, 113, 21);
		}
		return textField_1;
	}
	public JButton getButton() {
		if (button == null) {
			button = new JButton("\uC811\uC18D");
			button.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå Regular", Font.PLAIN, 13));
			button.setBounds(375, 10, 78, 46);
		}
		return button;
	}
	public JButton getButton_1() {
		if (button_1 == null) {
			button_1 = new JButton("\uC885\uB8CC");
			button_1.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå Regular", Font.PLAIN, 13));
			button_1.setBounds(464, 10, 78, 46);
		}
		return button_1;
	}
	public JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(209, 84, 422, 340);
			scrollPane_1.setViewportView(getTextPane());
			scrollPane_1.setColumnHeaderView(getLblNewLabel());
		}
		return scrollPane_1;
	}
	public JButton getButton_2() {
		if (button_2 == null) {
			button_2 = new JButton("\uD574\uC81C");
			button_2.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå Regular", Font.PLAIN, 13));
			button_2.setBounds(12, 395, 183, 29);
		}
		return button_2;
	}
	public JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå Regular", Font.PLAIN, 13));
			comboBox.setBounds(12, 434, 185, 23);
			
			comboBox.addItem("ÀüÃ¼");
			comboBox.addItem("±Ó¼Ó¸»");
		}
		return comboBox;
	}
	public JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå Regular", Font.PLAIN, 13));
			textField_2.setColumns(10);
			textField_2.setBounds(209, 435, 332, 21);
		}
		return textField_2;
	}
	public JButton getButton_4() {
		if (button_4 == null) {
			button_4 = new JButton("\uC804\uC1A1");
			button_4.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå Regular", Font.PLAIN, 13));
			button_4.setBounds(545, 434, 86, 23);
		}
		return button_4;
	}
	public JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("\uC544\uC774\uB514");
			label_2.setHorizontalAlignment(SwingConstants.CENTER);
			label_2.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå Regular", Font.PLAIN, 13));
			label_2.setBounds(12, 45, 46, 15);
		}
		return label_2;
	}
	public JTextField getTxtJuhyoen() {
		if (txtJuhyoen == null) {
			txtJuhyoen = new JTextField();
			txtJuhyoen.setText("Juhyeon");
			txtJuhyoen.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå Regular", Font.PLAIN, 13));
			txtJuhyoen.setColumns(10);
			txtJuhyoen.setBounds(58, 41, 137, 21);
		}
		return txtJuhyoen;
	}
	public JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("\uC554\uD638");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå Regular", Font.PLAIN, 13));
			label_3.setBounds(207, 44, 41, 15);
		}
		return label_3;
	}
	public JTextField getTextField_4() {
		if (textField_4 == null) {
			textField_4 = new JTextField();
			textField_4.setText("1234");
			textField_4.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå Regular", Font.PLAIN, 13));
			textField_4.setColumns(10);
			textField_4.setBounds(250, 41, 113, 21);
		}
		return textField_4;
	}
	public JTextPane getTextPane() {
		if (textPane == null) {
			textPane = new JTextPane();
		}
		return textPane;
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uBA54\uC2DC\uC9C0");
			lblNewLabel.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå Regular", Font.PLAIN, 13));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 84, 185, 304);
			scrollPane.setColumnHeaderView(getLblNewLabel_1());
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC811\uC18D\uC790");
			lblNewLabel_1.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå Regular", Font.PLAIN, 13));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_1;
	}
	public JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
}
