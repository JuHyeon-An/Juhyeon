package a_begin;

public class Score {
	public static void main(String[] args) {
		int kor = 90;
		int eng = 90;
		int total = kor+eng;
		
//		int kor = 90, eng = 90;
		
		/*
		 * kor = 국어성적, eng = 영어성적
		 * total = 성적의 합계
		 */
		
		
		System.out.println("국어 : "+kor+"\n"+"영어 : "+eng+"\n"+"합계 : "+(kor+eng));
		
		System.out.println("------------------------");
		
		System.out.println("국어 : "+kor);
		System.out.println("영어 : "+eng);
		System.out.println("합계 : "+total); // 제 3의 변수
	}
}
