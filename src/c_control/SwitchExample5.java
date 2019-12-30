package c_control;

public class SwitchExample5 {

	SwitchExample5() {

		int score = 89;
		char grade = ' ';
		
		if(score>=90) {
			grade = 'A';
		}else if(score>=80) {
			grade = 'B';
		}else if(score>=70) {
			grade = 'C';
		}else if(score>=60) {
			grade = 'D';
		}else grade = 'F';
		
		System.out.println("성적 : "+score);
		System.out.println("학점 : "+grade);
	}
}
