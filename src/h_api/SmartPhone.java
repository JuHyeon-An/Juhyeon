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
//		return super.toString(); // 부모클래스가 가지고 있는 toString 실행결과
		return company +", "+ os;
	}
	
	public static void main(String[] args) {
		SmartPhone sp = new SmartPhone("Google", "안드로이드");
		
		System.out.println(sp);
		System.out.println(sp.toString());
	}
}


