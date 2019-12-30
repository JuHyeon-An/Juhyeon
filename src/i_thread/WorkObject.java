package i_thread;

public class WorkObject { // 공유자원
	public synchronized void methodA() {
		System.out.println("Thread A의 method A()......");
//		notify(); // 실행 중지 상태에 있는 스레드를 notify로 깨우기
//		try {
//			wait();
//		} catch (InterruptedException e) {
//		}
	}

	public synchronized void methodB() {
		System.out.println("Thread B의 method B()......");
//		notify();
//		try {
//			wait();
//		} catch (InterruptedException e) {
//		}
	}
}
