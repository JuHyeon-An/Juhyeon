package a_begin;

public class PromotionExample {
	int a = 800; // 필드(멤버변수)로서 선언된 것
	int b = 100;
	int c = 80;
//	c=a+b; 연산식 -> 클래스의 구성요소에 연산식이 들어갈 수 없다. 구성요소가X.
//	액션이 취해지는 모든것은 메소드에서 처리한다
	
	// 생성자로 불려지는 메소드 (메소드명이 클래스명과 동일)
	// 개채를 생성할 수 있는 메소드
	// 왜 void 생략? : void를 쓰면 클래스명과 동일할지라도 생성자가 아님. 생성자에는 void 사용 X
	PromotionExample(){
		c=a+b;
		System.out.println(c);
	}
	
	// 일반메소드 : 누군가가 call해줘야 실행됨
	void PromotionExample1() {
		System.out.println(a);
	}
	
	public static void main(String[] args) {
		new PromotionExample(); // new 생성자이름() 하면 class 내 프로그램이 실행됨
		
	}
}

// 메소드 내 변수 메인에서 이름 같으면?
// int 앞에 static 붙으면?
