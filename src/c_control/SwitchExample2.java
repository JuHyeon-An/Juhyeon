package c_control;

public class SwitchExample2 {

	SwitchExample2() {
		int time = (int) (Math.random() * 4) + 8;
		System.out.println("[����ð� : " + time + "��]");

		switch (time) {

		case 8:
			System.out.println("����մϴ�.");

		case 9:
			System.out.println("ȸ���մϴ�.");

		case 10:
			System.out.println("������ ���ϴ�.");

		default:
			System.out.println("�ܱ��մϴ�.");

		}

	}

}