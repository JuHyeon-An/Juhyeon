package c_control;

public class IfExample {
	public static void main(String[] args) {
//		new IfExample(); => �͸�ü (�޸� �ּҸ� �� �� ����)
		IfExample obj = new IfExample(); // ��ü�� �����ؼ� obj�� ��ƶ� => ������
//		obj : Ŭ������ �޸𸮿� �ö� ��ġ�� ����Ų��. (������Ʈ��, �ν��Ͻ���)
//		obj�� IfExample�� ��ġ�ϰ� �ִ� �������� ��� �ִ�.

		System.out.println("-------<type1 : �޼ҵ� ������ ���� if ��� (if)>--------");
		int k = obj.type1(); // => ��°�
		System.out.println(k); // => return���� ����

		System.out.println(obj.type1()); // => ��°� + return���� �Բ� �����
//		obj�� ������ �ִ� type1 �޼ҵ带 �����ϰ� �� ����� k�� �����ض�
//		���� k�� int�� ���� : "obj �ϴܿ��� return ����������; �� ���� ���̴�" ����

		System.out.println("-------<type2 : �޼ҵ� ���� ���ϰ��� �����ͼ� ��� (else)>--------");
		String m = obj.type2();
//		obj�� ������ �ִ� type2�� �����ϰ� String m�� �����ض�
		System.out.println(m);

		System.out.println("-------<type3 : �޼ҵ� �� ���ϰ� �����ͼ� ��� (else if)>--------");
		System.out.println(obj.type3()); // ���� ������ �ʰ� ���̷�Ʈ�� �ٷ� ����ϱ�
		char s = obj.type3();
		System.out.println(s + " �Դϴ�.");

		obj.type4();

	}

	int type1() {
		int r = 0;
		int s = 95;
		if (s >= 90) {
			System.out.println("������ 90������ Ů�ϴ�");
			System.out.println("����� A�Դϴ�.");
		}
		if (s < 90) {
			System.out.println("������ 90���� �۽��ϴ�.");
			System.out.println("����� B�Դϴ�.");
		}
		return s;

	}

	String type2() {
		String r = null; // r�� ����Ű�� �־�� �� �ּҰ� ����
		int s = 80;

		if (s >= 90) {
			r = "90�̻��Դϴ�";
			r += "\n����� A�Դϴ�"; // += �� �ϰ� = �� �ϸ� �տ� ������ ������ ( r = r + "\nA")
		} else {
			r = "90�̸��Դϴ�";
			r += "\n����� B�Դϴ�";
		}

		return r;
	}

	/*
	 * ������ if~else if�� ����Ͽ� ������ ���Ͽ� r�� �����Ͻÿ�. 90�̻� A, 80�̻� B, 70�̻� C , 60�̻� D, �̸� F
	 */
	char type3() {
		int s = 100;
		char r = ' '; // ���� ����ǥ�� �� ������ �ݵ�� ���ڰ� �ʿ���. (����)

		if (s >= 90) {
			r = 'A';
		} else if (s >= 80) {
			r = 'B';
//			return r; -> if���� ���Ϲ����� ������ �� �� ������ �����ؼ� �ѹ���
		} else if (s >= 70) {
			r = 'C';
			return r;
		} else if (s >= 60) {
			r = 'D';
			return r;
		} else
			r = 'F';
		return r;
	}

	/*
	 * ������ 0~100 �����϶��� 60 �̻��̸� '�հ�'60 �̸��̸� '���հ�'�� ����ϰ�, ������ ���� ���̸� '��������;�� ����Ͻÿ�.
	 * (��ø if�� ���) ������ ������ �������̸� (� ���� 5~10, ����� 0.0~5.0) �ּҰ��� �ִ밪�� ������ Double��
	 * ��Ƽ� ����� (���ͷ��� ���� ���߿� �����ϱ� �����)
	 */

	void type4() {
		int score = 70;
		double min = 0;
		double max = 100;

		String result = "";

		if (score >= min && score <= max) {
			if (score >= 60) {
				result = "�հ�";
			} else {
				result = "���հ�";
			}
		}

		else
			result = "��������";

		System.out.println(result);
	}

}
