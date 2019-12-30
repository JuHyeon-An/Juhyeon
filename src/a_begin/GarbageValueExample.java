package a_begin;

public class GarbageValueExample {
	public static void main(String[] args) {
		
		byte var1 = 125;
		int var2 = 125;
		
		for(int i=0; i<5; i++) { // i++ --> i = i+1 (누적연산)
			
			var1++; //1씩 더한다
			var2++;
			
			System.out.println("i가 "+i+"일때 -> var1: "+var1+"\t"+"var2 :"+var2);
		}
		
//		System.out.println("2+5 = " + 2+5);
//		System.out.println("2+5 = " + (2+5));
	}
}
