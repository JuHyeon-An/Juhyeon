package e_class;

public class Car {

	//�ʵ� : Ŭ������ ������ �ִ� Ư���� �����ϴ� ����
	String model = "�׷���";
	String color = "����";
	int maxSpeed = 0;
	
	
	Car(){ } // �Ű������� ���� ������ => �ʵ忡 �����ִ� Ư���� ������ �ִ�. (�׷���, ����, ���ǵ� 0)
	Car(String model){
		this.model = model; //this : ����� ����. ��, �ʵ忡 ����� ����� ����. (this ������ ���ú����� ����)
//		model = this.model �̶�� ���� "������"�̶�� ���� ��������. (�׷����� �ٲ�)
		
	} // String model : �������� (����� ������ �ٸ���)
	
	Car(String model, String color){
		this.model = model;
		this.color = color;
	}
	Car(String model, String color, int maxSpeed){
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
	
	public void speedUp() {
		this.maxSpeed += 10;
	}

	public void speedDown() {
		this.maxSpeed -= 10;
	}
	public static void main(String[] args) {
		Car c1 = new Car();
		Car c2 = new Car("������"); // ������ -> Car�� �Ű����� model�� ���� �װ� �� �ڱ� ��� this.model�� ����.
		// ���� �ٲ㼭 ����
		
		Car c3 = new Car("�̴�����", "blue");
		// �𵨰� ������ �ٲ㼭 ����
		
		Car c4 = new Car("������Ƽ", "red", 500);
		// �𵨰� ������, ���ǵ� �ٲ㼭 ����
		
		//=> �پ��� �װ��� ���� �����ϰڴ�. (������)
		
		//�Ű������� ������ parameter�� ������ ���ƾ��Ѵ�.
		
		c1.maxSpeed = 200; // c1 �ڵ����� maxSpeed�� 200���� Ʃ�� (0 -> 200 ���� �� ����)
		System.out.println("model : "+c1.model);
		System.out.println("colour : "+c1.color);
		System.out.println("maxSpeed : "+c1.maxSpeed);
		System.out.println();
		
		System.out.println("<c4�� ����>");
		System.out.println("model : "+c4.model);
		System.out.println("colour : "+c4.color);
		System.out.println("max speed : "+c4.maxSpeed);
		
		System.out.println("-----------------------");
		c1.speedUp();
		System.out.println("c1�� max speed :"+ c1.maxSpeed);
		
		
		
		
	}
}
