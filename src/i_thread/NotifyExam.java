package i_thread;

public class NotifyExam {

	public static void main(String[] args) {

		WorkObject obj = new WorkObject(); // �����ڿ�
		
		NotifyA t1 = new NotifyA(obj); // �۾������� �ΰ�
		NotifyB t2 = new NotifyB(obj);
		
		t1.start();
		t2.start();
	}
}
