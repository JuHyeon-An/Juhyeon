package j_collection;

import java.text.MessageFormat;

public class Student {

	int sno;
	String name;
//	�й��� �̸��� �����ϸ� �Ȱ��� ��ü�� ����
	
	public Student(int sno, String name) {
		this.sno = sno;
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean r = false;

//		sno�� name�� �ڽİ�ü���� Ȯ���� �ʵ��̹Ƿ� obj.sno �̷��� �ٷ� ȣ���� �� ����
//		=> Stdent �� ĳ���� �ʿ�
		if (obj instanceof Student) { // obj�� Student Ŭ������ ����������� ��쿡��.
//			������ ĳ�����ϴٰ� Exception ���� ���ɼ� �����ϱ�
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
//		������ �й� : ���Ἲ�� ���� (�й� ��ü�� �ؽ��ڵ� ������ ������ ���� ������. �ߺ����� �ʴ� ���̹Ƿ�)
		return code;
	}

	@Override
	public String toString() {
		String mf = MessageFormat.format("{0} -- {1}", sno, name);
		return mf;
	}
	
	
	
}
