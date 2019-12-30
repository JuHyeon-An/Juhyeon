package i_thread;

public class YieldB extends Thread{

	boolean stop = false;
	boolean work = true;
	
	public void run() {
		while(!stop) {
			if(work) {
				System.out.println("yield B ... ");
			}else {
				yield();
			} // end of if
			
			try {
				Thread.sleep(500);
				} catch(Exception ex) {}
			
		} // end of while
	System.out.println("Yield B Á¾·á");
	}
}
