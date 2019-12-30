package c_control;

public class Exam2 {

	int totM = 4530; // 주행거리
	int base = 2000; // 기본거리
	int basePrice = 3000; // 기본요금
	int mPrice = 500; // 추가요금
	int m = totM-base; // 추가거리
	int totPrice = 0;
	int v = m/200; // 몇 번 과금해야되는지 횟수를 나타냄
	Exam2(){
		
		if(m>0) { //기본요금을 초과한 케이스
			if((m%200)>0) { // 200에서 1만 더 가도 500원이 추가되기 때문에
				v++; // 초과요금 횟수를 한번 더
			}
			totPrice = basePrice + (500*v);
		}else totPrice = basePrice;
		
		System.out.println(totPrice);
		}
	
	public static void main(String[] args) {
		new Exam2();
	}
}
