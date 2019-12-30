package c_control;

public class WhileExam3 {

	public WhileExam3() throws Exception {
		boolean run = true;
		int speed = 0;
		int keycode = 0;

		while (run) {

			if (keycode != 13 && keycode != 10) {
				System.out.println("-------------------");
				System.out.println("1. 증속 | 2. 감속 | 3. 중지");
				System.out.println("-------------------");
				System.out.print("선택 : ");
			}
			keycode = System.in.read();

			if (keycode == 49) {
				speed++;
				System.out.println("\n현재속도 : " + speed);
			} else if (keycode == 50) {
				speed--;
				System.out.println("\n현재속도 : " + speed);
			} else if (keycode == 51) {
				run = false;
			}

		} // while 종료
		System.out.println("프로그램 종료");
	}
	public static void main(String[] args) throws Exception {
		new WhileExam3();
	}
}
