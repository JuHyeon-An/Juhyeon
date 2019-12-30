package h_api2_StudentApp;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class Main extends JPanel {
	private JLabel lblNewLabel;

	public Main() {
		setLayout(new BorderLayout(0, 0));
		add(getLblNewLabel(), BorderLayout.CENTER);

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setOpaque(true);
			lblNewLabel.setBackground(new Color(250, 240, 230));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\JHTA\\Downloads\\school (2).png"));
		}
		return lblNewLabel;
	}
}
