package j_collection;

import java.util.Arrays;
import java.util.List;

public class ArrayAsListExample {
	
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student(1234, "���ڹ�"),
				new Student(12345, "������"),
				new Student(234, "ȫ�浿")
				);
		
//		for (int intArray : list) {
//			System.out.println(intArray);
//		}
//	
//		List<String> list2 = Arrays.asList("ȫ�浿", "������", "���ڹ�");
//		
//		for (String str : list2) {
//			System.out.println(str);
//		}
//	}
}
}


