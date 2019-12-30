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
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� (E) a hh�� mm�� ss��");
			txt.setText(sdf.format(now));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
}
