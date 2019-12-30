package j_collection;

import java.text.MessageFormat;

public class Student {

	int sno;
	String name;
//	학번과 이름이 동일하면 똑같은 객체로 생각
	
	public Student(int sno, String name) {
		this.sno = sno;
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean r = false;

//		sno와 name은 자식객체에서 확장한 필드이므로 obj.sno 이렇게 바로 호출할 수 없다
//		=> Stdent 로 캐스팅 필요
		if (obj instanceof Student) { // obj가 Student 클래스로 만들어져있을 경우에만.
//			무조건 캐스팅하다가 Exception 나올 가능성 있으니까
			Student std = (Student) obj;
			if (sno == std.sno && name.equals(std.name)) {
				r = true;
			} else {
				r = false;
			}
		}
		return r;
	}

	@Override
	public int hashCode() {
		int code = sno + name.hashCode();
//		동일한 학번 : 무결성이 깨짐 (학번 자체를 해쉬코드 값으로 가지고 가도 괜찮음. 중복되지 않는 값이므로)
		return code;
	}

	@Override
	public String toString() {
		String mf = MessageFormat.format("{0} -- {1}", sno, name);
		return mf;
	}
	
	
	
}
