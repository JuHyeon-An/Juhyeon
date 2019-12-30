
package j_collection;

import java.util.*;

import MemberAndProductApp.MemberVo;

public class HashSetExam {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		// HashSet<String> set = new HashSet<String>();
		// l �ڽİ�ü�� �߰��� ������� �߰��� ���� ����. ����ϱ� ���ؼ��� casting �ݵ�� �ʿ�

		set.add("Java");
		set.add("JDBC");
		set.add("Servelet/JSP");
		set.add("Java");
		set.add("myBATIS");
		set.add("JAVA"); // java �ҹ��� �ΰ�, �빮�� 1��

		int size = set.size();
		System.out.println("�� ��ü�� : " + size);

		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			String element = iterator.next();
			System.out.println("\t" + element);
		}

		System.out.println("----------------------------");
		for (String element : set) {
			System.out.println(element);
		} // l ���� for������

		System.out.println("----------------------------");

		set.remove("JDBC");
		set.remove("myBATIS");

		System.out.println("���� �� size : " + set.size());
		iterator = set.iterator();
		while (iterator.hasNext()) {
			String element = iterator.next();
			System.out.println("\t" + element);
		}
		
		set.clear();
		if(set.isEmpty()) System.out.println("�ڷᰡ ����ֽ��ϴ�");
		System.out.println("-------------------------------------------");
		
		// ------------------------------------------
		Set<MemberVo> memberSet = new HashSet<MemberVo>();
		memberSet.add(new MemberVo("a001", "1111", "hong", "010-1234")); 
		memberSet.add(new MemberVo("a002", "1111", "hong", "010-1234"));
		memberSet.add(new MemberVo("a002", "1111", "hong", "010-0000"));
		
		memberSet.add(new MemberVo("a002", "2222", "kim", "010-1234"));
		
		System.out.println("memberSet size : "+memberSet.size()); // 3�Ǹ� ����
		System.out.println("-------------------------------------------");
		
		Iterator<MemberVo> iter2 = memberSet.iterator();
		while(iter2.hasNext()) {
			MemberVo vo = iter2.next();
			System.out.print(vo); // toString �������̵� �س������� �����Ƿ� �׳� ���
		}
		
		MemberVo delVo = new MemberVo("a002", "1111", "hong", "010-0000");
		memberSet.remove(delVo);
		
		
		System.out.println("-------------------------------------------");
		for(MemberVo vo : memberSet) { // memberSet�� ������ �ִ°��� �ϳ��� �����
			System.out.print(vo);
		}
		
	}

}
