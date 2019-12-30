package h_api;

public class Score implements Comparable<Score> { // Comparable 이라는 인터페이스를 구현
	// * Comparator : 매개변수가 두개 . 외부에 존재하는 두개의 오브젝트를 가지고 비교
	// * Comparable : 자기자신과 another 다른 요소와 비교

	int kor;
	
	Score(String kor){
		this.kor = Integer.parseInt(kor); // 매개변수로 전달받은 String을 int로 parsing
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
		
		=> r이 양수면 자리교환 / 0이나 음수면 자리교환x
		r의 값에 따라 내림차순으로 만들수도 있다.
		*/
	}
	
	@Override
	public String toString() { // 써드파티에서 출력하기 편하도록 장치
		return this.kor + "\n";
	}
}
