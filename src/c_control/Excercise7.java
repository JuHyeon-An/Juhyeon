package c_control;

import java.util.Scanner;

public class Excercise7 {

	public Excercise7() throws Exception {
		boolean run = true;
		int balance = 0;
		Scanner scanner = new Scanner(System.in); // Scanner : Ŭ����
		// scanner : ������ ����

		while (run) {

			System.out.println("----------------------");
			System.out.println("1. ���� | 2. ��� | 3. �ܾ� | 4. ����");
			System.out.println("----------------------");
			System.out.print("���� > ");

			int input = 0;
			int key = scanner.nextInt(); // �� �Է�

			if (key == 1) {
				System.out.print("���ݾ� > ");
				input = scanner.nextInt();
				balance = balance + input;

			}
			if (key == 2) {
				System.out.print("��ݾ�>  ");
				input = scanner.nextInt();
				if (input > balance)
					System.out.println("�ܾ��� �����մϴ�.");
				else
					balance = balance - input;

			} else if (key == 3) {
				System.out.println("�ܾ�>  " + balance);

			} else if (key == 4) {
				run = false;
			}

		} // while ����
		System.out.print("���α׷� ����");
	}

	public static void main(String[] args) throws Exception {
		new Excercise7();
	}
}
