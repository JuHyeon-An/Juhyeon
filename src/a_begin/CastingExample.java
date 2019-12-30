package a_begin;

public class CastingExample {

	public CastingExample(){
		
		// int -> char
		int intValue = 44032;
		char charValue = (char)intValue;
		System.out.println(intValue +" to char type : " +charValue);
		
		// long -> int
		long longValue = 50000l; //long 타입은 뒤에 "L" 붙여주기
		intValue = (int)longValue;
		System.out.println(longValue+" to int type : "+intValue);
		
		// double -> int
		double doubleValue = 3.14;
		intValue = (int)doubleValue;
		System.out.println(doubleValue+" to int type : "+intValue);
		System.out.println("\n");
		System.out.println("-------------------");
		
		double d = 10/(double)3; // 정수형 연산 실수형은 실수형
		System.out.println(d); // 10과 3이 정수라서 답도 정수 -> 더블로 변화된 형태
		d = 10 / (3*1.0); // double 타입으로 캐스팅한것과 똑같다
		System.out.println(d);
		
		
		
		
		
		
		for(int i=0; i<30; i++) {
			System.out.print(i+1);
			System.out.print(charValue++);
			System.out.println("");
			}

		}
	
	
	
	public static void main(String[] args) {
		new CastingExample(); // 생성자를 부른다 : 생성자를 가지고 개체를 생성해서 메모리에 올려라

//		int intValue = 44032;
//		char charValue = (char)intValue;
//		System.out.println(charValue);
//		
//		long longValue = 500;
//		intValue = (int)longValue;
//		System.out.println(intValue);
//		
//		double doubleValue = 3.14;
//		intValue = (int)doubleValue;
//		System.out.println(intValue); // 절삭
		
		
	}
}
