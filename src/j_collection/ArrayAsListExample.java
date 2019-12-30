package j_collection;

import java.util.Arrays;
import java.util.List;

public class ArrayAsListExample {
	
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student(1234, "±èÀÚ¹Ù"),
				new Student(12345, "¾ÈÁÖÇö"),
				new Student(234, "È«±æµ¿")
				);
		
//		for (int intArray : list) {
//			System.out.println(intArray);
//		}
//	
//		List<String> list2 = Arrays.asList("È«±æµ¿", "¾ÈÁÖÇö", "±èÀÚ¹Ù");
//		
//		for (String str : list2) {
//			System.out.println(str);
//		}
//	}
}
}


