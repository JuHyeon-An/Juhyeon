package c_control;

import java.util.Scanner;

public class Excercise7_Switch로풀이 {

	public Excercise7_Switch로풀이() throws Exception {
		boolean run = true;
		int balance = 0;
		int input = 0;
		Scanner scanner = new Scanner(System.in);
		// Scanner : 클래스
		// scanner : 참조형 변수

		while (run) {

			System.out.println("\n--------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔액 | 4. 종료");
			System.out.println("--------------------------------");
			System.out.print("선택 > ");

			int key = scanner.nextInt(); // 값 입력

			switch (key) {
			case 1:
				System.out.print("예금액 > ");
				input = scanner.nextInt();
				balance = balance + input; // balance += v;
				break;
			
			case 2 :
				System.out.print("출금액>  ");
				input = scanner.nextInt();
				if (input > balance)
					System.out.println("잔액이 부족합니다.");
				else
					balance = balance - input; // balance -= v;
				break;
			case 3 :
				System.out.println("잔액>  " + balance);
				break;
				
			default :
				run = false;
			}

		} // while 종료
		System.out.print("프로그램 종료");
	}

	public static void main(String[] args) throws Exception {
		new Excercise7_Switch로풀이();
	}
}
