package h_api;

import java.util.Objects;


public class CompareExam {

	public static void main(String[] args) {
		Student s1 = new Student(1);
		Student s2 = new Student(1);
		Student s3 = new Student(2);
		
		int result = Objects.compare(s1, s2, new StudentComp());
		System.out.println(result);
	
	}

}
