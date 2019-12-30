/*-------------------------------
 * 구구단 출력 (이중 for문 활용)
 * 작성자: ajh
 * 작성일자: 2019-12
 * ------------------------------*/
 
package c_control;

public class ForExam2 {
	ForExam2() {
		int m = 2;
		for (m = 2; m <= 99; m++) {
			System.out.println("--------------");
			System.out.println(m + "단 입니다.");
			System.out.println("--------------");
			for (int n = 1; n <= 9; n++) {
				System.out.println(m + " x " + n + " = " + (m * n));
			}
		}
	}

}
