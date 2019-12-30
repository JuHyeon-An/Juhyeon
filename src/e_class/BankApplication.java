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
			System.out.println("1. °èÁÂ»ý¼º | 2. °èÁÂ¸ñ·Ï | 3. ¿¹±Ý | 4. Ãâ±Ý | 5. Á¾·á");
			System.out.println("-----------------------------------");
			System.out.print("¼±ÅÃ> ");
			
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
		System.out.println("ÇÁ·Î±×·¥ Á¾·á");
		
	}

	private static void creatAccount() {
		System.out.println("-----------");
		System.out.println("°èÁÂ»ý¼º");
		System.out.println("-----------");
		scanner.nextLine();
		System.out.print("°èÁÂ¹øÈ£ : ");
		String acc = scanner.nextLine();
		System.out.print("°èÁÂÁÖ : ");
		String n = scanner.nextLine();
		System.out.print("ÃÊ±âÀÔ±Ý¾× : ");
		int input = scanner.nextInt();
		System.out.println("°á°ú : °èÁÂ°¡ »ý¼ºµÇ¾ú½À´Ï´Ù.");
		
		Account a = new Account(acc,n,input);
		a.setBalance(input);
		
		accountArray[count] = a;
		count++;
		
		
	}
	
	private static void accountList() {
		
		
		
		System.out.println("-----------");
		System.out.println("°èÁÂ¸ñ·Ï");
		System.out.println("-----------");
		for(int i=0; i<count; i++) {
		System.out.println(accountArray[i].getAno()+"  "+accountArray[i].getOwner()+"  "+accountArray[i].getBalance());
		}
	}
	
	private static void deposit() {
		scanner.nextLine();
		System.out.print("°èÁÂ¹øÈ£  : ");
		String acc = scanner.nextLine();
		Account a = findAccount(acc); // accountArray[i]
		System.out.print("¿¹±Ý¾× : ");
		int input = scanner.nextInt();
		
		a.setBalance(a.getBalance()+input);
		System.out.println("ÇöÀç ÀÜ¾× : "+a.getBalance());
	}
	
	private static void withdraw() {
		scanner.nextLine();
		System.out.print("°èÁÂ¹øÈ£ : ");
		String acc = scanner.nextLine();
		Account a = findAccount(acc);
		System.out.print("Ãâ±Ý¾× : ");
		int out = scanner.nextInt();
		
		a.setBalance(a.getBalance()-out);
		System.out.println("ÇöÀç ÀÜ¾× : "+a.getBalance());
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
