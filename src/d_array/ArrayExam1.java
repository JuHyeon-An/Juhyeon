package d_array;

public class ArrayExam1 {
	ArrayExam1(){
		//  배열을 선언하면서 초깃값을 대입
		int[] scores = {11,12,13,14,15};
		System.out.println(scores[0]);
		System.out.println(scores[4]);
		
		//문자열형 배열을 선언하고 임의의 성명을 3개 저장
		String[] names = {"안주현", "라이언", "홍길동"};
		System.out.println(names[0]);
		System.out.println(names[1]);
		System.out.println(names[2]);
		
		names[0] = "JuHyeon";
		names[1] = "Ryan";
		names[2] = "Hong";
		
		System.out.println(names[0]);
		System.out.println(names[1]);
		System.out.println(names[2]);
		
		//배열을 선언한 후에 초기값을 설정할 때
		//double[] height = new double[]{170.3, 159.2, 160.4, 180.1}
		double[] height = null;
		height = new double[] {170.3, 159.2, 160.4, 180.1};
		
		// 10명의 몸무게를 저장할 수 있는 실수형 배열을 선언
		double[] w = new double[10];
		
		// 랜덤함수를 사용하여 몸무게를 발생시켜 배열 w에 저장.
		for(int i=0; i<10; i++) {
			double d = (Math.random()*100); //0kg 에서 99.99kg까지
			w[i] = d;
		}
		
		for(int i=0; i<10; i++) {
			System.out.printf("%5.1f\n", w[i]); // 전체 5자리에 소수점 1자리만 찍어서 출력. (d = 정수, f = 실수)
			// 5 -> 전체 찍을 수 있는 자리(자리수)를 나타냄. 점도 자리를 차지하니까 포함!
		}
		
		//몸무게의 합계와 평균 계산
		double hap = 0;
		for(int i =0; i<w.length; i++) {
			hap+=w[i];
		}
		
		double avg = hap/w.length;
		System.out.printf("합계 = %8.2f\n", hap);
		System.out.printf("평균 = %7.2f\n", avg);
		
		
		
	}
	
	public static void main(String[] args) {
		for(int i=0; i<args.length; i++) {
			System.out.println(args[i]);
		}
//		new ArrayExam1();
	}
}
