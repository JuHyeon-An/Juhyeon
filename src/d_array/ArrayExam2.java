package d_array;
// �񱳹� �ΰ�, for�� �ΰ�
//�ּҰ� -> ����, �ִ밪 �񱳹�
public class ArrayExam2 {
	ArrayExam2() {
		int[] scores = {30, 40, 60, 69, 90, 48, 82, 79, 28, 49, 100};
		int max = scores[0]; // -99999 : ù��° �����Ͱ��� ������ �꺸�� Ŭ ��, �׷��� ����ؼ� ū���� ���ŵɰ��̴�
		int min = scores[0]; // 999999
		//�ִ밪 : �߻��� �� �ִ� �����ͺ��� �ξ� ���� ���� �ʱⰪ����
		//�ּҰ� : �߻��� �� �ִ� �����ͺ��� �ξ� ū ���� �ʱⰪ����
		
		for(int i=1; i<scores.length; i++) {
			if(max<scores[i]) max = scores[i];
		}
		
		for(int i=1; i<scores.length; i++) {
			if(min>scores[i]) min = scores[i];
		}
		System.out.println("�ִ밪 : "+max);
		System.out.println("�ּҰ� : "+min);}

	

	public static void main(String[] args) {
		new ArrayExam2();

	}
}
