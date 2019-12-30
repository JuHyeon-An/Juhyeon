package j_collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExam {

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		
		list.add("1"); //0
		list.add("2"); //1
		list.add("3"); //2
		list.add("4"); //3
		list.add("5"); //4
		list.add(4, "��");
		
		int size = list.size(); // 6
		
		for (int i = 0; i < size; i++) {
			String str = list.get(i);
			System.out.println(i +" : "+str);
		}
		System.out.println("---------------------------------");
		System.out.println("�� ��ü �� : "+size);
		System.out.println();
		
		String two = list.get(1); // 2
		System.out.println("1 :"+ two);
		
		for (int i = 0; i < list.size(); i++) {
			String a = list.get(i);
			System.out.println(i + " : "+a);
		}
		
		System.out.println();
		
		list.remove(1); // 2 ����� (�ε��� 1�� ��)
		list.remove(1); // 3 ����� (�� ���� �ε��� 1�� ��)
		list.remove("4"); // 4 �����
		
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(i +" : "+str);
		}
		
		
		
		
	}

}
