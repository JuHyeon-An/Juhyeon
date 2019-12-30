package j_collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExam {

	
	//<String, Integer>
	public void test1() {
		Map<String, Integer> map = new HashMap<String, Integer>(); // 다형화
//		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("hong", 90);
		map.put("lee",  80);
		map.put("park", 50);
		map.put("kim",  70);
		map.put("choi", 40);
		
		System.out.println("size : "+map.size());
		
//		키값으로 value 출력 (키값을 알고 있는 경우)
		System.out.println(map.get("lee")); //80 
		
//		키셋으로
		Set<String> set = map.keySet();
//		Set set = map.keySet();
		
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			int value = map.get(key); // map에서 key에 해당하는 value값을 가지고 와라
			System.out.println(key + " : " + value);
			
			
		}
		System.out.println("---------------------------------------------------");
		
//		Map.Entry 타입으로 값을 가져오기
		Set<Map.Entry<String, Integer>> set2 = map.entrySet(); // 원래 Set 구조
		Iterator<Map.Entry<String, Integer>> iter2 = set2.iterator();
		while (iter2.hasNext()) {
			Map.Entry<String, Integer> entry = iter2.next();
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
		
		map.put("choi", 99);
		System.out.println("수정 : "+map.get("choi"));
		
		map.remove("choi");
		
		System.out.println("--------------------------------------------------");
//		how 1 (keySet)
		Set <String> set3 = map.keySet();
		
		Iterator<String> iter3 = set3.iterator();
		while(iter3.hasNext()) {
			String key = iter3.next();
			int value = map.get(key);
			if(key.equals("lee")) {
				iter3.remove();
			}
			System.out.println(key + " : "+value);
		}
		
		System.out.println("-----------------------------------------------------");
//		how 2 (Map.Entry)
		
		Set<Map.Entry<String, Integer>> set4 = map.entrySet();
		Iterator<Map.Entry<String, Integer>> iter4 = set4.iterator();
		while(iter4.hasNext()) {
			Map.Entry<String, Integer> entry = iter4.next();
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
	}
	
//	key값의 Student 타입인 경우 
//	보통은 value 값이 매개변수 클래스 타입
	public void test2() {
		Map<Student, String> map = new HashMap<Student, String>();
		
		
		System.out.println("----------------추가 후-------------------");
//		추가
		map.put(new Student(100, "hong"), "010-1111-1111");
		map.put(new Student(200, "kim"), "010-2222-2222");
		map.put(new Student(300, "gang"), "010-123-1234");
		
		prn(map);
		
		System.out.println("----------------수정 후-------------------");
//		수정
		map.put(new Student(300, "gang"), "010-7123-1234");
		prn(map);
		
		
		System.out.println("----------------삭제 후-------------------");
//		삭제
		map.remove(new Student(300, "gang"));
		prn(map);
	}
	
	public void prn(Map<Student, String> map){
		Set<Student> set = map.keySet();
		Iterator<Student> iter = set.iterator();
		while(iter.hasNext()) {
			Student key = iter.next();
			String value = map.get(key);
			System.out.println(key + ">>>" + value);
		}
	}
	
	public void prn2(Map<Integer, Student> map) {
		Set<Integer> set = map.keySet();
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext()) {
			int key = iter.next();
			Student value = map.get(key);
			System.out.println(key + ">>>" + value);
		}
	}
	
//	value값이 Student type인 경우
	public void test3() {
		Map<Integer, Student> map = new HashMap<Integer, Student>();
		
//		추가
		map.put(201901001, new Student(201901001, "홍씨"));
		map.put(201901002, new Student(201901002, "박씨"));
		map.put(201901003, new Student(201901003, "김씨"));
		map.put(201901004, new Student(201901004, "최씨"));
		map.put(201901005, new Student(201901004, "최씨"));
		
		prn2(map);
		
//		박씨의 이름을 김씨로 수정
		System.out.println("박씨의 이름을 김씨로 수정 -----------------");
		map.put(201901002, new Student(201901002, "김씨"));
		prn2(map);
		
//		홍씨를 삭제
		System.out.println("홍씨를 삭제--------------------------");
		map.remove(201901001);
		
//		최종 결과를 출력
		System.out.println("최종 결과를 출력-----------------------");
		prn2(map);
		
		
		
	}
	
	public static void main(String[] args) {

		MapExam exam = new MapExam();
		exam.test1();
		exam.test2();
		exam.test3();
	}

}
