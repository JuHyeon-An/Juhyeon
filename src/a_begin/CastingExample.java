package a_begin;

public class CastingExample {

	public CastingExample(){
		
		// int -> char
		int intValue = 44032;
		char charValue = (char)intValue;
		System.out.println(intValue +" to char type : " +charValue);
		
		// long -> int
		long longValue = 50000l; //long Ÿ���� �ڿ� "L" �ٿ��ֱ�
		intValue = (int)longValue;
		System.out.println(longValue+" to int type : "+intValue);
		
		// double -> int
		double doubleValue = 3.14;
		intValue = (int)doubleValue;
		System.out.println(doubleValue+" to int type : "+intValue);
		System.out.println("\n");
		System.out.println("-------------------");
		
		double d = 10/(double)3; // ������ ���� �Ǽ����� �Ǽ���
		System.out.println(d); // 10�� 3�� ������ �䵵 ���� -> ����� ��ȭ�� ����
		d = 10 / (3*1.0); // double Ÿ������ ĳ�����ѰͰ� �Ȱ���
		System.out.println(d);
		
		
		
		
		
		
		for(int i=0; i<30; i++) {
			System.out.print(i+1);
			System.out.print(charValue++);
			System.out.println("");
			}

		}
	
	
	
	public static void main(String[] args) {
		new CastingExample(); // �����ڸ� �θ��� : �����ڸ� ������ ��ü�� �����ؼ� �޸𸮿� �÷���

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
//		System.out.println(intValue); // ����
		
		
	}
}
