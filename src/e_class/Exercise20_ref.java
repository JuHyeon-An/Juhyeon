package e_class;

import java.util.Scanner;

public class Exercise20_ref {

	private static Account[] accountArray = new Account[100];
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		boolean run = true;
		while (run) {
			System.out.println("---------------------------------");
			System.out.println("1.계좌생성|2.계좌목록|3.예금|4.출금|5.종료");
			System.out.println("---------------------------------");
			System.out.print("선택> ");

			int selectNo = scanner.nextInt();

			if (selectNo == 1) {
				createAccount();
			} else if (selectNo == 2) {
				accountList();
			} else if (selectNo == 3) {
				deposit();
			} else if (selectNo == 4) {
				withdraw();
			} else if (selectNo == 5) {
				run = false;
			}
		}
		System.out.println("프로그램 종료");
	}

	// 계좌 생성하기
	private static void createAccount() {
		String ano = "";
		String owner = "";
		int balance = 0;
		Account newAccount = null;

		scanner.nextLine();

		System.out.println("---------------");
		System.out.println("계좌생성");
		System.out.println("---------------");

		System.out.print("계좌번호: ");
		ano = scanner.nextLine();

		System.out.print("계좌주: ");
		owner = scanner.nextLine();

		System.out.print("초기입금액: ");
		balance = scanner.nextInt();

		newAccount = new Account(ano, owner, balance);

		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] == null) {
				accountArray[i] = newAccount;
				System.out.println("결과: 계좌가 생성되었습니다.");
				break;
			}
		} // end of for i
	}

	// 계좌 목록 보기
	private static void accountList() {
		System.out.println("-------------");
		System.out.println("계좌목록");
		System.out.println("-------------");

		for (int i = 0; i < accountArray.length; i++) {
			Account account = accountArray[i];

			if (account != null) {
				System.out.print(account.getAno());
				System.out.print(" ");
				System.out.print(account.getOwner());
				System.out.print(" ");
				System.out.print(account.getBalance());
				System.out.println();
			} else {
				break;
			}
		} // end of for i
	}

	// 예금 하기
	private static void deposit() {
		Account account = null;
		int result = 0;

		scanner.nextLine();

		System.out.println("-------------");
		System.out.println("예금");
		System.out.println("-------------");

		System.out.print("계좌번호: ");
		String ano = scanner.nextLine();

		System.out.print("예금액: ");
		int balance = scanner.nextInt();

		account = findAccount(ano);
		result = account.getBalance() + balance;
		account.setBalance(result);

		System.out.println("결과: 예금이 성공되었습니다.");
	}

	// 출금하기
	private static void withdraw() {
		Account account = null;
		int result = 0;

		scanner.nextLine();

		System.out.println("-------------");
		System.out.println("출금");
		System.out.println("-------------");

		System.out.print("계좌번호: ");
		String ano = scanner.nextLine();

		System.out.print("출금액: ");
		int balance = scanner.nextInt();

		account = findAccount(ano);
		result = account.getBalance() - balance;
		account.setBalance(result);

		System.out.println("결과: 출금이 성공되었습니다.");
	}

	// Account 배열에서 ano와 동일한 Account 객체 찾기
	private static Account findAccount(String ano) {
		Account account = null;

		for (int i = 0; i < accountArray.length; i++) {

			if (accountArray[i] != null) {
				String str = accountArray[i].getAno();

				if (str.equals(ano)) {
					account = accountArray[i];
					break;
				}
			}
		} // end of for i
		return account;
	}
}
