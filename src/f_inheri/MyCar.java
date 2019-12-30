package f_inheri;

public class MyCar {
	KumhoTire[] front = new KumhoTire[2];
	HankukTire[] back = new HankukTire[2];
	
	Tire[] tire = new Tire[4];
	
	public static void main(String[] args) {
		MyCar m = new MyCar();
		m.tire[0] = new KumhoTire();
		m.back[0] = new HankukTire();
		
		m.tire[0].run();
		
		// 객체가 HankukTire로 만들어져 있는 경우 참
		Tire h1 = new HankukTire();
		
		if(h1 instanceof HankukTire) {
			System.out.println("h1은 한국타이어로 만들어짐");
		}else {
			System.out.println("h1은 한국타이어로 만들어지지 않음");
		}
		
		
		
		
	}

}
