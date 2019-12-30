package MemberAndProductApp;

import java.awt.EventQueue;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class QueueFrame extends JInternalFrame {
	
	Queue<Message> queue = new LinkedList<Message>();
	
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JLabel lblNewLabel;
	private JComboBox comboBox;
	private JLabel lblNewLabel_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueueFrame frame = new QueueFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public QueueFrame() {
		super("Queue", false, true, true, true);
		setVisible(true);
		setBounds(100, 100, 450, 359);
		getContentPane().setLayout(null);
		getContentPane().add(getTextField());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getScrollPane());
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getComboBox());
		getContentPane().add(getLblNewLabel_1());

	}

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(106, 41, 116, 21);
			textField.setColumns(10);
		}
		return textField;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("OFFER");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					String combo = (String)comboBox.getSelectedItem();
//					SelectedItem : 콤보박스에 표시된 텍스트 반환
					String to = textField.getText();
					
					queue.offer(new Message(combo, to));
					JOptionPane.showMessageDialog(null, "입력이 완료되었습니다");
				}
			});
			btnNewButton.setBounds(234, 9, 97, 23);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("POLL");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					while (!queue.isEmpty()) {

						Message message = queue.poll();
						textArea.append(message.to + "님에게 ");
						switch (message.command) {
						case "Mail":
							textArea.append("메일을 보냅니다.");
							break;

						case "SMS":
							textArea.append("문자를 보냅니다.");
							break;
							
						case "KakaoTalk":
							textArea.append("카카오톡을 보냅니다.");
							break;
						}
						textArea.append("\n");
					}
					
				}
			});
			btnNewButton_1.setBounds(234, 40, 97, 23);
		}
		return btnNewButton_1;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 72, 410, 248);
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
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Command");
			lblNewLabel.setBounds(12, 13, 82, 15);
		}
		return lblNewLabel;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(106, 10, 116, 21);
			
			comboBox.addItem("Mail");
			comboBox.addItem("SMS");
			comboBox.addItem("KakaoTalk");
			
		}
		return comboBox;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("To");
			lblNewLabel_1.setBounds(12, 44, 57, 15);
		}
		return lblNewLabel_1;
	}
}
