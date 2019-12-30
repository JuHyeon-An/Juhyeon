package c_control;

public class SwitchExample {
	SwitchExample() {
		String a = "";
		int num = 0;
		for (int i = 0; i < 500; i++) {

			num = (int) (Math.random() * 8) + 1;

			if (num < 1 || num > 6) {
				a = "번호에 오류가 발생했습니다.";
				System.out.println(a);
				System.exit(0);
				// 프로그램을 강제로 종료시키는 명령
//				0의 값은 전통적인 방법 (1 이외의 숫자는 해당번호의 오류가 발생했다)
			}

			switch (num) {
			case 1:
				a = "주사위 1번이 나왔습니다";
				break;
			case 2:
				a = "2번 입니다.";
				break;
			case 3:
				a = "3번 입니다.";
				break;
			case 4:
				a = "4번 입니다.";
				break;
			case 5:
				a = "5번 입니다.";
				break;
			default:
				a = "6번 입니다.";
				break;

			}// Switch 끝
			System.out.println(a);
			//a라는 변수를 정하고 맨 마지막에 출력된 결과를 모아서 한번만 출력하기
		} // for 끝
	}

	public static void main(String[] args) {
		new SwitchExample();
	}
}
