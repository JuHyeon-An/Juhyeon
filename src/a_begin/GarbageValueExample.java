package a_begin;

public class GarbageValueExample {
	public static void main(String[] args) {
		
		byte var1 = 125;
		int var2 = 125;
		
		for(int i=0; i<5; i++) { // i++ --> i = i+1 (��������)
			
			var1++; //1�� ���Ѵ�
			var2++;
			
			System.out.println("i�� "+i+"�϶� -> var1: "+var1+"\t"+"var2 :"+var2);
		}
		
//		System.out.println("2+5 = " + 2+5);
//		System.out.println("2+5 = " + (2+5));
	}
}
