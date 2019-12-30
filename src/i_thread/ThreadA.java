package i_thread;

public class ThreadA extends Thread{

	ThreadA(){
		this.setName("ThreadA");
	}
	
	@Override // run 메소드 재정의
	public void run() {
		for (int i = 0; i < 500; i++) {
			System.out.println(this.getName());
		}
	}
}
