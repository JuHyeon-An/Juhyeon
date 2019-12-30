package h_api;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateExam {

	
	
	public static void main(String[] args) {
	Date now = new Date(); // java.util.Date
	System.out.println(now);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) hh:mm:ss"); // E : 요일
	System.out.println(sdf.format(now));
	
	Calendar cal = Calendar.getInstance(); // 객체생성불가 -> getInstance() 사용
	System.out.println(cal.get(Calendar.MONTH)+1); // 내가 생성한 calendar 로부터 가져와라 (Calendar의 MONTH를)
	
	}
	
}
