package i_thread;

public class PriorityExam {

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			Thread t = new CalcThread("thread"+i);
			
			if(i!=10) {
				t.setPriority(Thread.MIN_PRIORITY); // 10 Áàµµ µÊ
			}else {
				t.setPriority(Thread.MAX_PRIORITY); // 1 Áàµµ µÊ
			}
			t.start();
		}
	}
}
