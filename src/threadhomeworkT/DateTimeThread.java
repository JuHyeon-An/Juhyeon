package threadhomeworkT;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class DateTimeThread extends Thread {
	JTextField watch;
	
	public DateTimeThread(JTextField watch) {
		this.watch = watch;
	}
	
	public void run() {
		
		while (true) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� (E) a hh�� mm�� ss��");
			watch.setText(sdf.format(new Date()));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
}
