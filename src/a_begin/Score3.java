package a_begin;

public class Score3 {

	Score3(){
	
		int kor = 95;
		int eng = 90;		
		
		int total = kor+eng;
		double avg = (double)total/2;
	
		System.out.println("------------------------------");
		System.out.println("\t���� ó�� ���");
		System.out.println("------------------------------");
		System.out.println("�ۼ����� : 2019. 11. 27 (��)");
		System.out.println("�ۼ��� : ������");
		System.out.println("���� : "+kor);
		System.out.println("���� : "+eng);
		System.out.println("�հ� : "+total);
		System.out.println("��� : "+avg);
		}
	
	public static void main(String[] args) {
		new Score3();
	}
}
