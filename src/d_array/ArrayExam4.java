package d_array;

import java.util.Scanner;

public class ArrayExam4 {

	// �޼ҵ� : ������ ��ȯ�� �޼ҵ��(�Ű�����){...}
	
	public int test2() {
//		���ڿ� 1���� �迭(names)�� ������ ���� 5���� ����
//		������ 2�����迭(s) 5���� ����, ������� ���� (4�� 2�� -> 3, 1)
		
		String[] names = {"Hong", "Kim", "Choi", "Lee", "An", "Park"};
		int[][] s = {
				{96, 29},
				{49, 68},
				{84, 72},
				{60, 62},
				{82, 96},
				{70, 42}
		};
		
		int tot;
		double avg;
		
		
//		�迭�� ù��° �л��� �̸��� ���� �� ����, ����� ���
		System.out.println();
		System.out.println(names[0] +"�� ����� : "+s[0][0]);
		System.out.println(names[0] +"�� ����� : "+s[0][1]);
		
		tot = s[0][0]+s[0][1];
		avg = (double)tot/s[0].length; // �Ҽ��� ���ϵ� �������� double�� �����
		
		System.out.println();
		System.out.println(names[0] +"�� ���� : "+ tot);
		System.out.println(names[0] +"�� ��� : "+ avg);
		
//		����° �л��� ���������� 100���� ����
		s[2][0] = 100;
				
//		����° �л��� �̸��� ������� ���
		System.out.println();
		System.out.println("����° �л��� : "+names[2]);
		System.out.println("����° �л��� ����� : "+s[2][0]);
		System.out.println();
		
		
//		�л����� "Hong"�� ����� ����, ����, ������ ����� ����Ͽ� ���
//		������ "ã�� �����Ͱ� �����ϴ�."
//		�˻�� �Է��Ͽ� �˻��ϰ� �˻��� �����Ϸ��� "quit'�� �Է��ϵ��� ���α׷��� �����Ͻÿ�.
		
		Scanner scanner = new Scanner(System.in);
		String input;
		
		input = "";
		
		while (!input.equals("quit")) {
			System.out.print("�˻��� �̸��� �Է��ϼ��� : ");
			input = scanner.nextLine();
			
			int j = 0;
			int q = -1;
			
			for (j = 0; j < names.length; j++) {
				if (names[j].equals(input)) {
					q = j;
					tot = s[q][0]+s[q][1];
					avg = (double) tot/s[q].length;
					System.out.println(names[q] + "�� " + (q + 1) + "��°�� �ֽ��ϴ�.");
					System.out.println(names[q] + "�� ����� : " + s[q][0] + "��");
					System.out.println(names[q] + "�� ����� : " + s[q][1] + "��");
					System.out.println(names[q] + "�� ���� : " + tot + "��");
					System.out.println(names[q] + "�� ��� : " + avg + "��");
					break; // ���������� �������� break ����
				}
			}
			
			if (input.equals("quit")) {
			}

			if (q == -1 && !input.equals("quit"))
				System.out.println("ã�� �ڷᰡ �����ϴ�.");
			System.out.println();
		}
		System.out.println("�����մϴ�.");		
		
			 
			
		
		
		System.out.println("-------Hong �˻����-------");
		int p = -1; // ��ġ ã�� p�� ���� 0 ���Ͽ��� ��. (�迭 �ε����� ������ �ʰ�)
		for(int i=0; i<names.length; i++)
		if(names[i].equals("Hong")) {
			p = i;
			break;
		}
		if(p==-1) System.out.println("ã�� �����Ͱ� �����ϴ�.");
		else {System.out.println("Hong�� ��ġ : " + p);
		
		int kor = s[p][0];
		int eng = s[p][1];
		int tot2 = kor+eng;
		double avg2 = (double)tot2/s[p].length;
		
		System.out.println(names[p]+"�� �������� :"+kor);
		System.out.println(names[p]+"�� �������� :"+eng);
		System.out.println(names[p]+"�� ���� :"+tot2);
		System.out.println(names[p]+"�� ��� :"+avg2);
		}
		
		
		
		int i=0;
		int max=s[0][0];
		int p2=0;
		
		for(i=0; i<s.length; i++) {
			if(s[i][0]>max) {
				max=s[i][0];
				p2=i;
			}
		}
		System.out.println();
		System.out.println("���� 1�� : "+names[p2]+"\n���� : " + max);
		
		max=s[0][1];
		
		for(i=0; i<s.length; i++) {
			if(s[i][1]>max) {
				max=s[i][1];
				p2=i;
			}
		}
		System.out.println();
		System.out.println("���� 1�� : "+names[p2]+"\n���� : "+max);
		return 0;
	}
	
	public void test1() { // ������ 2���� �迭�� �����ϰ� �ʱⰪ�� 4�� 3���� �����͸� �����Ͻÿ�
		int[][] s = new int[][] { 
			{ 1, 2, 2 },
			{ 3, 10, 4 },
			{ 4, 5, 4 },
			{ 7, 8, 2 }
	};
	
	// �迭�� ���
	System.out.println("��� : "+s.length);
	// ù��°���� ����
	System.out.println("ù��° ���� ���� : "+s[0].length);
	// �ι�°���� ����°���� ����?
	System.out.println("s[1][2] : "+s[1][2]);
	// ù��°���� ������ �հ�
	int hap = s[0][0] + s[0][1] + s[0][2];
	System.out.println("ù��°���� �հ� : "+hap);
	
	// ù��°���� ������ �հ�
	int hap2 = s[0][0] + s[1][0] + s[2][0] + s[3][0];
	System.out.println("ù��°���� �հ� : "+hap2);
	
	
	// ù��°���� �հ�
	int hap4 = 0;
	int b = 0;
	double avg = 0;
	
	for(b=0; b < 4; b++) {
		hap4+=s[b][0];
	}
	System.out.println("ù��°���� �հ�(for��) :"+hap4);
	System.out.println();
	
	// �ι�°���� ���� �� ¦���� ���
	for (int a = 0; a < s[1].length; a++) {
		b = s[1][a];
		if (s[1][a] % 2 == 0) {
			System.out.printf("�ι�°���� ���� �� ¦�� : %2d\n", b);
		}//if�� ����
	}//for�� ����
	System.out.println();
	
	//����°���� ¦���� ����� ���
	double hap3 = 0;
	int count = 0;
	for(int c=0; c < s.length; c++) {
		if (s[c][2] % 2 == 0) {
			hap3 += s[c][2]; // ����°�� ¦����! �հ踦 ���ϱ�.
			count++; // ¦���� ������ ���ϴ� count����
		}
	}
	if(count>0) {
		avg = hap3/count;
	}
	
	System.out.println("¦���� ���� : "+count);
	System.out.println("¦���� �� : "+hap3);
	System.out.printf("¦���� ��� : %3.1f",avg);
	
	}
	
	
	public static void main(String[] args) {
		ArrayExam4 a3 = new ArrayExam4(); // ��ü����
		// �����ڸ� ������� �ʾ����� ����ӽ��� �����ڸ� �����ش�.
//		a3.test1(); // a3�� ������ �ִ� test1�� ȣ��
		// �º��� �ƹ��͵� ��� �Ǵ� ������ void ������. ���ʿ� ��ȯ���� ���� �� �ִ� ������ ��� �ȴ٤�. (��ȯ���� �����ϱ�)
		a3.test2();
	}
	

}
