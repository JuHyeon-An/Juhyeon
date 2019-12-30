package i_thread;

public class Calculator {
	private int memory;

	public int getMemory() {
		return memory;
	}

	// 상호 배타적 동기화를 구현
	public synchronized void setMemory(int memory) {
		this.memory = memory;
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
		
		System.out.println(
				Thread.currentThread().getName()+" "+this.memory);
	}
}
