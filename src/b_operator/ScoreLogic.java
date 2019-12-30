package b_operator;

public class ScoreLogic {
	
	int kor = 50, eng = 30, mat = 100;
	int total = 0;
	double avg = 0.0;
	boolean score;
	String result = null;
	

	ScoreLogic(){
		total = kor+eng+mat;
		avg = total/(double)3;
		
		score = (kor>=40)&&(eng>=40)&&(mat>=40)&&(avg>=60);
		
		// 세개의 점수 중 하나라도 40미만이 있으면 '불합격' (0~39 : 불합격)
		// 평균이 60 미만이어도 '불합격'
		
		result = (score==true)? "합격" : "불합격";

		System.out.println("------------------------------");
		System.out.println("\t합격 여부 통지");
		System.out.println("------------------------------");
		System.out.println("국어 : "+kor);
		System.out.println("영어 : "+eng);
		System.out.println("수학 : "+mat);
		System.out.println("총점 : "+total);
		System.out.println("평균 : "+avg);
		System.out.println("결과 : "+result);
	}
	public static void main(String[] args) {	
		new ScoreLogic();
		
		int a = 10;
		int b = 20;
		
		int c = 0;
		c -= a;
		c = c-a;
	
		c += a;
		c = c+a;
		c = c+a;
		c = c+a;
		
		System.out.println(c);
		
		int score2 = 95;
		char grade = (score2>90)? 'A' : ((score2>80)? 'B' : 'C');
		System.out.println(grade);
	}
}
