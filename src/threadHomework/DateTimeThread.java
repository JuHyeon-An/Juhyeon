package threadHomework;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.JTextField;

public class DateTimeThread extends Thread {
	
	JTextField txt = new JTextField();
	TimeWatch tw = new TimeWatch(txt);
	
	public void run() {
		
		while (true) {
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 (E) a hh시 mm분 ss초");
			txt.setText(sdf.format(now));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
}
