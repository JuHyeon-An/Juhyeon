// While���� Math.random() �޼ҵ带 �̿��ؼ� �� ���� �ֻ����� ������ �� ������ �� x, y ���� 5�� �ƴϸ� ��� �ֻ��� ������ 5�� ������ ���߱�
 
package c_control;

public class Exercise4 {

	public Exercise4() {

		while (true) {
			int x = (int) (Math.random() * 6) + 1; // �����߻�
			int y = (int) (Math.random() * 6) + 1;
			System.out.printf("(%2d,%2d)\n", x, y);
			
			if (x + y == 5) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		new Exercise4();
	}
}
