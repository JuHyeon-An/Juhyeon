/*
 * ������ ����ϱ�, ������ ����ϱ�
 */
package b_operator;

public class Exercise04 {
	int pencils = 764;
	int students = 30;
	int pencilsPerStudents;
	int pencilsLeft;
	
	Exercise04(){
	pencilsPerStudents = pencils/students;
	System.out.println("�л� 1��� ������ ���� : "+pencilsPerStudents+"��");
	
	pencilsLeft = pencils%students;
	System.out.println("���� ������ ���� : "+pencilsLeft+"��");
	
	System.out.println("�� ������ ���� : "+((students*pencilsPerStudents)+pencilsLeft)+"��");
	}
	public static void main (String[] args) {
		new Exercise04();
	}
}
