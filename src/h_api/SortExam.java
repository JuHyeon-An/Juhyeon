package h_api;

import java.util.Arrays;
import java.util.Objects;

public class SortExam {

	// 숫자형 배열값을 오름차순으로 정렬
	public void numberSort() {
		int[] n = { 354, 632, 72, 45, 2, 6443, 5423, 6, 5345, 54, 34, 554, 634 };

		System.out.print("정렬 전 : ");
		System.out.println(Arrays.toString(n));

		int temp = 0;
		for (int i = 0; i < n.length - 1; i++) { // 비교 기준
			for (int j = i + 1; j < n.length; j++) { // 비교 대상
				if (n[i] > n[j]) { // swap
					temp = n[i]; // 대피소에 잠깐 이동시켜놨다가
					n[i] = n[j]; // 더 작은 값으로 대체하고
					n[j] = temp; // 대피소에 가져다놨던 값 다시 가져오기
				} // end of if
			} // j
		} // i

		System.out.print("정렬 후 : ");
		System.out.println(Arrays.toString(n));
	}

	// 문자열형 배열값을 오름차순으로 정렬
	public void strSort() {
		String[] n = new String[] { "fgs", "ghwer", "sowg", "jyes", "메소드", "클래스", "juhyeon", "ellen", "352", "61235",
				"1235" };
		String temp = "";
		System.out.println("문자열 정렬 전 : "+Arrays.toString(n));
		
		for (int i = 0; i < n.length - 1; i++) {
			for(int j = i+1; j<n.length; j++) {
				if(n[i].compareTo(n[j])>0) {
					temp = n[i];
					n[i] = n[j];
					n[j] = temp;
				}// end of if
			}// for j
		} // for i
		System.out.println("문자열 정렬 후 : "+Arrays.toString(n));
	}
	
	public void objSort() {
		Student[] n = new Student[] {
				new Student(10, "hong", 60),
				new Student(1, "kim", 90),
				new Student(3, "park", 40),
				new Student(8, "lee", 99),
				new Student(2, "hong", 66)
		};
		
//		System.out.println(Arrays.toString(n));
		
		Student temp = null; // 객체니까 반드시 초기값 null
		
		for(int i = 0; i<n.length-1; i++) { // 기준
			for(int j = i+1; j<n.length; j++) { // 비교대상
				int result = Objects.compare(n[i], n[j], new StudentComp());
				if(result>0) { // a에서 b 뺀게 0보다 크면 b가 더 작다는 의미니까 b를 앞으로 (swap)
					temp = n[i];
					n[i] = n[j];
					n[j] = temp;
				} // if
			} // j
		} // i
		
		for(int i=0; i<n.length; i++) {
			System.out.println(n[i]);
		} // 한줄씩 출력되도록
		
		
	}

	public static void main(String[] args) {
		SortExam se = new SortExam();
//		se.numberSort();
//		se.strSort();
		se.objSort();

	}

}
