// for���� �̿��ؼ� 1���� 100������ ���� �߿��� 3�� ����� ������ ���ϴ� �ڵ带 �ۼ��Ͻÿ�

package c_control;

public class Exercise03 {

	public Exercise03() {
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0) {
				sum += i;
			}
		}
		System.out.println("3�� ����� �� : "+sum);
	}

	public static void main(String[] args) {
		new Exercise03();
	}
}
