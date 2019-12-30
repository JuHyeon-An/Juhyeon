package i_thread;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.SwingConstants;

public class StopWatchThread extends JPanel implements Runnable{
	static JLabel stopwatch;
	public boolean stop = false;
	public boolean work = true;
	
	public StopWatchThread() {
		setLayout(new BorderLayout(0, 0));
		add(getStopwatch(), BorderLayout.CENTER);
	}

	@Override
	public void run() {
		int i = 0;
		while (!stop) {
			i++;
			stopwatch.setText(i + "ÃÊ");
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}
		}

	}
	private JLabel getStopwatch() {
		if (stopwatch == null) {
			stopwatch = new JLabel();
			stopwatch.setHorizontalAlignment(SwingConstants.CENTER);
			stopwatch.setFont(new Font("³ª´®½ºÄù¾î Bold", Font.PLAIN, 46));
		}
		return stopwatch;
	}
}
