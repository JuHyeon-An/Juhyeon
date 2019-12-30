package c_control;

import java.util.Scanner;

public class DoWhileExam {
	DoWhileExam() {
		System.out.println("메시지를 입력하세요.");
		System.out.println("프로그램을 종료하려면 q를 입력하세요.");

		Scanner scanner = new Scanner(System.in);
		String inputString;

		do {
			System.out.print(">");
			inputString = scanner.nextLine(); // scanner를 통해서 넘겨받은
			
			System.out.println(inputString);
		} while (!inputString.equals("q")); // inputString의 문자열이 q가 아니면 계속 실행하라

		System.out.println();
		System.out.println("프로그램 종료");

	}
}
