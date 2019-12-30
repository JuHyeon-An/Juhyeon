package h_api;

import java.util.Arrays;

public class MemberExam {

	public static void main(String[] args) {
		Member original = new Member("blue", "hong", "1234", 20, true);
		
		Member cloned = original.getMember();
		
		System.out.println("복제된 객체의 필드값");
		System.out.println("id : "+cloned.id);
		System.out.println("name : "+cloned.name);
		System.out.println("password : "+cloned.password);
		System.out.println("age : "+cloned.age);
		System.out.println("adult : "+cloned.adult);
		
		cloned.scores[0] = 100;
		
		System.out.println(Arrays.toString(original.scores));
		System.out.println(Arrays.toString(cloned.scores));
	
		cloned.car.model = "소나타";

		System.out.println(original.car.model);
		System.out.println(cloned.car.model);
		
		
	}

}
