package h_api;

import java.util.Arrays;
import java.util.Objects;

public class SortExam {

	// ������ �迭���� ������������ ����
	public void numberSort() {
		int[] n = { 354, 632, 72, 45, 2, 6443, 5423, 6, 5345, 54, 34, 554, 634 };

		System.out.print("���� �� : ");
		System.out.println(Arrays.toString(n));

		int temp = 0;
		for (int i = 0; i < n.length - 1; i++) { // �� ����
			for (int j = i + 1; j < n.length; j++) { // �� ���
				if (n[i] > n[j]) { // swap
					temp = n[i]; // ���Ǽҿ� ��� �̵����ѳ��ٰ�
					n[i] = n[j]; // �� ���� ������ ��ü�ϰ�
					n[j] = temp; // ���Ǽҿ� �����ٳ��� �� �ٽ� ��������
				} // end of if
			} // j
		} // i

		System.out.print("���� �� : ");
		System.out.println(Arrays.toString(n));
	}

	// ���ڿ��� �迭���� ������������ ����
	public void strSort() {
		String[] n = new String[] { "fgs", "ghwer", "sowg", "jyes", "�޼ҵ�", "Ŭ����", "juhyeon", "ellen", "352", "61235",
				"1235" };
		String temp = "";
		System.out.println("���ڿ� ���� �� : "+Arrays.toString(n));
		
		for (int i = 0; i < n.length - 1; i++) {
			for(int j = i+1; j<n.length; j++) {
				if(n[i].compareTo(n[j])>0) {
					temp = n[i];
					n[i] = n[j];
					n[j] = temp;
				}// end of if
			}// for j
		} // for i
		System.out.println("���ڿ� ���� �� : "+Arrays.toString(n));
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
		
		Student temp = null; // ��ü�ϱ� �ݵ�� �ʱⰪ null
		
		for(int i = 0; i<n.length-1; i++) { // ����
			for(int j = i+1; j<n.length; j++) { // �񱳴��
				int result = Objects.compare(n[i], n[j], new StudentComp());
				if(result>0) { // a���� b ���� 0���� ũ�� b�� �� �۴ٴ� �ǹ̴ϱ� b�� ������ (swap)
					temp = n[i];
					n[i] = n[j];
					n[j] = temp;
				} // if
			} // j
		} // i
		
		for(int i=0; i<n.length; i++) {
			System.out.println(n[i]);
		} // ���پ� ��µǵ���
		
		
	}

	public static void main(String[] args) {
		SortExam se = new SortExam();
//		se.numberSort();
//		se.strSort();
		se.objSort();

	}

}
