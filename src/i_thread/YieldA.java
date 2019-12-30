package i_thread;

public class YieldA extends Thread {
	boolean stop = false;
	boolean work = true;

	public void run() {
		while (!stop) { // 참
			if (work) {
				System.out.println("yield A .... ");
			} else {
				yield(); // 양보 : 다른 스레드가 돌도록
			} // end of if
		
			try {
				Thread.sleep(500); // 0.5초에 한번씩 찍어라
				} catch(Exception ex) {}
		
		} // end of while
	System.out.println("yield A 종료");
	}
}
