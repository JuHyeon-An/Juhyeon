package i_thread;

public class WorkObject { // �����ڿ�
	public synchronized void methodA() {
		System.out.println("Thread A�� method A()......");
//		notify(); // ���� ���� ���¿� �ִ� �����带 notify�� �����
//		try {
//			wait();
//		} catch (InterruptedException e) {
//		}
	}

	public synchronized void methodB() {
		System.out.println("Thread B�� method B()......");
//		notify();
//		try {
//			wait();
//		} catch (InterruptedException e) {
//		}
	}
}
