package e_class;

public class Car {

	//필드 : 클래스가 가지고 있는 특성을 저장하는 변수
	String model = "그랜져";
	String color = "검정";
	int maxSpeed = 0;
	
	
	Car(){ } // 매개변수가 없는 생성자 => 필드에 나와있는 특성을 가지고 있다. (그랜져, 검정, 스피드 0)
	Car(String model){
		this.model = model; //this : 멤버를 뜻함. 즉, 필드에 선언된 멤버를 뜻함. (this 없으면 로컬변수를 뜻함)
//		model = this.model 이라고 쓰면 "안주현"이라는 값이 없어진다. (그랜져로 바뀜)
		
	} // String model : 지역변수 (선언된 영역이 다르다)
	
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
		Car c2 = new Car("안주현"); // 안주현 -> Car의 매개변수 model로 들어가고 그게 또 자기 멤버 this.model에 들어간다.
		// 모델을 바꿔서 제공
		
		Car c3 = new Car("미니쿠퍼", "blue");
		// 모델과 차량색 바꿔서 제공
		
		Car c4 = new Car("마세라티", "red", 500);
		// 모델과 차량색, 스피드 바꿔서 제공
		
		//=> 다양한 네가지 모델을 제공하겠다. (다형성)
		
		//매개변수의 순서는 parameter의 순서와 같아야한다.
		
		c1.maxSpeed = 200; // c1 자동차의 maxSpeed를 200으로 튜닝 (0 -> 200 으로 값 변경)
		System.out.println("model : "+c1.model);
		System.out.println("colour : "+c1.color);
		System.out.println("maxSpeed : "+c1.maxSpeed);
		System.out.println();
		
		System.out.println("<c4의 스펙>");
		System.out.println("model : "+c4.model);
		System.out.println("colour : "+c4.color);
		System.out.println("max speed : "+c4.maxSpeed);
		
		System.out.println("-----------------------");
		c1.speedUp();
		System.out.println("c1의 max speed :"+ c1.maxSpeed);
		
		
		
		
	}
}
