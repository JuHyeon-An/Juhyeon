package d_array;

public class Exam8_2 {

	int[][] array = new int[5][5];
	int sum = 0;
	int max = array[0][0];
	int min = 200;
	int rowMax = 0;

	Exam8_2(int[][] array) {
		// ������ 2�����迭�� 5�� 5���� ����� 100~200 ������ ������ �������� Math.random()�� ����Ͽ� ����
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {

				// 1) �迭 ��ü ��� (5�� 5��)
				System.out.print(array[i][j] + "  ");

				// 2) ��ü ������ �հ�
				sum += array[i][j];

				// 3) ��ü �ִ밪
				if (array[i][j] > max) {
					max = array[i][j];
				}

				// 4) ��ü �ּҰ�
				if (array[i][j] < min) {
					min = array[i][j];
				}

			}
			System.out.println();
		}

		System.out.println("----------------");
		System.out.println("�հ� : " + sum);
		System.out.println("----------------");
		System.out.println("��ü �ִ밪 : " + max);
		System.out.println("��ü �ּҰ� : " + min);
		System.out.println();

		// 5) �� ���� �ִ밪

		for (int j = 0; j < array.length; j++) {
			rowMax = 0;
			for (int i = 0; i < array[0].length; i++) {
				if (array[j][i] > rowMax)
					rowMax = array[j][i];
			}
			System.out.println((j + 1) + "�� �ִ밪 : " + rowMax);
		}
	}

	int getSum(int[][] array) {
		this.max = max;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (max < array[i][j]) {
					max = array[i][j];
				}
			}
		}
		return max;
	}

	int getMax(int array[]) {
		return 0;
	}

	public static void main(String[] args) {
		int[][] array = new int[5][5];

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = (int) (Math.random() * 101) + 100;
			}
			Exam8_2 a1 = new Exam8_2(array);
			a1.getSum(a1.array);

		}

	}
}
