package threadhomeworkT;

import java.awt.BorderLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class StopWatchThread extends JPanel implements Runnable{ // JPanel�� ��ӹް� Runnable�� ������ JPanel
	private JLabel stopwatch;
	public boolean flag;
	
	public StopWatchThread() {
		setLayout(new BorderLayout(0, 0));
		add(getStopwatch(), BorderLayout.CENTER);
		
	}

	@Override
	public void run() {
		SimpleDateFormat sdf = new SimpleDateFormat("mm:ss:SS");
		long begin = new Date().getTime();
		while (!flag) {
			long end = new Date().getTime() - begin;
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}
			stopwatch.setText(sdf.format(end));
		}
	}
		
	private JLabel getStopwatch() {
		if (stopwatch == null) {
			stopwatch = new JLabel("START ��ư�� �����ּ���");
			stopwatch.setHorizontalAlignment(SwingConstants.CENTER);
			stopwatch.setFont(new Font("���������� Bold", Font.PLAIN, 30));
		}
		return stopwatch;
	}
}
