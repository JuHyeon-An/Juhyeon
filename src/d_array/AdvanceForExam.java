// ���� for���� ����Ͽ� �迭�� �հ踦 ���ϱ�

package d_array;

public class AdvanceForExam {

	AdvanceForExam() {
		int[] a = {4,6,2,67,4,2,6,2,36,4,2,1};
		int sum = 0;
		double avg = 0;
		
		for(int k : a) {
			sum+=k;
		}
		avg = (double)(sum/a.length);
		
		System.out.println("�հ� : "+sum);
		System.out.println("��� : " +avg);
	}
	
	public static void main(String[] args) {
		new AdvanceForExam();
	}

}
