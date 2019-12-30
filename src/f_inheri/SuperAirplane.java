package f_inheri;

public class SuperAirplane extends Airplane {

	public static final int NORMAL = 1;
	public static final int SUPERSONIC = 2;
	public int flymode = NORMAL;
	
	public SuperAirplane() {
		super();
		System.out.println("초음속비행기입니다.");
	}
	
	public SuperAirplane(int k) {
		super(50);
		System.out.println("초음속비행입니다."+k);
	}
	
	
	
	@Override // 메소드가 정확하게 재정의됐는지 메타 데이터로 체크해준다
	public void fly() {
	if(flymode == NORMAL) {
		super.fly(); // flymode가 normal이면 부모의 fly를 호출하고
	}else {
		System.out.println("초음속비행"); //l 그렇지 않으면 자식의 fly
	}
	
	}
}
