package homework_comparator;

import java.util.Comparator;

public class BoardComparator implements Comparator <BoardVo>{

	@Override // ��¥ ��������
	public int compare(BoardVo d1, BoardVo d2) {
		int r = 0;
		if(d1 == null || d2 == null) { // ���� �ϳ��� ���� ������
			r=0; // 0 ���� �ָ� �ڸ��� �ٲ��� ����
		} else {
			r = d2.getmDate().compareTo(d1.getmDate());
		}
		return r;
			
		
		
			
//		String a = d1.mDate;
//		String b = d2.mDate;
//		int r = 0;
//
//		if (a.compareTo(b) > 0)
//			r = -1;
//		else if (a.compareTo(b) < 0)
//			r = 1;
//		else
//			r = 0;
//		return r;
	}

}