package e_class;

public class CarExample {

	public static void main(String[] args) {
		Car2 car = new Car2();
		car.setGas(10);
		
		if(car.isLeftGas()) {
			System.out.println("출발합니다");
			car.run();
		}
		boolean gasstate = car.isLeftGas();
		if(gasstate) {
			System.out.println("가스 주입 필요없음");
		}else {
			System.out.println("주유소를 방문하세요");
		}
	}

}
