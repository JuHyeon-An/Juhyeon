package a_begin;

public class Score2 {
	public static void main(String[] args) {
		
		String name = "홍길동";
		float score = 100.0f; // float타입은 뒤에 "f"붙여주기
		char result = 'A'; // 하나의 문자 -> char 타입, 작은 따옴표
		int a = 30;
		
		System.out.println(result++); //char
		result += 2; // result에 2를 더한 후 다시 result에 대입한다		
		System.out.println(result+1); // 숫자형
		
		System.out.println("이름 : "+name);
		System.out.println("점수 : "+score);
		System.out.println("학점 : "+result);

	}
	
}
