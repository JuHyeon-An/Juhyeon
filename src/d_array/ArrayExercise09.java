package d_array;

import java.util.Scanner;

public class ArrayExercise09 {

	ArrayExercise09() {

		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		Scanner scan = new Scanner(System.in);

		int max = 0;
		int min = 100;
		int sum = 0;
		double avg = 0.0;

		while (run) {
			System.out.println("------------------------------------");
			System.out.println("1. �л��� | 2. �����Է� | 3. ��������Ʈ | 4. �м� | 5. ����");
			System.out.println("------------------------------------");
			System.out.print("���� > ");

			int selectNo = scan.nextInt();
			switch (selectNo) {
			case 1:
				System.out.print("�л��� > ");
				studentNum = scan.nextInt();
				scores = new int[studentNum];
				break;
			case 2:
				for (int i = 0; i < studentNum; i++) {
					System.out.print("scores[" + i + "] > ");
					scores[i] = scan.nextInt();
				}
				break;
			case 3:
				for (int i = 0; i < studentNum; i++) {
					System.out.println("scores[" + i + "] > " + scores[i]);
				}
				break;
			case 4:
				for (int i = 0; i < studentNum; i++) {
					if (scores[i] > max) {
						max = scores[i];
					}
					if (scores[i] < min) {
						min = scores[i];
					}
					sum += scores[i];

				}
				avg = (double)sum / studentNum;
				System.out.println("�ְ� ���� : " + max);
				System.out.println("�õ� ���� : " + min);
				System.out.println("���� : "+sum);
				System.out.println("��� ���� : " + avg);
				break;
				
			case 5:
				run = false;
				break;

			}// end of switch
		}// end of while
		System.out.println("���α׷��� �����մϴ�.");

	}// end of constructor

	public static void main(String[] args) {

		new ArrayExercise09();
	}

}
