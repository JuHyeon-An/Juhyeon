package d_array;

public class ArrayExam1 {
	ArrayExam1(){
		//  �迭�� �����ϸ鼭 �ʱ갪�� ����
		int[] scores = {11,12,13,14,15};
		System.out.println(scores[0]);
		System.out.println(scores[4]);
		
		//���ڿ��� �迭�� �����ϰ� ������ ������ 3�� ����
		String[] names = {"������", "���̾�", "ȫ�浿"};
		System.out.println(names[0]);
		System.out.println(names[1]);
		System.out.println(names[2]);
		
		names[0] = "JuHyeon";
		names[1] = "Ryan";
		names[2] = "Hong";
		
		System.out.println(names[0]);
		System.out.println(names[1]);
		System.out.println(names[2]);
		
		//�迭�� ������ �Ŀ� �ʱⰪ�� ������ ��
		//double[] height = new double[]{170.3, 159.2, 160.4, 180.1}
		double[] height = null;
		height = new double[] {170.3, 159.2, 160.4, 180.1};
		
		// 10���� �����Ը� ������ �� �ִ� �Ǽ��� �迭�� ����
		double[] w = new double[10];
		
		// �����Լ��� ����Ͽ� �����Ը� �߻����� �迭 w�� ����.
		for(int i=0; i<10; i++) {
			double d = (Math.random()*100); //0kg ���� 99.99kg����
			w[i] = d;
		}
		
		for(int i=0; i<10; i++) {
			System.out.printf("%5.1f\n", w[i]); // ��ü 5�ڸ��� �Ҽ��� 1�ڸ��� �� ���. (d = ����, f = �Ǽ�)
			// 5 -> ��ü ���� �� �ִ� �ڸ�(�ڸ���)�� ��Ÿ��. ���� �ڸ��� �����ϴϱ� ����!
		}
		
		//�������� �հ�� ��� ���
		double hap = 0;
		for(int i =0; i<w.length; i++) {
			hap+=w[i];
		}
		
		double avg = hap/w.length;
		System.out.printf("�հ� = %8.2f\n", hap);
		System.out.printf("��� = %7.2f\n", avg);
		
		
		
	}
	
	public static void main(String[] args) {
		for(int i=0; i<args.length; i++) {
			System.out.println(args[i]);
		}
//		new ArrayExam1();
	}
}
