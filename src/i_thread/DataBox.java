package i_thread;

public class DataBox {

	String data;

	public synchronized String getData() {
	
		if(this.data==null) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String returnvalue = data;
		System.out.println("ConsummerThread가 읽은 데이터 : "+returnvalue);
		data = null;
		notify();
		return returnvalue;
	
	}

	public synchronized void setData(String data) {
		
		if(this.data != null) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.data = data;
		System.out.println("ProducerThread가 생성한 데이터 : "+data);
		notify();
	}
	
	
	
	
	
}
