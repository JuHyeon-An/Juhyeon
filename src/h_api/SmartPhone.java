package h_api;

public class SmartPhone {

	private String company;
	private String os;
	
	public SmartPhone (String com, String os){
		this.company = com;
		this.os = os;
	}
	
	@Override
	public String toString() {
//		return super.toString(); // �θ�Ŭ������ ������ �ִ� toString ������
		return company +", "+ os;
	}
	
	public static void main(String[] args) {
		SmartPhone sp = new SmartPhone("Google", "�ȵ���̵�");
		
		System.out.println(sp);
		System.out.println(sp.toString());
	}
}


