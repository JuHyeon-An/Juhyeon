/*
 ����1) ��ȯ�� Exam1.java
1. �� ������ ���� �޾� �հ踦 ��ȯ�ϴ� �޼ҵ� ���� (Sum)
2. �� ����(x, y) �� ���޹޾� x~y������ �հ踦 ���Ͽ� ����(sum2)
3. ����, ���ΰ��� �Ǽ������� ���޹޾� �簢���� ���̸� ����Ͽ� ����
(sum3)
4. ������ ���� �ϳ� ���޹޾� �������� �ϳ��� ���ڿ��� ����� ����
(gugudan)
 */

package e_class;

public class Exam1 {

	int x, y;
	double a,b;
	
	int sum(int x,int y) {
		this.x = x;
		this.y = y;
		
		return x+y;
	}
	
	int sum2(int x, int y) {
		int sum = 0;
		this.x = x;
		this.y = y;
		
		for (this.x = x; x <= y; x++) {
			sum += x;
		}
		return sum;
	}

	double sum3(double a, double b) {
		this.a = a;
		this.a = b;
		
		return (a*b);
	}
	
	void gugudan(int a) {
		for (int i = 1; i <= 9; i++) {
			System.out.println(a + "x" + i + "=" + (a * i));
		}
	}
	
	String gugudan2(int a) {
		String r = "";
		for (int i = 1; i <= 9; i++) {
			r += a + "x" + i + "=" + (a * i);
			r += "\n"; // �������Ѽ� ����ϱ�
		}
		return r;
	}
	
	public static void main(String[] args) {
		Exam1 e1 = new Exam1();
		
		int r1 = e1.sum(-20,30);
		System.out.println("�� ���� �� : "+r1);
		
		int r2 = e1.sum2(2, 9);
		System.out.println("�հ� : "+r2);
		System.out.println(e1.sum2(3, 5));
		System.out.println("�簢���� ���� : "+e1.sum3(20, 30));
		System.out.println("void Ÿ������ -----------");
		e1.gugudan(3);
		
		String r3 = e1.gugudan2(6);
		System.out.println("return Ÿ������----------");
		System.out.println(r3);
			
		}
	
	}

