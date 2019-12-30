package practice;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class StackFrame extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StackFrame frame = new StackFrame();
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
	public StackFrame() {
		super(null, true, true, true, true);
		setVisible(true);
		setBounds(100, 100, 450, 300);

	}

}
