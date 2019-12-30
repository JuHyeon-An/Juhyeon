package e_class;

public class Static {

	// 정적형(공용자원): 모든 객체가 하나의 값만 사용
	// 초기화는 1회만
	// 클래스명.멤버 또는 객체명.멤버 으로 모두 접근 가능 (Static.v1) (s1.v1)
	static int v1 = 5000; 
	int v2 = 5000; // 인스턴스형
	
	public static void main(String[] args) {
		Static s1 = new Static();
		s1.v1 = 1000;
		s1.v2 = 1000;
		
		System.out.println(s1.v2);
		
		Static s2 = new Static();
		System.out.println(s2.v1); //1000
		System.out.println(Static.v1);
		System.out.println(s2.v2); //5000 -> 다시 초기화.
	}

}
