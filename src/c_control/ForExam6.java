//1~1000 ������ �� �� �Ҽ����� ���Ͽ� ����Ͻÿ�
//(1�� �ڽ� �̿��� �ڿ����� ������ �������� �ʴ� �ڿ���)

package c_control;

public class ForExam6 {
	ForExam6() {
		int n = 0;

		for (n = 1; n <= 1000; n++) {
			boolean b = true;
			for (int k = 2; k < n; k++) {
				if (n % k == 0) {
					b = false; // �������� 0�� ������ �Ҽ��� �ƴ� (false)
					break; // break ��� �۵�
				}
			}
			if (b) { // b�� ���϶� = �Ҽ��϶��� �����
				System.out.print(n + " ");
			}

		}
	}
}