/*
 * 작성일자 : 2019.11
 * 작성자 : ajh
 * 각종 연산자에 대한 샘플
 */
package b_operator;

public class Operator {
	Operator(){
		// 나머지 연산자
		System.out.println("12%5 => "+ (12%5));
		
		// 나머지 연산자와 3항 연산자
		int n = 122;
		
		String r = (n%2==0)? "짝수" : "홀수";
		System.out.println(n+" ==> "+r);
		
		// 증감 연산자
		// 전치/후치
		int a = 10;
		int b = 10;
		
		a++; // a = a+1
		++b;
		System.out.println(a+","+b);
		
		int c = a++;
		int d = ++b;
		
		System.out.println(c+","+d);
		System.out.println(a+","+b);
		
		String name = "안주";
		String irum = "안주";
		String irum2 = new String("안주"); // 메모리에 "안"이 있는지 없는지 검사 안 하고 무조건 새로 만듦
		
		System.out.println(name==irum);
		System.out.println(name==irum2);
				
		// 같은 문자열이지만 다른 주소를 참조하면 다른 문자열로 인식하게 된다.
		// ex) 둘다 "안" 이지만 참조하는 주소가 다름
		
		System.out.println(name.equals(irum2));
		System.out.println(name.equals(irum));
		
		
		
	}
	public static void main(String[] args) {
		new Operator();
	}
}
	