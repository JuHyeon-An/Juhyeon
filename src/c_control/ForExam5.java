//1~1000까지의 수중 5의 배수이거나 7의 배수만을 출력하시오.

package c_control;

public class ForExam5 {
	ForExam5() {
		int i = 0;
		
			for (i=1; i <= 1000; i++) {
				if (i % 5 == 0 || i % 7 == 0) {
				System.out.println(i);}
			}
	}
}
