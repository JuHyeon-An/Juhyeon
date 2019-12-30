package h_api2_StudentApp;

import java.util.Comparator;

public class StudentComp implements Comparator<Student>{ // 이 클래스에서 비교할 수 있는 유형은 Student 타입으로 고정하겠다
	char flag = 'n'; // flag라는 변수에 n이 들어가면 학번순, s면 성적순
	
	public StudentComp(char flag) {
		this.flag = flag;
	}
	
	@Override
	public int compare(Student s1, Student s2) {
		int result = 0;
		if(flag =='n') {
			result = s1.sno - s2.sno;
		}else {
			result = s1.score - s2.score;
		}
		return result;
			
		
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
