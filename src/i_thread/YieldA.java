package i_thread;

public class YieldA extends Thread {
	boolean stop = false;
	boolean work = true;

	public void run() {
		while (!stop) { // ��
			if (work) {
				System.out.println("yield A .... ");
			} else {
				yield(); // �纸 : �ٸ� �����尡 ������
			} // end of if
		
			try {
				Thread.sleep(500); // 0.5�ʿ� �ѹ��� ����
				} catch(Exception ex) {}
		
		} // end of while
	System.out.println("yield A ����");
	}
}
