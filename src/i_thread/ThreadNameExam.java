package i_thread;

public class ThreadNameExam {

	public static void main(String[] args) {

		Thread mainThread = Thread.currentThread(); // �� �ڵ带 �����ϴ� ������ ��ü ���
		System.out.println("���� ������� : " + mainThread.getName());
		
		Thread t1 = new ThreadA(); // Thread A ����
		Thread t2 = new ThreadB(); // Thread B ����
		
		t1.start(); // Thread A ����
		t2.start(); // Thread B ����
		
	}

}
