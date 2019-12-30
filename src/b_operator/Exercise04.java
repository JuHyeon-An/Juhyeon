/*
 * 정수형 계산하기, 나머지 계산하기
 */
package b_operator;

public class Exercise04 {
	int pencils = 764;
	int students = 30;
	int pencilsPerStudents;
	int pencilsLeft;
	
	Exercise04(){
	pencilsPerStudents = pencils/students;
	System.out.println("학생 1명당 연필의 개수 : "+pencilsPerStudents+"개");
	
	pencilsLeft = pencils%students;
	System.out.println("남은 연필의 개수 : "+pencilsLeft+"개");
	
	System.out.println("총 연필의 개수 : "+((students*pencilsPerStudents)+pencilsLeft)+"개");
	}
	public static void main (String[] args) {
		new Exercise04();
	}
}
