package a_begin;

public class First{
	public static void main (String[] args) {
				
		String name = "Juhyeon";
		String address = "경기도 고양시";
		String name1 = "hong";
		
		int a = 80;
		double b = 1000.0;
		
		System.out.println(a+b); // 실수 double
		
		
		System.out.println(name);
		System.out.println(address);
		
		int kor = 80;
		int eng = 90;
		
		kor = 10; // 변수 재선언
		kor = kor+10;
		

		
		System.out.println(kor);
		System.out.println(kor+eng);
		System.out.println(kor<eng); // less than "kor이 eng보다 작다"
		System.out.println(kor>eng);
		
	
	}	
}

