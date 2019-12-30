package e_class;

import java.util.Scanner;

public class BankApplication {
	static int count = 0;
	private static Account[] accountArray = new Account[100];
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;
		while(run) {
			System.out.println("-----------------------------------");
			System.out.println("1. ���»��� | 2. ���¸�� | 3. ���� | 4. ��� | 5. ����");
			System.out.println("-----------------------------------");
			System.out.print("����> ");
			
			int selectNo = scanner.nextInt();
			
			if(selectNo == 1) {
				creatAccount();
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
		System.out.println("���α׷� ����");
		
	}

	private static void creatAccount() {
		System.out.println("-----------");
		System.out.println("���»���");
		System.out.println("-----------");
		scanner.nextLine();
		System.out.print("���¹�ȣ : ");
		String acc = scanner.nextLine();
		System.out.print("������ : ");
		String n = scanner.nextLine();
		System.out.print("�ʱ��Աݾ� : ");
		int input = scanner.nextInt();
		System.out.println("��� : ���°� �����Ǿ����ϴ�.");
		
		Account a = new Account(acc,n,input);
		a.setBalance(input);
		
		accountArray[count] = a;
		count++;
		
		
	}
	
	private static void accountList() {
		
		
		
		System.out.println("-----------");
		System.out.println("���¸��");
		System.out.println("-----------");
		for(int i=0; i<count; i++) {
		System.out.println(accountArray[i].getAno()+"  "+accountArray[i].getOwner()+"  "+accountArray[i].getBalance());
		}
	}
	
	private static void deposit() {
		scanner.nextLine();
		System.out.print("���¹�ȣ  : ");
		String acc = scanner.nextLine();
		Account a = findAccount(acc); // accountArray[i]
		System.out.print("���ݾ� : ");
		int input = scanner.nextInt();
		
		a.setBalance(a.getBalance()+input);
		System.out.println("���� �ܾ� : "+a.getBalance());
	}
	
	private static void withdraw() {
		scanner.nextLine();
		System.out.print("���¹�ȣ : ");
		String acc = scanner.nextLine();
		Account a = findAccount(acc);
		System.out.print("��ݾ� : ");
		int out = scanner.nextInt();
		
		a.setBalance(a.getBalance()-out);
		System.out.println("���� �ܾ� : "+a.getBalance());
	}
	
	private static Account findAccount(String ano) {
		Account a = new Account("", "", 0);
		for (int i = 0; i < count; i++) {
			if (ano.equals(accountArray[i].getAno())) {
				a = accountArray[i];
			}
		}
		return a;
		
	}
}
