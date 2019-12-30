package practice;

public class ForStar {

	ForStar(){
		
		for(int i = 1; i<=5; i++) {
			for(int a = 1; a<=5-i; a++) {
				System.out.print(" ");
			}
			for(int j = 1; j<=(i*2)-1; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		for(int i = 1; i<=4; i++) {
			for(int a = 1; a<=i; a++) {
				System.out.print(" ");
			}
			for(int j = 1; j<=(-2*i)+9; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		new ForStar();
	}

}
