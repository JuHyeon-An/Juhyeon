package d_array;

import java.io.IOException;
import java.util.Scanner;

public class ArrayExam4_2 {
	String[] names = new String[10];
	int[][] scores = new int[10][2]; // �л� 10��, ���� 2��
	int count = 0; // �迭�� �Էµ� �ڷ��� ����
	
	// ���� ������ ���鼭 �޴��� ���
	ArrayExam4_2() throws Exception {
		Scanner scan = new Scanner(System.in);
		boolean run = true;

		
		//���ÿ� �����͸� �迭�� ����
		names[0] = "kim";
		names[1] = "hong";
		names[2] = "park";
		names[3] = "lee";
		scores[0][0] = 80; scores[0][1] = 90;
		scores[1][0] = 70; scores[1][1] = 97;
		scores[2][0] = 60; scores[2][1] = 53;
		scores[3][0] = 50; scores[3][1] = 37;
		
		count = 4;
				
				
		while (run) {
			System.out.println();
			System.out.println("------------------------------------");
			System.out.println("1. �Է� | 2. ���� | 3. ��ȸ �� ��� | 4. ����");
			System.out.println("------------------------------------");
			System.out.print("�޴� ���� > ");
			
			int menu = scan.nextInt();

			switch (menu) {

			case 1:
				this.input(); // this -> �ڱ� �ڽ��� �޼ҵ� (�ش� Ŭ����)
				break;
			case 2:
//				this.modify();
				this.modify2();
				break;
			case 3:
				this.search();
				break;
			case 4:
				run = false;
				break;
			default:
				System.out.println("��ȣ�� �ٽ� �Է��ϼ���.");
			} // ----------------------------------------------------------------------switch ��
		} // --------------------------------------------------------------------------while ��
		System.out.println("���α׷��� �����մϴ�.");
	}

	// �л��� ���� ������ �迭�� �Է� (1��)
	public void input() {
		String name="";
		int kor = 0;
		int eng = 0;
		int tot = 0;
		double avg = 0;
		
		Scanner scan = new Scanner(System.in);
		System.out.print("���� : ");
		name = scan.nextLine();
		System.out.print("�������� : ");
		kor = scan.nextInt(); // �������� �Է¹ޱ�
		System.out.print("�������� : ");
		eng = scan.nextInt();
		
		tot = kor + eng;
		avg = (double)tot/2;
		System.out.println("���� : "+tot);
		System.out.println("���  : "+avg);
		
		names[count] = name;
		scores[count][0] = kor;
		scores[count][1] = eng;
		count++;
		}
		
	// �л��� ���������� ���� (2��)
//	1) ������ �л����� �Է¹޾� �˻� (������ ����?)
//	2) �˻��� ������ ǥ�� (�̸�, ����)
//	3) ����
//	4) ������ �����͸� �迭�� �Է� / �迭 ���� ����
	
	public void modify() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("������ �Է��ϼ��� > ");
		String findName = scan.nextLine();
		int tot = 0;
		double avg = 0;

		for (int i = 0; i < count; i++) {

			if (names[i].equals(findName)) {
				tot = scores[i][0] + scores[i][1];
				avg = (double) tot / scores[0].length;
				System.out.println("�̸� : " + names[i]);
				System.out.println("�������� : " + scores[i][0]);
				System.out.println("��������  : " + scores[i][1]);
				System.out.println("���� : " + tot);
				System.out.println("��� : " + avg);
			}
			System.out.print("������ ������� �Է��ϼ��� > ");
			String findSub = scan.nextLine();
			System.out.print("������ �Է��ϼ��� > ");
			int modScore = scan.nextInt();

			if (findSub.equals("����")) {
				System.out.println("�������� " + scores[i][0] + " ���� " + modScore + " �� ���� �����ƽ��ϴ�.");
				scores[i][0] = modScore;
				break;

			} else if (findSub.equals("����")) {
				System.out.println("�������� " + scores[i][1] + " ���� " + modScore + " �� ���� �����ƽ��ϴ�.");
				scores[i][1] = modScore;
				break;
			}else {System.out.println("�����͸� �ٽ� �Է��ϼ���.");
					break;}

		}// for ����

	}

	// �л� ���� ������ ��ȸ �� ��� (3��)
	public void search() throws Exception {

		System.out.print("������ �Է��ϼ��� > ");

		Scanner scan = new Scanner(System.in);
		String findName = scan.nextLine();
		int tot = 0;
		double avg = 0;
		boolean search = true;

		System.out.println("---------------------------");
		System.out.println("\t     ����ǥ");
		System.out.println("---------------------------");
		System.out.println("| �̸� | ���� | ���� | ���� | ���");

		for (int i = 0; i < count; i++) {
			if (names[i].equals(findName) || findName.equals("")) { // �̸��� ��ġ�ϰų� �����϶�
				// TODO (����, ����� ����Ͽ� ���)
				tot = scores[i][0] + scores[i][1];
				avg = (double) tot / scores[0].length;


				System.out.print(names[i] + "  ");
				System.out.print(scores[i][0] + "  ");
				System.out.print(scores[i][1] + "  ");
				System.out.print(tot + " ");
				System.out.printf("%5.1f", avg);
				System.out.println();
				search = true;
				

			} else
				search = false;
		}
		int key = 0;
		key = System.in.read();
		if (search == false )
			System.out.println("����� ã�� �� �����ϴ�.");
	}

	public void modify2() {
		
		Scanner scanner = new Scanner(System.in);
		String findName = "";
		System.out.print("�˻��� �л����� ?  ");
		findName = scanner.nextLine();
		
		
		for (int i = 0; i < count; i++) {
			if (names[i].equals(findName)) {
				System.out.println("���� : " + names[i]);
				System.out.println("���� : " + scores[i][0]);
				System.out.println("���� : " + scores[i][1]);

				System.out.println();
				System.out.println("������ �����ϼ���");
				System.out.print("���� : ");
				scores[i][0] = scanner.nextInt();

				System.out.print("���� : ");
				scores[i][1] = scanner.nextInt();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		new ArrayExam4_2();
	}
}