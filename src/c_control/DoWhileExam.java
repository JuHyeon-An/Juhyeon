package c_control;

import java.util.Scanner;

public class DoWhileExam {
	DoWhileExam() {
		System.out.println("�޽����� �Է��ϼ���.");
		System.out.println("���α׷��� �����Ϸ��� q�� �Է��ϼ���.");

		Scanner scanner = new Scanner(System.in);
		String inputString;

		do {
			System.out.print(">");
			inputString = scanner.nextLine(); // scanner�� ���ؼ� �Ѱܹ���
			
			System.out.println(inputString);
		} while (!inputString.equals("q")); // inputString�� ���ڿ��� q�� �ƴϸ� ��� �����϶�

		System.out.println();
		System.out.println("���α׷� ����");

	}
}
