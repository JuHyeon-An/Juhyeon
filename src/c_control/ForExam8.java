package c_control;

public class ForExam8 {
	ForExam8() {
		int s1 = 0;
		int s10 = 0;
		int s20 = 0;
		int s30 = 0;
		int s40 = 0;
		int s50 = 0;
		int s60 = 0;
		int s70 = 0;
		int s80 = 0;
		int s90 = 0;
		
		
		for (int i = 0; i < 1000; i++) {
			int num = (int) (Math.random() * 100) + 1;
			switch(num/10) {
			case 0:
				s1++;
				break;
			case 1:
				s10++;
				break;
			case 2:
				s20++;
				break;
			case 3:
				s30++;
				break;
			case 4:
				s40++;
				break;
			case 5:
				s50++;
				break;
			case 6:
				s60++;
				break;
			case 7:
				s70++;
				break;
			case 8:
				s80++;
				break;
			default:
				s90++;
				
			}
		}
		System.out.println("단자리수 :  "+s1+"개");
		System.out.println("10자리수 :  "+s10+"개");
		System.out.println("20자리수 :  "+s20+"개");
		System.out.println("30자리수 :  "+s30+"개");
		System.out.println("40자리수 :  "+s40+"개");
		System.out.println("50자리수 :  "+s50+"개");
		System.out.println("60자리수 :  "+s60+"개");
		System.out.println("70자리수 :  "+s70+"개");
		System.out.println("80자리수 :  "+s80+"개");
		System.out.println("90자리수 :  "+s90+"개");
		
		
		
	}
}
