package c_control;

import java.util.Scanner;

public class Excercise7_Switch��Ǯ�� {

	public Excercise7_Switch��Ǯ��() throws Exception {
		boolean run = true;
		int balance = 0;
		int input = 0;
		Scanner scanner = new Scanner(System.in);
		// Scanner : Ŭ����
		// scanner : ������ ����

		while (run) {

			System.out.println("\n--------------------------------");
			System.out.println("1. ���� | 2. ��� | 3. �ܾ� | 4. ����");
			System.out.println("--------------------------------");
			System.out.print("���� > ");

			int key = scanner.nextInt(); // �� �Է�

			switch (key) {
			case 1:
				System.out.print("���ݾ� > ");
				input = scanner.nextInt();
				balance = balance + input; // balance += v;
				break;
			
			case 2 :
				System.out.print("��ݾ�>  ");
				input = scanner.nextInt();
				if (input > balance)
					System.out.println("�ܾ��� �����մϴ�.");
				else
					balance = balance - input; // balance -= v;
				break;
			case 3 :
				System.out.println("�ܾ�>  " + balance);
				break;
				
			default :
				run = false;
			}

		} // while ����
		System.out.print("���α׷� ����");
	}

	public static void main(String[] args) throws Exception {
		new Excercise7_Switch��Ǯ��();
	}
}
