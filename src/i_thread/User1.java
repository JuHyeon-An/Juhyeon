package i_thread;

public class User1 extends Thread{

	Calculator calc;
	
	public void setCalc(Calculator calc) {
		this.calc = calc;
		this.setName("User 1");
	}
	
	@Override
	public void run() {
		calc.setMemory(100);
	}
}
