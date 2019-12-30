package practice;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class TreeMapFrame extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TreeMapFrame frame = new TreeMapFrame();
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
	public TreeMapFrame() {
		super();
		setVisible(true);
		setBounds(100, 100, 450, 300);

	}

}
