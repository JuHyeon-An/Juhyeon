
package j_collection;

import java.util.*;

import MemberAndProductApp.MemberVo;

public class HashSetExam {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		// HashSet<String> set = new HashSet<String>();
		// l 자식개체에 추가된 멤버들은 추가할 수가 없다. 사용하기 위해서는 casting 반드시 필요

		set.add("Java");
		set.add("JDBC");
		set.add("Servelet/JSP");
		set.add("Java");
		set.add("myBATIS");
		set.add("JAVA"); // java 소문자 두개, 대문자 1개

		int size = set.size();
		System.out.println("총 객체수 : " + size);

		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			String element = iterator.next();
			System.out.println("\t" + element);
		}

		System.out.println("----------------------------");
		for (String element : set) {
			System.out.println(element);
		} // l 향상된 for문으로

		System.out.println("----------------------------");

		set.remove("JDBC");
		set.remove("myBATIS");

		System.out.println("삭제 후 size : " + set.size());
		iterator = set.iterator();
		while (iterator.hasNext()) {
			String element = iterator.next();
			System.out.println("\t" + element);
		}
		
		set.clear();
		if(set.isEmpty()) System.out.println("자료가 비어있습니다");
		System.out.println("-------------------------------------------");
		
		// ------------------------------------------
		Set<MemberVo> memberSet = new HashSet<MemberVo>();
		memberSet.add(new MemberVo("a001", "1111", "hong", "010-1234")); 
		memberSet.add(new MemberVo("a002", "1111", "hong", "010-1234"));
		memberSet.add(new MemberVo("a002", "1111", "hong", "010-0000"));
		
		memberSet.add(new MemberVo("a002", "2222", "kim", "010-1234"));
		
		System.out.println("memberSet size : "+memberSet.size()); // 3건만 저장
		System.out.println("-------------------------------------------");
		
		Iterator<MemberVo> iter2 = memberSet.iterator();
		while(iter2.hasNext()) {
			MemberVo vo = iter2.next();
			System.out.print(vo); // toString 오버라이딩 해놓은것이 있으므로 그냥 출력
		}
		
		MemberVo delVo = new MemberVo("a002", "1111", "hong", "010-0000");
		memberSet.remove(delVo);
		
		
		System.out.println("-------------------------------------------");
		for(MemberVo vo : memberSet) { // memberSet이 가지고 있는것을 하나씩 끄집어내
			System.out.print(vo);
		}
		
	}

}
