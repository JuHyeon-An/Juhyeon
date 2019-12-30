package threadHomework;

import java.awt.BorderLayout;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class StopWatchThread extends JPanel implements Runnable{
	static JLabel stopwatch;
	public boolean flag;
	
	public StopWatchThread() {
		setLayout(new BorderLayout(0, 0));
		add(getStopwatch(), BorderLayout.CENTER);
	}

	@Override
	public void run() {
		int i = 0;
		while (!flag) {
			i ++;
			SimpleDateFormat sdf = new SimpleDateFormat("mm:ss:SS");
			stopwatch.setText(sdf.format(i));
			try {Thread.sleep(1);} catch (InterruptedException e) {}
			}
		}
		
	private JLabel getStopwatch() {
		if (stopwatch == null) {
			stopwatch = new JLabel("START 버튼을 눌러주세요");
			stopwatch.setHorizontalAlignment(SwingConstants.CENTER);
			stopwatch.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 30));
		}
		return stopwatch;
	}
}
