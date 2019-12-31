package h_api;

public class SubstringAndStringBuilder {

	public static void main(String[] args) {
		String str = "0123456789";
		System.out.println(str.substring(3,6)); // 3번째에서 6번째까지
	
		StringBuilder sb = new StringBuilder();
		
		sb.append("JAVA ");
		sb.append("Juhyeon ");
		System.out.println(sb.toString());
		
		sb.insert(4, 2);
		sb.insert(13, " yon"); //index13 위치 뒤에 삽입
		System.out.println(sb.toString());
		
		sb.setCharAt(0, 'H'); // index 1을 H로 변경
		System.out.println(sb.toString());
		
		sb.replace(0, 4, "Java"); // index0부터 4까지를 다음 문자열로 대체
		System.out.println(sb.toString());
		
		sb.delete(1, 3); // index1부터 3까지 삭제
		int length = sb.length(); // 총 문자 수 얻기
		System.out.println("총 문자 수 (공백 포함) : "+length);
		
		String result = sb.toString();
		System.out.println(result);
		
	}
	
}
