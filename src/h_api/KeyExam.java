package h_api;

import java.util.HashMap;

public class KeyExam {

	public static void main(String[] args) {
		HashMap<Key, String> map = new HashMap<Key, String>();
		
		map.put(new Key(1), "안주현");
		map.put(new Key(2), "홍길동");
		
		map.put(new Key(1), "일지매");
		
		String value = map.get(new Key(1));
		// 객체가 생성되면 객체가 유일하게 구분할 수 있는 해시코드값을 만들어내는데,
		// new를 만들어내면 해시코드 값이 달라짐.
		System.out.println(value);
	}
	
}
