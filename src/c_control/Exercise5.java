// ��ø for���� �̿��Ͽ� ������ 4x+5y = 60�� ��� �ظ� ���ؼ� (x, y) ���·� ����غ�����. (x, y�� 10 ������ �ڿ���)

package c_control;

public class Exercise5 {

	public Exercise5() {
		int x=0;
		int y=0;
		
		
		for(x=0; x<=10; x++) {
			for(y=0; y<=10; y++) {
				if(4*x+5*y==60) {
					System.out.printf("(%1d, %1d)", x, y);
				}
				
			}
		}
	}

	public static void main(String[] args) {
		new Exercise5();
	}
}
