package c_control;

public class SwitchToIf {

	SwitchToIf() {

		int score = 88;
		char grade = ' ';
		switch (score / 10) 
//		90~99 를 9로 만드는 방법 : 10으로 나누기
		{
		case 10:
		case 9:
			grade = 'A';
			break;
		case 8:
			grade = 'B';
			break;
		case 7:
			grade = 'C';
			break;
		case 6:
			grade = 'D';
			break;
		default:
			grade = 'F';

		}
		System.out.println("성적 : "+score);
		System.out.println("학점 : "+grade);
	}
}
