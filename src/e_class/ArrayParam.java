package e_class;

public class ArrayParam {

	ArrayParam(int[] s) { // 정수형 배열을 매개변수로 가지고 있음.
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
	}

	// 1 전달받은 배열에서 합계를 구하여 리턴
	int arraySum(int[] s) {
		int sum = 0;
		for (int i = 0; i < s.length; i++) {
			sum += s[i];
		}
		return sum;
	}

	// 2 전달받은 배열에서 최대값을 구하여 리턴
	int arrayMax(int[] s) {
		int max = 0;
		for (int i = 0; i < s.length; i++) {
			if (max < s[i]) {
				max = s[i];
			}
		}
		return max;
	}

	// 3 전달받은 배열에서 최소값을 추출하여 반환
	int arrayMin(int[] s) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < s.length; i++) {
			if (min > s[i]) {
				min = s[i];
			}
		}
		return min;
	}

	int[] maxMin(int[] s) {
		int[] m = new int[2];

		m[0] = s[0]; // max
		m[1] = s[0]; // min
		
		for (int i = 1; i < s.length; i++) {
			if (m[0] < s[i]) {
				m[0] = s[i];
			}else if (m[1] > s[i]) {
				m[1] = s[i];
			}
		}
//		max, min 변수를 따로 선언한 후에
//		m = new int[]{max, min} 으로 해도 상관없음

		return m; // 배열명은 배열 전체를 나타낸다. (배열 통째로 전달된다)
	}

	public static void main(String[] args) {
		int[] abc = { 100, 42, 64, 25, -1, 4, 35, 63, 23, 192 };
		ArrayParam ap1 = new ArrayParam(abc); // 매개변수가 abc타입 = 정수형 배열타입
		System.out.println("---------------------");
		int hap = ap1.arraySum(abc); // 배열 abc가 s에 들어간다.
		System.out.println("합계 : "+hap);

		System.out.println("---------------------");
		int max = ap1.arrayMax(abc);
		System.out.println("최대값 : " + max);

		System.out.println("---------------------");
		int min = ap1.arrayMin(abc);
		System.out.println("최소값 : "+ min);

		System.out.println("---------------------");
		int mm[] = ap1.maxMin(abc); // int[] mm = new int[2]
		System.out.println("mm[0] 최대값 : " +mm[0]);
		System.out.println("mm[1] 최소값 : " +mm[1]);
//		int[] s = abc; 이렇게 쓴거랑 똑같은것!
//		int[] s = {1,2,3,4,5}

	}

}
