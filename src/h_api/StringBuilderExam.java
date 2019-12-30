package h_api;

public class StringBuilderExam {
/*	String의 속도와 StringBuilder의 속도 비교 */
	
	
	public StringBuilderExam() {
		//String 속도
		long sTime = 0, eTime = 0;
		String str = "";
		
		sTime = System.nanoTime(); // 시작시간
		
		for(int i = 0; i<50000; i++) {
			str += "a";
		}
		
		eTime = System.nanoTime(); // 끝시간
		
		System.out.println("String 처리 시간 : "+(eTime-sTime));
		
		//StringBuilder 속도
		StringBuilder sb = new StringBuilder(100); // 버퍼 사이즈 100개
		sTime = System.nanoTime();
		for(int i = 0; i<50000; i++) {
			sb.append("a");
		}
		eTime = System.nanoTime();
		
		System.out.println("StringBuilder 처리 시간 : "+(eTime-sTime));
		
		
		
	}
	
	public static void main(String[] args) {
		new StringBuilderExam();
		
		
		
	}

}
