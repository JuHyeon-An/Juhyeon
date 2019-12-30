package i_thread;

public class User2 extends Thread{
	
	Calculator calc;
	
	void setCalc(Calculator calc) {
		this.calc = calc;
		this.setName("User 2");
	}
	
	@Override
	public void run() {
		calc.setMemory(50);
	}
	
}
