package i_thread;

public class NotifyB extends Thread{

	WorkObject obj;
	
	public NotifyB(WorkObject obj) {
		this.obj = obj;
	}
	
	@Override
	public void run() {
		
		for (int i = 0; i < 10; i++) {
			obj.methodB();
		}
	}

}
