package h_api2_StudentApp;

import java.util.Comparator;

public class StudentComp2 implements Comparator<Student>{ // �� Ŭ�������� ���� �� �ִ� ������ Student Ÿ������ �����ϰڴ�
	
	@Override
	public int compare(Student s1, Student s2) {
			return s1.score - s2.score;
		
		
/* <Student> �� �߰����� �ʾ��� ���, ������Ʈ�� ��� Student Ÿ������ ĳ����������ϴ� �������� �����.
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
