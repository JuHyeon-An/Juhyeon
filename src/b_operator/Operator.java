/*
 * �ۼ����� : 2019.11
 * �ۼ��� : ajh
 * ���� �����ڿ� ���� ����
 */
package b_operator;

public class Operator {
	Operator(){
		// ������ ������
		System.out.println("12%5 => "+ (12%5));
		
		// ������ �����ڿ� 3�� ������
		int n = 122;
		
		String r = (n%2==0)? "¦��" : "Ȧ��";
		System.out.println(n+" ==> "+r);
		
		// ���� ������
		// ��ġ/��ġ
		int a = 10;
		int b = 10;
		
		a++; // a = a+1
		++b;
		System.out.println(a+","+b);
		
		int c = a++;
		int d = ++b;
		
		System.out.println(c+","+d);
		System.out.println(a+","+b);
		
		String name = "����";
		String irum = "����";
		String irum2 = new String("����"); // �޸𸮿� "��"�� �ִ��� ������ �˻� �� �ϰ� ������ ���� ����
		
		System.out.println(name==irum);
		System.out.println(name==irum2);
				
		// ���� ���ڿ������� �ٸ� �ּҸ� �����ϸ� �ٸ� ���ڿ��� �ν��ϰ� �ȴ�.
		// ex) �Ѵ� "��" ������ �����ϴ� �ּҰ� �ٸ�
		
		System.out.println(name.equals(irum2));
		System.out.println(name.equals(irum));
		
		
		
	}
	public static void main(String[] args) {
		new Operator();
	}
}
	