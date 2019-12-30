package i_thread;

public class ThreadNameExam {

	public static void main(String[] args) {

		Thread mainThread = Thread.currentThread(); // 이 코드를 실행하는 스레드 객체 얻기
		System.out.println("메인 스레드명 : " + mainThread.getName());
		
		Thread t1 = new ThreadA(); // Thread A 생성
		Thread t2 = new ThreadB(); // Thread B 생성
		
		t1.start(); // Thread A 실행
		t2.start(); // Thread B 실행
		
	}

}
