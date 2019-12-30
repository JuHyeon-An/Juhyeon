package c_control;

public class Lotto {
	// 랜덤 넘버를 추출하는 메소드 따로 (process) , 출력하는 메소드 따로 (prn)
	// 랜덤 넘버 n을 출력한다고 했을 때 1) 필드에 변수를 선언하여 사용하는 경우 2) return값을 사용하는 경우

	public int n[] = new int[6]; // 인스턴스형 변수 <=> 정적형 과 상대적인 의미
	int count = 0;

	void process() {
		boolean b = false; // 중복되지 않았다 (중복됐다 => true)
		this.n[count] = (int)(Math.random() * 45) + 1;
		
		for (int i = 0; i<count; i++) {
			if(n[i] == n[count]) {
				b = true;
			}
		}
		if(!b) {
			prn();
			count++;
		}
		
		// 1에서부터 45개의 랜덤수
		// this는 무조건 멤버를 택한다

	}

	void prn() {
		System.out.println(n[count]);
		// 카운트 자신의 값은 바뀌면 안 됨 (count-- 하면 자신의 값이 바뀌니까 안 된다)
	}

	public static void main(String[] args) {
		Lotto k = new Lotto();
		int a = 6;
		for (; k.count < a; ) {
			k.process();
		}

		
		
		
	}

}
