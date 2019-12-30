package i_thread;

public class NotifyA extends Thread{

	WorkObject obj;
	
	public NotifyA(WorkObject obj){
		this.obj = obj;
	}
	
	@Override
	public void run() {
		for(int i = 0; i<10; i++) {
			obj.methodA(); // mothodA가 10번 실행
		}
	}
}
