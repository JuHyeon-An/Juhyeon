package h_api;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateExam {

	
	
	public static void main(String[] args) {
	Date now = new Date(); // java.util.Date
	System.out.println(now);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) hh:mm:ss"); // E : ����
	System.out.println(sdf.format(now));
	
	Calendar cal = Calendar.getInstance(); // ��ü�����Ұ� -> getInstance() ���
	System.out.println(cal.get(Calendar.MONTH)+1); // ���� ������ calendar �κ��� �����Ͷ� (Calendar�� MONTH��)
	
	}
	
}
