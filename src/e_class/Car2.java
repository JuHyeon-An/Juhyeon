// ������ ���� -> �������� ��ǰ
package e_class;

public class Car2 {
	int gas;

	public void setGas(int gas) { // setter (�Ű����� �ϳ�, �ڿ� �ٴ� �̸� = �ʵ��̸�)
//		�ʵ忡 �Ű������� ������ ���� �����ϴ� ����
		this.gas = gas;
//		gas = g; (���� �Ű������� g���.)
	}

	public boolean isLeftGas() {
		if (gas == 0) {
			System.out.println("������ �����ϴ�");
			return false;
		}
		System.out.println("������ �ֽ��ϴ�");
		return true;
	}
	
	

	public void run() {

		while(true) {
			if(gas>0) {
				System.out.println("������ : "+gas);
				gas--;
			}else {
				System.out.println("������ �����ϼ���");
				return;
			}
		}
	}

}
