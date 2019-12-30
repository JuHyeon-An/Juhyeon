package practice;

public class LogicOp {
	public static void main(String[] args) {
		int num1 = 10, num2 = 20;
		boolean result1 = num1==10 && num2 == 20;
		boolean result2 = num1<=12 || num2>=30;
		boolean result3 = num1 == num2;
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		
		boolean result4 = 1<1;
		
		int a = 10, b = 20, c = 30;
		a = b = c;
		System.out.println(a); // 30
		System.out.println(b); // 30
		System.out.println(c); // 30
		
		System.out.println(((25*5)+(36-4)-72)/5);
		
		int A = ((25+5)+(36/4)-72)*5;
		int B = ((25*5)+(36-4)+72)*4;
		int C = (128/4)*2;
		
		System.out.println("A :" +A);
		System.out.println("B :"+B);
		System.out.println("C :"+C);
		
		if(A>B && B>C) {
			System.out.println("true");
		}else
			System.out.println("false");
		
		boolean isBig = A>B && B>C;
		System.out.println(isBig);
		
		
		
		
	}
}
