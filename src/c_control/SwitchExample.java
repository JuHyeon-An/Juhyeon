package c_control;

public class SwitchExample {
	SwitchExample() {
		String a = "";
		int num = 0;
		for (int i = 0; i < 500; i++) {

			num = (int) (Math.random() * 8) + 1;

			if (num < 1 || num > 6) {
				a = "��ȣ�� ������ �߻��߽��ϴ�.";
				System.out.println(a);
				System.exit(0);
				// ���α׷��� ������ �����Ű�� ���
//				0�� ���� �������� ��� (1 �̿��� ���ڴ� �ش��ȣ�� ������ �߻��ߴ�)
			}

			switch (num) {
			case 1:
				a = "�ֻ��� 1���� ���Խ��ϴ�";
				break;
			case 2:
				a = "2�� �Դϴ�.";
				break;
			case 3:
				a = "3�� �Դϴ�.";
				break;
			case 4:
				a = "4�� �Դϴ�.";
				break;
			case 5:
				a = "5�� �Դϴ�.";
				break;
			default:
				a = "6�� �Դϴ�.";
				break;

			}// Switch ��
			System.out.println(a);
			//a��� ������ ���ϰ� �� �������� ��µ� ����� ��Ƽ� �ѹ��� ����ϱ�
		} // for ��
	}

	public static void main(String[] args) {
		new SwitchExample();
	}
}
