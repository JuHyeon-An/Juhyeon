package e_class;

public class ArrayParam2 {

	void input(int s) {
		
	}
	
	void input(Student s) { // ��ǲ�� � ����� ����ؾ� �׽�Ʈ�� �� ������?
		s.prn();
	}
	
	void input(Car s) {
	System.out.println(s.model);
	System.out.println(s.color);
	System.out.println(s.maxSpeed);
	}

	public static void main(String[] args) {
		ArrayParam2 ap2 = new ArrayParam2();
		Student std = new Student(); // �Ű����� ���� ������
		ap2.input(std); // Student Ÿ���� s�� �ֱ� ���ؼ� Student Ÿ���� ��ü �����Ͽ� �־���.
		
		System.out.println("--------------");
		Car c1 = new Car(); // �Ű������� ���� �����ڷ� ����
		ap2.input(c1);
		Car c2 = new Car("����", "����", 400);
		ap2.input(c2);
		
	}

}
