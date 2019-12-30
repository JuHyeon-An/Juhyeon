// 향상된 for문을 사용하여 배열의 합계를 구하기

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
		
		System.out.println("합계 : "+sum);
		System.out.println("평균 : " +avg);
	}
	
	public static void main(String[] args) {
		new AdvanceForExam();
	}

}
