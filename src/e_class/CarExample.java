package e_class;

public class CarExample {

	public static void main(String[] args) {
		Car2 car = new Car2();
		car.setGas(10);
		
		if(car.isLeftGas()) {
			System.out.println("����մϴ�");
			car.run();
		}
		boolean gasstate = car.isLeftGas();
		if(gasstate) {
			System.out.println("���� ���� �ʿ����");
		}else {
			System.out.println("�����Ҹ� �湮�ϼ���");
		}
	}

}
