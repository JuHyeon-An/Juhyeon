// ������ ���� -> �������� ��ǰ
package e_class;

public class Car3 {

	String company = "�����ڵ���";
	String model;
	String colour;
	int maxSpeed;
	
	Car3(){
		
	}
	
	Car3(String model){
		this("����", "������", 10);
	}
	
	Car3(String model, String colour){
		this("","",0);
	}
	
	Car3(String model, String colour, int maxSpeed){
	
		this.model = model;
		this.colour = colour;
		this.maxSpeed = maxSpeed;
		
	}
	
	Car3(String colour, int maxSpeed, String model){
		
	}
	
	
	

}