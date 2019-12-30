package i_thread;

public class WaitNotifyExample {

	public static void main(String[] args) {

		DataBox databox = new DataBox();
		
		ProducerThread p = new ProducerThread(databox);
		ConsumerThread c = new ConsumerThread(databox);
		
		p.start();
		c.start();
		
	}

}
