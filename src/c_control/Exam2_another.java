package c_control;

public class Exam2_another {

	int meter = 2000; // �⺻�Ÿ�
	int price = 3000; // �⺻���
	int a = 4530; // ����Ÿ�
	int fee = 500; // �߰����
	int total = 0;
	
	Exam2_another(){
		
		if((a-meter)>0) {
			if((a-meter)%200>0) {
				total = (price+((a-meter)/200)*fee)+500;
			}
		}else total = 3000;
		System.out.println(total);
		
	}
	
	public static void main(String[] args) {
		new Exam2_another();
	}
}
