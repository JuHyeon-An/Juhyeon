package c_control;

public class WhileExam3 {

	public WhileExam3() throws Exception {
		boolean run = true;
		int speed = 0;
		int keycode = 0;

		while (run) {

			if (keycode != 13 && keycode != 10) {
				System.out.println("-------------------");
				System.out.println("1. ���� | 2. ���� | 3. ����");
				System.out.println("-------------------");
				System.out.print("���� : ");
			}
			keycode = System.in.read();

			if (keycode == 49) {
				speed++;
				System.out.println("\n����ӵ� : " + speed);
			} else if (keycode == 50) {
				speed--;
				System.out.println("\n����ӵ� : " + speed);
			} else if (keycode == 51) {
				run = false;
			}

		} // while ����
		System.out.println("���α׷� ����");
	}
	public static void main(String[] args) throws Exception {
		new WhileExam3();
	}
}
