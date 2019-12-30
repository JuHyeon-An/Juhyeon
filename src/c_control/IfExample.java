package c_control;

public class IfExample {
	public static void main(String[] args) {
//		new IfExample(); => 익명개체 (메모리 주소를 알 수 없다)
		IfExample obj = new IfExample(); // 객체를 생성해서 obj에 담아라 => 참조형
//		obj : 클래스가 메모리에 올라간 위치를 가리킨다. (오브젝트명, 인스턴스명)
//		obj는 IfExample이 위치하고 있는 번지수를 담고 있다.

		System.out.println("-------<type1 : 메소드 내에서 직접 if 출력 (if)>--------");
		int k = obj.type1(); // => 출력값
		System.out.println(k); // => return값만 나옴

		System.out.println(obj.type1()); // => 출력값 + return값이 함께 실행됨
//		obj가 가지고 있는 type1 메소드를 실행하고 그 결과를 k에 저장해라
//		변수 k가 int인 이유 : "obj 하단에는 return 정수형변수; 가 있을 것이다" 예상

		System.out.println("-------<type2 : 메소드 내에 리턴값을 가져와서 출력 (else)>--------");
		String m = obj.type2();
//		obj가 가지고 있는 type2를 실행하고 String m에 저장해라
		System.out.println(m);

		System.out.println("-------<type3 : 메소드 내 리턴값 가져와서 출력 (else if)>--------");
		System.out.println(obj.type3()); // 변수 만들지 않고 다이렉트로 바로 출력하기
		char s = obj.type3();
		System.out.println(s + " 입니다.");

		obj.type4();

	}

	int type1() {
		int r = 0;
		int s = 95;
		if (s >= 90) {
			System.out.println("점수가 90점보다 큽니다");
			System.out.println("등급은 A입니다.");
		}
		if (s < 90) {
			System.out.println("점수가 90보다 작습니다.");
			System.out.println("등급은 B입니다.");
		}
		return s;

	}

	String type2() {
		String r = null; // r이 가리키고 있어야 할 주소가 없다
		int s = 80;

		if (s >= 90) {
			r = "90이상입니다";
			r += "\n등급은 A입니다"; // += 안 하고 = 만 하면 앞에 문장은 없어짐 ( r = r + "\nA")
		} else {
			r = "90미만입니다";
			r += "\n등급은 B입니다";
		}

		return r;
	}

	/*
	 * 성적을 if~else if를 사용하여 학점을 구하여 r에 저장하시오. 90이상 A, 80이상 B, 70이상 C , 60이상 D, 미만 F
	 */
	char type3() {
		int s = 100;
		char r = ' '; // 작은 따옴표를 쓸 때에는 반드시 문자가 필요함. (공백)

		if (s >= 90) {
			r = 'A';
		} else if (s >= 80) {
			r = 'B';
//			return r; -> if문에 리턴문장을 여러개 쓸 수 있지만 복잡해서 한번만
		} else if (s >= 70) {
			r = 'C';
			return r;
		} else if (s >= 60) {
			r = 'D';
			return r;
		} else
			r = 'F';
		return r;
	}

	/*
	 * 성적이 0~100 사이일때만 60 이상이면 '합격'60 미만이면 '불합격'을 출력하고, 성적이 범위 밖이면 '성적오류;를 출력하시오.
	 * (중첩 if문 사용) 성적의 범위가 가변적이면 (어떤 때는 5~10, 어떤때는 0.0~5.0) 최소값과 최대값의 변수를 Double에
	 * 담아서 만든다 (리터럴로 가면 나중에 수정하기 힘들다)
	 */

	void type4() {
		int score = 70;
		double min = 0;
		double max = 100;

		String result = "";

		if (score >= min && score <= max) {
			if (score >= 60) {
				result = "합격";
			} else {
				result = "불합격";
			}
		}

		else
			result = "성적오류";

		System.out.println(result);
	}

}
