package c_control;

public class ExerciseForStar {

	public ExerciseForStar() {
		int a = 1;
		int j = 1;
		for (int i = 1; i <= 4; i++) {
			
			for(j=1; j <=5-i; j++) {
				System.out.print("*"); 
			}
			for(int k=5; a<=k-j; a++, k++) {
				System.out.print("&");
			}
			System.out.println("^");
		}
//		}
//			for(int j = 1; j<=i; j=j+2) {
//				
//			System.out.println();
//		}
		/*
		 *     *     
		 *    ***          
		 *   *****
		 *  ******* 
		 */  
	}

	public static void main(String[] args) {
		new ExerciseForStar();
	}
}
