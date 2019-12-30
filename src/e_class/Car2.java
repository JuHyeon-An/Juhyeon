// 메인이 없음 -> 쓰여지는 부품
package e_class;

public class Car2 {
	int gas;

	public void setGas(int gas) { // setter (매개변수 하나, 뒤에 붙는 이름 = 필드이름)
//		필드에 매개변수로 들어오는 값을 대입하는 역할
		this.gas = gas;
//		gas = g; (만약 매개변수가 g라면.)
	}

	public boolean isLeftGas() {
		if (gas == 0) {
			System.out.println("가스가 없습니다");
			return false;
		}
		System.out.println("가스가 있습니다");
		return true;
	}
	
	

	public void run() {

		while(true) {
			if(gas>0) {
				System.out.println("가스량 : "+gas);
				gas--;
			}else {
				System.out.println("가스를 충전하세요");
				return;
			}
		}
	}

}
