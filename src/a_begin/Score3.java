package a_begin;

public class Score3 {

	Score3(){
	
		int kor = 95;
		int eng = 90;		
		
		int total = kor+eng;
		double avg = (double)total/2;
	
		System.out.println("------------------------------");
		System.out.println("\t성적 처리 결과");
		System.out.println("------------------------------");
		System.out.println("작성일자 : 2019. 11. 27 (수)");
		System.out.println("작성자 : 안주현");
		System.out.println("국어 : "+kor);
		System.out.println("영어 : "+eng);
		System.out.println("합계 : "+total);
		System.out.println("평균 : "+avg);
		}
	
	public static void main(String[] args) {
		new Score3();
	}
}
