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
		
		// ������ ���� �� �ϳ��� 40�̸��� ������ '���հ�' (0~39 : ���հ�)
		// ����� 60 �̸��̾ '���հ�'
		
		result = (score==true)? "�հ�" : "���հ�";

		System.out.println("------------------------------");
		System.out.println("\t�հ� ���� ����");
		System.out.println("------------------------------");
		System.out.println("���� : "+kor);
		System.out.println("���� : "+eng);
		System.out.println("���� : "+mat);
		System.out.println("���� : "+total);
		System.out.println("��� : "+avg);
		System.out.println("��� : "+result);
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
