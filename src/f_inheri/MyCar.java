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
		
		// ��ü�� HankukTire�� ������� �ִ� ��� ��
		Tire h1 = new HankukTire();
		
		if(h1 instanceof HankukTire) {
			System.out.println("h1�� �ѱ�Ÿ�̾�� �������");
		}else {
			System.out.println("h1�� �ѱ�Ÿ�̾�� ��������� ����");
		}
		
		
		
		
	}

}
