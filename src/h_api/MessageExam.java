package h_api;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MessageExam extends JInternalFrame {
	private JPanel panel;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MessageExam frame = new MessageExam();
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
	public MessageExam() {
		super("MessageFormat", false, true, true, true);
		setVisible(true);
		setBounds(100, 100, 450, 345);
		getContentPane().add(getPanel(), BorderLayout.NORTH);
		getContentPane().add(getScrollPane(), BorderLayout.CENTER);

	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(10, 25));
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getBtnNewButton(), BorderLayout.EAST);
		}
		return panel;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("DM \uBC1C\uC1A1");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy³â MM¿ù ddÀÏ");
					String now = sdf.format(new Date());
					String[][] data = new String[][] {
						{"11-111", "È«±æµ¿", "¹æ°¡¹æ°¡~~~~", "°í°´°ü¸®ÆÀ", now},
						{"22-222", "ÀÏÁö¸Å", "°ø°Ý ¾ÕÀ¸·Î", "Àü·«ÆÀ", now},
						{"33-333", "ÀÓ²©Á¤", "°ÆÁ¤Àº ±×¸¸", "È«º¸ÆÀ", now},
						{"44-444", "¼ºÃáÇâ", "²É±æ¸¸ °ÉÀ¸¼¼¿ä", "ÃÑ¹«ÆÀ", now}
					};
					
					String dm = "¿ìÆí¹øÈ£ : {0}\n°í°´¸í : {1}\n\n {2}\n\n ¹ß¼ÛÃ³ : {3} \n\n {4}";
					dm += "\n---------------------------------\n\n";
				
					StringBuilder sb = new StringBuilder();
					
					for(int i = 0; i<data.length; i++) {
						String temp = MessageFormat.format(dm, data[i]);
						sb.append(temp);
					}
					
					textArea.setText(sb.toString());
				}
			});
			btnNewButton.setFont(new Font("³ª´®½ºÄù¾î Bold", Font.PLAIN, 13));
		}
		return btnNewButton;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
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
