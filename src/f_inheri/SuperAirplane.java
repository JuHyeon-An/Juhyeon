package f_inheri;

public class SuperAirplane extends Airplane {

	public static final int NORMAL = 1;
	public static final int SUPERSONIC = 2;
	public int flymode = NORMAL;
	
	public SuperAirplane() {
		super();
		System.out.println("�����Ӻ�����Դϴ�.");
	}
	
	public SuperAirplane(int k) {
		super(50);
		System.out.println("�����Ӻ����Դϴ�."+k);
	}
	
	
	
	@Override // �޼ҵ尡 ��Ȯ�ϰ� �����ǵƴ��� ��Ÿ �����ͷ� üũ���ش�
	public void fly() {
	if(flymode == NORMAL) {
		super.fly(); // flymode�� normal�̸� �θ��� fly�� ȣ���ϰ�
	}else {
		System.out.println("�����Ӻ���"); //l �׷��� ������ �ڽ��� fly
	}
	
	}
}
