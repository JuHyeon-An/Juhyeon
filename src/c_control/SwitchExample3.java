package c_control;

public class SwitchExample3 {

	SwitchExample3() {

		char grade = 'A';

		switch (grade) {
		case 'A':
		case 'a':
			System.out.println("���ȸ���Դϴ�.");
			break;

		case 'B':
		case 'b':
			System.out.println("�Ϲ� ȸ���Դϴ�.");
			break;
			
		default:
			System.out.println("�մ��Դϴ�.");
			break;

		}
	}
}
