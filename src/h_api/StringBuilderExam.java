package h_api;

public class StringBuilderExam {
/*	String�� �ӵ��� StringBuilder�� �ӵ� �� */
	
	
	public StringBuilderExam() {
		//String �ӵ�
		long sTime = 0, eTime = 0;
		String str = "";
		
		sTime = System.nanoTime(); // ���۽ð�
		
		for(int i = 0; i<50000; i++) {
			str += "a";
		}
		
		eTime = System.nanoTime(); // ���ð�
		
		System.out.println("String ó�� �ð� : "+(eTime-sTime));
		
		//StringBuilder �ӵ�
		StringBuilder sb = new StringBuilder(100); // ���� ������ 100��
		sTime = System.nanoTime();
		for(int i = 0; i<50000; i++) {
			sb.append("a");
		}
		eTime = System.nanoTime();
		
		System.out.println("StringBuilder ó�� �ð� : "+(eTime-sTime));
		
		
		
	}
	
	public static void main(String[] args) {
		new StringBuilderExam();
		
		
		
	}

}
