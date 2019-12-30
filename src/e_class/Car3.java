// 메인이 없음 -> 쓰여지는 부품
package e_class;

public class Car3 {

	String company = "현대자동차";
	String model;
	String colour;
	int maxSpeed;
	
	Car3(){
		
	}
	
	Car3(String model){
		this("볼보", "빨간색", 10);
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