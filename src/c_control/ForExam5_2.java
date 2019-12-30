//1~1000까지의 수중 5의 배수이거나 7의 배수만을 출력하시오.

package c_control;

public class ForExam5_2 {
	ForExam5_2() {
		int i = 0;

		for (i = 5; i <= 100; i = i + 5) {
			System.out.println(i);
		}
		for (int j = 7; j <= 100; j = j + 7) {
			System.out.println(j);
		}

	}

}
