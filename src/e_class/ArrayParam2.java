package e_class;

public class ArrayParam2 {

	void input(int s) {
		
	}
	
	void input(Student s) { // 인풋에 어떤 방법을 사용해야 테스트할 수 있을까?
		s.prn();
	}
	
	void input(Car s) {
	System.out.println(s.model);
	System.out.println(s.color);
	System.out.println(s.maxSpeed);
	}

	public static void main(String[] args) {
		ArrayParam2 ap2 = new ArrayParam2();
		Student std = new Student(); // 매개변수 없는 생성자
		ap2.input(std); // Student 타입의 s에 넣기 위해서 Student 타입의 객체 생성하여 넣었음.
		
		System.out.println("--------------");
		Car c1 = new Car(); // 매개변수가 없는 생성자로 생성
		ap2.input(c1);
		Car c2 = new Car("볼보", "빨강", 400);
		ap2.input(c2);
		
	}

}
