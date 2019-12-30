// While문과 Math.random() 메소드를 이용해서 두 개의 주사위를 던졌을 때 나오는 눈 x, y 합이 5가 아니면 계속 주사위 던지고 5면 실행을 멈추기
 
package c_control;

public class Exercise4 {

	public Exercise4() {

		while (true) {
			int x = (int) (Math.random() * 6) + 1; // 난수발생
			int y = (int) (Math.random() * 6) + 1;
			System.out.printf("(%2d,%2d)\n", x, y);
			
			if (x + y == 5) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		new Exercise4();
	}
}
