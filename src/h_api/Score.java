package h_api;

public class Score implements Comparable<Score> { // Comparable �̶�� �������̽��� ����
	// * Comparator : �Ű������� �ΰ� . �ܺο� �����ϴ� �ΰ��� ������Ʈ�� ������ ��
	// * Comparable : �ڱ��ڽŰ� another �ٸ� ��ҿ� ��

	int kor;
	
	Score(String kor){
		this.kor = Integer.parseInt(kor); // �Ű������� ���޹��� String�� int�� parsing
	}
	
	Score(int kor){
		this.kor = kor;
	}
	
	@Override
	public int compareTo(Score o) {
		return this.kor - o.kor;
		
	/*	int r = 0;
		if(this.kor>o.kor) r = 1;
		else if(this.kor<o.kor) r = -1;
		else r = 0;
		
		=> r�� ����� �ڸ���ȯ / 0�̳� ������ �ڸ���ȯx
		r�� ���� ���� ������������ ������� �ִ�.
		*/
	}
	
	@Override
	public String toString() { // �����Ƽ���� ����ϱ� ���ϵ��� ��ġ
		return this.kor + "\n";
	}
}
