package d_array;
// 비교문 두개, for문 두개
//최소값 -> 루핑, 최대값 비교문
public class ArrayExam2 {
	ArrayExam2() {
		int[] scores = {30, 40, 60, 69, 90, 48, 82, 79, 28, 49, 100};
		int max = scores[0]; // -99999 : 첫번째 데이터값이 무조건 얘보다 클 것, 그러면 계속해서 큰값이 갱신될것이다
		int min = scores[0]; // 999999
		//최대값 : 발생할 수 있는 데이터보다 훨씬 작은 값을 초기값으로
		//최소값 : 발생할 수 있는 데이터보다 훨씬 큰 값을 초기값으로
		
		for(int i=1; i<scores.length; i++) {
			if(max<scores[i]) max = scores[i];
		}
		
		for(int i=1; i<scores.length; i++) {
			if(min>scores[i]) min = scores[i];
		}
		System.out.println("최대값 : "+max);
		System.out.println("최소값 : "+min);}

	

	public static void main(String[] args) {
		new ArrayExam2();

	}
}
