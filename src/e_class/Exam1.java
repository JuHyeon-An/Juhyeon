/*
 예제1) 반환형 Exam1.java
1. 두 정수를 전달 받아 합계를 반환하는 메소드 구현 (Sum)
2. 두 정수(x, y) 를 전달받아 x~y까지의 합계를 구하여 리턴(sum2)
3. 가로, 세로값을 실수형으로 전달받아 사각형의 넓이를 계산하여 리턴
(sum3)
4. 구구단 수를 하나 전달받아 구구단을 하나의 문자열로 만들어 리턴
(gugudan)
 */

package e_class;

public class Exam1 {

	int x, y;
	double a,b;
	
	int sum(int x,int y) {
		this.x = x;
		this.y = y;
		
		return x+y;
	}
	
	int sum2(int x, int y) {
		int sum = 0;
		this.x = x;
		this.y = y;
		
		for (this.x = x; x <= y; x++) {
			sum += x;
		}
		return sum;
	}

	double sum3(double a, double b) {
		this.a = a;
		this.a = b;
		
		return (a*b);
	}
	
	void gugudan(int a) {
		for (int i = 1; i <= 9; i++) {
			System.out.println(a + "x" + i + "=" + (a * i));
		}
	}
	
	String gugudan2(int a) {
		String r = "";
		for (int i = 1; i <= 9; i++) {
			r += a + "x" + i + "=" + (a * i);
			r += "\n"; // 누적시켜서 출력하기
		}
		return r;
	}
	
	public static void main(String[] args) {
		Exam1 e1 = new Exam1();
		
		int r1 = e1.sum(-20,30);
		System.out.println("두 수의 합 : "+r1);
		
		int r2 = e1.sum2(2, 9);
		System.out.println("합계 : "+r2);
		System.out.println(e1.sum2(3, 5));
		System.out.println("사각형의 넓이 : "+e1.sum3(20, 30));
		System.out.println("void 타입으로 -----------");
		e1.gugudan(3);
		
		String r3 = e1.gugudan2(6);
		System.out.println("return 타입으로----------");
		System.out.println(r3);
			
		}
	
	}

