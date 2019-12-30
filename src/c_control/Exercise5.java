// 중첩 for문을 이용하여 방정식 4x+5y = 60의 모든 해를 구해서 (x, y) 형태로 출력해보세요. (x, y는 10 이하의 자연수)

package c_control;

public class Exercise5 {

	public Exercise5() {
		int x=0;
		int y=0;
		
		
		for(x=0; x<=10; x++) {
			for(y=0; y<=10; y++) {
				if(4*x+5*y==60) {
					System.out.printf("(%1d, %1d)", x, y);
				}
				
			}
		}
	}

	public static void main(String[] args) {
		new Exercise5();
	}
}
