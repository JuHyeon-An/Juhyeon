package c_control;

public class Lotto {
	// ���� �ѹ��� �����ϴ� �޼ҵ� ���� (process) , ����ϴ� �޼ҵ� ���� (prn)
	// ���� �ѹ� n�� ����Ѵٰ� ���� �� 1) �ʵ忡 ������ �����Ͽ� ����ϴ� ��� 2) return���� ����ϴ� ���

	public int n[] = new int[6]; // �ν��Ͻ��� ���� <=> ������ �� ������� �ǹ�
	int count = 0;

	void process() {
		boolean b = false; // �ߺ����� �ʾҴ� (�ߺ��ƴ� => true)
		this.n[count] = (int)(Math.random() * 45) + 1;
		
		for (int i = 0; i<count; i++) {
			if(n[i] == n[count]) {
				b = true;
			}
		}
		if(!b) {
			prn();
			count++;
		}
		
		// 1�������� 45���� ������
		// this�� ������ ����� ���Ѵ�

	}

	void prn() {
		System.out.println(n[count]);
		// ī��Ʈ �ڽ��� ���� �ٲ�� �� �� (count-- �ϸ� �ڽ��� ���� �ٲ�ϱ� �� �ȴ�)
	}

	public static void main(String[] args) {
		Lotto k = new Lotto();
		int a = 6;
		for (; k.count < a; ) {
			k.process();
		}

		
		
		
	}

}
