package a_begin;

public class Score2 {
	public static void main(String[] args) {
		
		String name = "ȫ�浿";
		float score = 100.0f; // floatŸ���� �ڿ� "f"�ٿ��ֱ�
		char result = 'A'; // �ϳ��� ���� -> char Ÿ��, ���� ����ǥ
		int a = 30;
		
		System.out.println(result++); //char
		result += 2; // result�� 2�� ���� �� �ٽ� result�� �����Ѵ�		
		System.out.println(result+1); // ������
		
		System.out.println("�̸� : "+name);
		System.out.println("���� : "+score);
		System.out.println("���� : "+result);

	}
	
}
