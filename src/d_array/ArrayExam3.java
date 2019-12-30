package d_array;

import java.util.Scanner;

public class ArrayExam3 {

	// 메소드 : 접근자 반환형 메소드명(매개변수){...}
	
	public int test2() {
//		문자열 1차원 배열(names)에 임의의 서명 5개를 대입
//		정수형 2차원배열(s) 5명의 국어, 영어성적을 대입 (4행 2열 -> 3, 1)
		
//		String[] names = new String[] {}; => 이것도 가능
		String[] names = {"An", "Hong", "Kim", "Lee", "Park"};
		int[][] s = {
			{ 62, 39 },
			{ 38, 93 },
			{ 49, 82 },
			{ 97, 81 },
			{ 99, 74 }
		};
		int tot = 0;
		double avg = 0;
		
//		배열의 첫번째 학생의 이름과 성적 및 총점, 평균을 출력
		System.out.println();
		System.out.println(names[0] +"의 국어성적 : "+s[0][0]);
		System.out.println(names[0] +"의 영어성적 : "+s[0][1]);
		
		tot = s[0][0]+s[0][1];
		avg = (double)tot/s[0].length; // 소수점 이하도 나오도록 double형 씌우기
		
		System.out.println();
		System.out.println(names[0] +"의 총점 : "+ tot);
		System.out.println(names[0] +"의 평균 : "+ avg);
		
//		세번째 학생의 국어점수를 100으로 수정
		s[2][0] = 100;
				
//		세번째 학생의 이름과 국어성적을 출력
		System.out.println();
		System.out.println("세번째 학생명 : "+names[2]);
		System.out.println("세번째 학생의 국어성적 : "+s[2][0]);
		System.out.println();
		
		
//		학생명이 "Hong"인 사람의 국어, 영어, 총점과 평균을 계산하여 출력
//		없으면 "찾는 데이터가 없습니다."
//		검색어를 입력하여 검색하고 검색을 중지하려면 "quit'을 입력하도록 프로그램을 수정하시오.
		
		Scanner scanner = new Scanner(System.in);
		
		String input;
		
		boolean run = true;
		input = "";
		int q = -1;
		
		while (!input.equals("quit")) {
			System.out.print("검색어를 입력하세요 : ");
			input = scanner.nextLine();
			if (input.equals("quit")) {
				run = false;}
			int j = 0;
			for (j = 0; j < names.length; j++) {
				if (names[j].equals(input)) {
					q = j;
					System.out.println(names[q] + "는 " + (q + 1) + "번째에 있습니다.");
					System.out.println(names[q]+"의 영어성적 : " + s[q][0]);
					System.out.println(names[q]+"의 국어성적 : " + s[q][1]);
					System.out.println(names[q]+"의 총점 : " + (s[q][0]+s[q][1]));
					System.out.println(names[q]+"의 평균 : " + (s[q][0]+s[q][1])/s[q].length);
					break;

					}
				}
			
			if (q == -1 && !input.equals("quit"))
				System.out.println("찾는 자료가 없습니다.");
				System.out.println();
		}
		System.out.println("종료합니다.");		
		
			 
			
		
		
		System.out.println("-------Hong 검색결과-------");
		int p = -1; // 위치 찾는 p의 값은 0 이하여야 함. (배열 인덱스에 섞이지 않게)
		for(int i=0; i<names.length; i++)
		if(names[i].equals("Hong")) {
			p = i;
			break;
		}
		if(p==-1) System.out.println("찾는 데이터가 없습니다.");
		else {System.out.println("Hong의 위치 : " + p);
		
		int kor = s[p][0];
		int eng = s[p][1];
		int tot2 = kor+eng;
		double avg2 = (double)tot2/s[p].length;
		
		System.out.println(names[p]+"의 국어점수 :"+kor);
		System.out.println(names[p]+"의 영어점수 :"+eng);
		System.out.println(names[p]+"의 총점 :"+tot2);
		System.out.println(names[p]+"의 평균 :"+avg2);
		}
		
		
		
		int i=0;
		int max=s[0][0];
		int p2=0;
		
		for(i=0; i<s.length; i++) {
			if(s[i][0]>max) {
				max=s[i][0];
				p2=i;
			}
		}
		System.out.println();
		System.out.println("국어 1등 : "+names[p2]+"\n점수 : " + max);
		
		max=s[0][1];
		
		for(i=0; i<s.length; i++) {
			if(s[i][1]>max) {
				max=s[i][1];
				p2=i;
			}
		}
		System.out.println();
		System.out.println("영어 1등 : "+names[p2]+"\n점수 : "+max);
		return 0;
	}
	
	public void test1() { // 정수형 2차원 배열을 선언하고 초기값을 4행 3열의 데이터를 대입하시오
		int[][] s = new int[][] { 
			{ 1, 2, 2 },
			{ 3, 10, 4 },
			{ 4, 5, 4 },
			{ 7, 8, 2 }
	};
	
	// 배열의 행수
	System.out.println("행수 : "+s.length);
	// 첫번째행의 열수
	System.out.println("첫번째 행의 열수 : "+s[0].length);
	// 두번째행의 세번째열의 값은?
	System.out.println("s[1][2] : "+s[1][2]);
	// 첫번째행의 값들의 합계
	int hap = s[0][0] + s[0][1] + s[0][2];
	System.out.println("첫번째행의 합계 : "+hap);
	
	// 첫번째열의 값들의 합계
	int hap2 = s[0][0] + s[1][0] + s[2][0] + s[3][0];
	System.out.println("첫번째열의 합계 : "+hap2);
	
	
	// 첫번째열의 합계
	int hap4 = 0;
	int b = 0;
	double avg = 0;
	
	for(b=0; b < 4; b++) {
		hap4+=s[b][0];
	}
	System.out.println("첫번째열의 합계(for문) :"+hap4);
	System.out.println();
	
	// 두번째행의 값들 중 짝수만 출력
	for (int a = 0; a < s[1].length; a++) {
		b = s[1][a];
		if (s[1][a] % 2 == 0) {
			System.out.printf("두번째행의 값들 중 짝수 : %2d\n", b);
		}//if문 종료
	}//for문 종료
	System.out.println();
	
	//세번째열의 짝수의 평균을 출력
	double hap3 = 0;
	int count = 0;
	for(int c=0; c < s.length; c++) {
		if (s[c][2] % 2 == 0) {
			hap3 += s[c][2]; // 세번째열 짝수만! 합계를 구하기.
			count++; // 짝수의 개수를 구하는 count변수
		}
	}
	if(count>0) {
		avg = hap3/count;
	}
	
	System.out.println("짝수의 개수 : "+count);
	System.out.println("짝수의 합 : "+hap3);
	System.out.printf("짝수의 평균 : %3.1f",avg);
	
	}
	
	
	public static void main(String[] args) {
		ArrayExam3 a3 = new ArrayExam3(); // 객체생성
		// 생성자를 기술하지 않았지만 가상머신이 생성자를 빌려준다.
//		a3.test1(); // a3이 가지고 있는 test1을 호출
		// 좌변에 아무것도 없어도 되는 이유는 void 때문에. 왼쪽에 반환값을 담을 수 있는 변수가 없어도 된다ㅏ. (반환값이 없으니까)
		a3.test2();
	}
	

}
