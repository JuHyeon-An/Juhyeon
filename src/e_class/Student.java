//e1) Student 클래스를 작성
//e2) 매개변수가 없는 생성자로 객체를 생성하면 이름, 주소, 연락처를 "홍길동", "종로구", "010-1111-1111"으로 필드를 초기화하시오 (irum, address, phone)
//e3) 이름을 파라미터로 전달하면 전달된 이름만 필드에 적용되는 생성자를 중복 선언하시오.
//  l 중복선언의 기준 : 다른 매개변수, 매개변수 몇개인지 매개변수 순서 달라야됨
//e4) 이름, 주소, 연락처를 파라미터로 전달하면 모든 값을 필드에 적용하는 생성자를 중복 선언하시오
//e5) main() 을 작성하여 위의 요구 조건이 처리되는지를 테스트 하시오.

package e_class;

public class Student {

	private String irum = null; // 나만 쓰고 싶으면, 혹은 보안에 필요하면 private 으로 선언 -> 같은 패키지에서만 사용할 수 있음
	String address = null;
	String phone; // null 값 주는것과 똑같음.
	// tip 지역변수는 자동으로 초기화되지 않지만 필드는 된다
	
	Student(){ // 생성자를 기술하는 목적 : 필드의 초기화
	this.irum = "홍길동 ";
	this.address = "종로구";
	this.phone = "010-1111-1111";
	}
	
	Student(String irum){
	this.irum = irum;
	}
	
	Student(String irum, String address, String phone){
	this.irum = irum;
	this.address = address;
	this.phone = phone;
	}
	
	void prn() {
		System.out.println("성명 : "+this.irum);
		System.out.println("주소 : "+this.address);
		System.out.println("번호 : "+this.phone);
		System.out.println("-----------------------------");
	}
	
	public static void main(String[] args) {
		Student s1 = new Student(); // student 타입의 객체명 s1, student 타입의 인스턴스명 s1
		Student s2 = new Student("안주현");
		Student s3 = new Student("주현", "경기도 고양시", "010-4110-0000");
		
		System.out.println("s1 : 파라미터 없는 생성자");
		s1.prn();
		
		System.out.println("s2 : irum 파라미터를 전달되면 전달된 이름만 필드에 적용되는 생성자");
		s2.prn();
		
		System.out.println("s3 : 이름, 주소, 연락처를 파라미터를 전달하면 모든 값을 필드에 적용하는 생성자");
		s2.prn();

	}
}
