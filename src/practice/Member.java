package practice;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Member {

	
	
	public String name;
	public int age;
	public int sno;
	public String eDate;

	Member(String name, int age, int sno, String eDate){
		this.name = name;
		this.age = age;
		this.sno = sno;
		this.eDate = eDate;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member member = (Member)obj;
			return member.name.equals(this.name) && member.age == this.age;
		}else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return name.hashCode()+age;
	}

	@Override
	public String toString() {
		String str = String.format("%4s\t%4d\t%4d\t%4s\n", this.name, this.age, this.sno, this.eDate);
		return str;
	}
	
	
	
}
