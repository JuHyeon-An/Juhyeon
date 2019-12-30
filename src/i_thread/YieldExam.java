package i_thread;

public class YieldExam {

	public static void main(String[] args) {
		YieldA y1 = new YieldA();
		YieldB y2 = new YieldB();

		y1.start();
		y2.start();

		try {
			Thread.sleep(3000);
		} catch (Exception ex) {
		}
		y1.work = false; // yieldB만 실행

		try {
			Thread.sleep(3000);
		} catch (Exception ex) {}
		y1.work = true; // A, B 같이 실행
		
		
		try {
			Thread.sleep(3000);
		} catch (Exception ex) {} // stop 하기 전에 3초 둘이 번갈아서 찍기

		y1.stop = true;
		y2.stop = true;
	}
}
