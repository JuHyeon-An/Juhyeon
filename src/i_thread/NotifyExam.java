package i_thread;

public class NotifyExam {

	public static void main(String[] args) {

		WorkObject obj = new WorkObject(); // 공유자원
		
		NotifyA t1 = new NotifyA(obj); // 작업스레드 두개
		NotifyB t2 = new NotifyB(obj);
		
		t1.start();
		t2.start();
	}
}
