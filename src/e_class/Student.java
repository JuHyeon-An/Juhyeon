//e1) Student Ŭ������ �ۼ�
//e2) �Ű������� ���� �����ڷ� ��ü�� �����ϸ� �̸�, �ּ�, ����ó�� "ȫ�浿", "���α�", "010-1111-1111"���� �ʵ带 �ʱ�ȭ�Ͻÿ� (irum, address, phone)
//e3) �̸��� �Ķ���ͷ� �����ϸ� ���޵� �̸��� �ʵ忡 ����Ǵ� �����ڸ� �ߺ� �����Ͻÿ�.
//  l �ߺ������� ���� : �ٸ� �Ű�����, �Ű����� ����� �Ű����� ���� �޶�ߵ�
//e4) �̸�, �ּ�, ����ó�� �Ķ���ͷ� �����ϸ� ��� ���� �ʵ忡 �����ϴ� �����ڸ� �ߺ� �����Ͻÿ�
//e5) main() �� �ۼ��Ͽ� ���� �䱸 ������ ó���Ǵ����� �׽�Ʈ �Ͻÿ�.

package e_class;

public class Student {

	private String irum = null; // ���� ���� ������, Ȥ�� ���ȿ� �ʿ��ϸ� private ���� ���� -> ���� ��Ű�������� ����� �� ����
	String address = null;
	String phone; // null �� �ִ°Ͱ� �Ȱ���.
	// tip ���������� �ڵ����� �ʱ�ȭ���� ������ �ʵ�� �ȴ�
	
	Student(){ // �����ڸ� ����ϴ� ���� : �ʵ��� �ʱ�ȭ
	this.irum = "ȫ�浿 ";
	this.address = "���α�";
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
		System.out.println("���� : "+this.irum);
		System.out.println("�ּ� : "+this.address);
		System.out.println("��ȣ : "+this.phone);
		System.out.println("-----------------------------");
	}
	
	public static void main(String[] args) {
		Student s1 = new Student(); // student Ÿ���� ��ü�� s1, student Ÿ���� �ν��Ͻ��� s1
		Student s2 = new Student("������");
		Student s3 = new Student("����", "��⵵ ����", "010-4110-0000");
		
		System.out.println("s1 : �Ķ���� ���� ������");
		s1.prn();
		
		System.out.println("s2 : irum �Ķ���͸� ���޵Ǹ� ���޵� �̸��� �ʵ忡 ����Ǵ� ������");
		s2.prn();
		
		System.out.println("s3 : �̸�, �ּ�, ����ó�� �Ķ���͸� �����ϸ� ��� ���� �ʵ忡 �����ϴ� ������");
		s2.prn();

	}
}
