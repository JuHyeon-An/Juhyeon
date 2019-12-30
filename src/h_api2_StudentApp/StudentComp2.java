package h_api2_StudentApp;

import java.util.Comparator;

public class StudentComp2 implements Comparator<Student>{ // 이 클래스에서 비교할 수 있는 유형은 Student 타입으로 고정하겠다
	
	@Override
	public int compare(Student s1, Student s2) {
			return s1.score - s2.score;
		
		
/* <Student> 를 추가하지 않았을 경우, 오브젝트를 모두 Student 타입으로 캐스팅해줘야하는 불편함이 생긴다.
 public class StudentComp implements Comparator{
 
 @Override
 public int compare(Object o1, Object o2){
 	Student s1 = (Student)o1;
 	Student s2 = (Student)o2;
 	return s1.score - s2.score;
 	}
 }
 */

	}
}
