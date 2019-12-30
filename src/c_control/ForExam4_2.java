// 1~1000의 합계가 5000이 넘는 순간의 수를 출력하시오.
// (if ~ break 사용, 출력값을 어디에 하느냐에 따라서 달라지는 결과값)
// 아래와 같은 식으로 할 경우에는 i-1을 해서 i++되는 것을 보완해준다

package c_control;

public class ForExam4_2 {
	ForExam4_2() {
		int i = 0;
		int sum = 0; // sum을 for문 블록 안에서 선언하면 누적되지 않는다. (선언은 밖에서, 사용은 안에서)

		for (i = 1; i<=1000; i++) {
			sum += i;
			if(sum>=5000)
				break;
		}
		System.out.println(i + " , " + sum);
	}

}
