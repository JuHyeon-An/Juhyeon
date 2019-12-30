package e_class;

public class ArrayParam {

	ArrayParam(int[] s) { // ������ �迭�� �Ű������� ������ ����.
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
	}

	// 1 ���޹��� �迭���� �հ踦 ���Ͽ� ����
	int arraySum(int[] s) {
		int sum = 0;
		for (int i = 0; i < s.length; i++) {
			sum += s[i];
		}
		return sum;
	}

	// 2 ���޹��� �迭���� �ִ밪�� ���Ͽ� ����
	int arrayMax(int[] s) {
		int max = 0;
		for (int i = 0; i < s.length; i++) {
			if (max < s[i]) {
				max = s[i];
			}
		}
		return max;
	}

	// 3 ���޹��� �迭���� �ּҰ��� �����Ͽ� ��ȯ
	int arrayMin(int[] s) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < s.length; i++) {
			if (min > s[i]) {
				min = s[i];
			}
		}
		return min;
	}

	int[] maxMin(int[] s) {
		int[] m = new int[2];

		m[0] = s[0]; // max
		m[1] = s[0]; // min
		
		for (int i = 1; i < s.length; i++) {
			if (m[0] < s[i]) {
				m[0] = s[i];
			}else if (m[1] > s[i]) {
				m[1] = s[i];
			}
		}
//		max, min ������ ���� ������ �Ŀ�
//		m = new int[]{max, min} ���� �ص� �������

		return m; // �迭���� �迭 ��ü�� ��Ÿ����. (�迭 ��°�� ���޵ȴ�)
	}

	public static void main(String[] args) {
		int[] abc = { 100, 42, 64, 25, -1, 4, 35, 63, 23, 192 };
		ArrayParam ap1 = new ArrayParam(abc); // �Ű������� abcŸ�� = ������ �迭Ÿ��
		System.out.println("---------------------");
		int hap = ap1.arraySum(abc); // �迭 abc�� s�� ����.
		System.out.println("�հ� : "+hap);

		System.out.println("---------------------");
		int max = ap1.arrayMax(abc);
		System.out.println("�ִ밪 : " + max);

		System.out.println("---------------------");
		int min = ap1.arrayMin(abc);
		System.out.println("�ּҰ� : "+ min);

		System.out.println("---------------------");
		int mm[] = ap1.maxMin(abc); // int[] mm = new int[2]
		System.out.println("mm[0] �ִ밪 : " +mm[0]);
		System.out.println("mm[1] �ּҰ� : " +mm[1]);
//		int[] s = abc; �̷��� ���Ŷ� �Ȱ�����!
//		int[] s = {1,2,3,4,5}

	}

}
