//1~1000 사이의 수 중 소수만을 구하여 출력하시오
//(1과 자신 이외의 자연수로 나누어 떨어지지 않는 자연수)

package c_control;

public class ForExam6 {
	ForExam6() {
		int n = 0;

		for (n = 1; n <= 1000; n++) {
			boolean b = true;
			for (int k = 2; k < n; k++) {
				if (n % k == 0) {
					b = false; // 나머지가 0이 나오면 소수가 아님 (false)
					break; // break 없어도 작동
				}
			}
			if (b) { // b가 참일때 = 소수일때만 출력해
				System.out.print(n + " ");
			}

		}
	}
}