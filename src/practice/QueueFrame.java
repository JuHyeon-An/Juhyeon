package practice;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class QueueFrame extends JInternalFrame {

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public QueueFrame() {
		super(null, true, true, true, true);
		setVisible(true);
		setBounds(100, 100, 450, 300);

	}

}
