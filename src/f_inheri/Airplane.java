package f_inheri;

public class Airplane {
	
	public Airplane() {
		System.out.println("�Ϲݺ����");
	}
	
	public Airplane(int tire) {
		System.out.println("Ÿ�̾ "+tire+"���� �Ϲ� �����");
	}
	
	public void land() {
	System.out.println("�����մϴ�.");	
	}
	
	public void fly() { // �θ�� �Ϲݺ��ุ ������ ����
		System.out.println("�Ϲݺ���");
	}

	public void takeoff() {
		System.out.println("�̷�");
	}
	
}
