package a_begin;

public class PromotionExample {
	int a = 800; // �ʵ�(�������)�μ� ����� ��
	int b = 100;
	int c = 80;
//	c=a+b; ����� -> Ŭ������ ������ҿ� ������� �� �� ����. ������Ұ�X.
//	�׼��� �������� ������ �޼ҵ忡�� ó���Ѵ�
	
	// �����ڷ� �ҷ����� �޼ҵ� (�޼ҵ���� Ŭ������� ����)
	// ��ä�� ������ �� �ִ� �޼ҵ�
	// �� void ����? : void�� ���� Ŭ������� ���������� �����ڰ� �ƴ�. �����ڿ��� void ��� X
	PromotionExample(){
		c=a+b;
		System.out.println(c);
	}
	
	// �Ϲݸ޼ҵ� : �������� call����� �����
	void PromotionExample1() {
		System.out.println(a);
	}
	
	public static void main(String[] args) {
		new PromotionExample(); // new �������̸�() �ϸ� class �� ���α׷��� �����
		
	}
}

// �޼ҵ� �� ���� ���ο��� �̸� ������?
// int �տ� static ������?
