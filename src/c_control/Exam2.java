package c_control;

public class Exam2 {

	int totM = 4530; // ����Ÿ�
	int base = 2000; // �⺻�Ÿ�
	int basePrice = 3000; // �⺻���
	int mPrice = 500; // �߰����
	int m = totM-base; // �߰��Ÿ�
	int totPrice = 0;
	int v = m/200; // �� �� �����ؾߵǴ��� Ƚ���� ��Ÿ��
	Exam2(){
		
		if(m>0) { //�⺻����� �ʰ��� ���̽�
			if((m%200)>0) { // 200���� 1�� �� ���� 500���� �߰��Ǳ� ������
				v++; // �ʰ���� Ƚ���� �ѹ� ��
			}
			totPrice = basePrice + (500*v);
		}else totPrice = basePrice;
		
		System.out.println(totPrice);
		}
	
	public static void main(String[] args) {
		new Exam2();
	}
}
