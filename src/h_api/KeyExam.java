package h_api;

import java.util.HashMap;

public class KeyExam {

	public static void main(String[] args) {
		HashMap<Key, String> map = new HashMap<Key, String>();
		
		map.put(new Key(1), "������");
		map.put(new Key(2), "ȫ�浿");
		
		map.put(new Key(1), "������");
		
		String value = map.get(new Key(1));
		// ��ü�� �����Ǹ� ��ü�� �����ϰ� ������ �� �ִ� �ؽ��ڵ尪�� �����µ�,
		// new�� ������ �ؽ��ڵ� ���� �޶���.
		System.out.println(value);
	}
	
}
