package practice;

public class DataTypePractice {
	int a = 249325; // 249000
	double b = 48293.424; // 48293.5
	double c = a/b; // 5.162711.. -> 5.2
	double d = 11.0/4.0; // 2.75 -> 2.7
	int e = 38205; // -> 38300
	
	DataTypePractice(){
	System.out.println(a/1000*1000);
	System.out.println((int)((b+0.099999)*10)*0.1);
	System.out.println((int)((c+0.099999)*10)*0.1);
	System.out.println(((int)(d*10))*0.1);
	System.out.println((e+100)/100*100);
	
	}	
	
	public static void main(String[] args) {
	new DataTypePractice();	
	}
}
