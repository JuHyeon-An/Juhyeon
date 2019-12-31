package h_api;

public class SubstringAndStringBuilder {

	public static void main(String[] args) {
		String str = "0123456789";
		System.out.println(str.substring(3,6)); // 3��°���� 6��°����
	
		StringBuilder sb = new StringBuilder();
		
		sb.append("JAVA ");
		sb.append("Juhyeon ");
		System.out.println(sb.toString());
		
		sb.insert(4, 2);
		sb.insert(13, " yon"); //index13 ��ġ �ڿ� ����
		System.out.println(sb.toString());
		
		sb.setCharAt(0, 'H'); // index 1�� H�� ����
		System.out.println(sb.toString());
		
		sb.replace(0, 4, "Java"); // index0���� 4������ ���� ���ڿ��� ��ü
		System.out.println(sb.toString());
		
		sb.delete(1, 3); // index1���� 3���� ����
		int length = sb.length(); // �� ���� �� ���
		System.out.println("�� ���� �� (���� ����) : "+length);
		
		String result = sb.toString();
		System.out.println(result);
		
	}
	
}
