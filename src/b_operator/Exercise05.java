package b_operator;
// ����, �����ϱ�

public class Exercise05 {
	int value = 356;
	double value2 = 284;
	int tax = 12340;
	double a = 12340.554329; // ����
	int g = (int) 12340.5;
	double value3 = value/value2;
	
	
	Exercise05(){
	System.out.println(a);
	System.out.println((int)a*100);
	
	
	System.out.println(g);
	System.out.println((value/100)*100);
	System.out.println((value/10)*10);
	System.out.println((int)(value3*100)/100.0); // �Ҽ� ��°�ڸ������� ��������

	
	System.out.println(tax/100*100); //12300
	
	System.out.println((g/100*100)+100);
	System.out.println((int)a/100*100+100);
	System.out.println((int)(a+99.999)/100*100);
	
	}
	
	public static void main(String[] args) {
	new Exercise05();	
	}
	
	
}
