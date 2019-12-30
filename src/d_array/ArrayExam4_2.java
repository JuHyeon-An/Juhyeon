package d_array;

import java.io.IOException;
import java.util.Scanner;

public class ArrayExam4_2 {
	String[] names = new String[10];
	int[][] scores = new int[10][2]; // 학생 10명, 과목 2개
	int count = 0; // 배열에 입력된 자료의 개수
	
	// 무한 루프를 돌면서 메뉴를 출력
	ArrayExam4_2() throws Exception {
		Scanner scan = new Scanner(System.in);
		boolean run = true;

		
		//샘플용 데이터를 배열에 저장
		names[0] = "kim";
		names[1] = "hong";
		names[2] = "park";
		names[3] = "lee";
		scores[0][0] = 80; scores[0][1] = 90;
		scores[1][0] = 70; scores[1][1] = 97;
		scores[2][0] = 60; scores[2][1] = 53;
		scores[3][0] = 50; scores[3][1] = 37;
		
		count = 4;
				
				
		while (run) {
			System.out.println();
			System.out.println("------------------------------------");
			System.out.println("1. 입력 | 2. 수정 | 3. 조회 및 출력 | 4. 종료");
			System.out.println("------------------------------------");
			System.out.print("메뉴 선택 > ");
			
			int menu = scan.nextInt();

			switch (menu) {

			case 1:
				this.input(); // this -> 자기 자신의 메소드 (해당 클래스)
				break;
			case 2:
//				this.modify();
				this.modify2();
				break;
			case 3:
				this.search();
				break;
			case 4:
				run = false;
				break;
			default:
				System.out.println("번호를 다시 입력하세요.");
			} // ----------------------------------------------------------------------switch 끝
		} // --------------------------------------------------------------------------while 끝
		System.out.println("프로그램을 종료합니다.");
	}

	// 학생의 성적 정보를 배열에 입력 (1번)
	public void input() {
		String name="";
		int kor = 0;
		int eng = 0;
		int tot = 0;
		double avg = 0;
		
		Scanner scan = new Scanner(System.in);
		System.out.print("성명 : ");
		name = scan.nextLine();
		System.out.print("국어점수 : ");
		kor = scan.nextInt(); // 국어점수 입력받기
		System.out.print("영어점수 : ");
		eng = scan.nextInt();
		
		tot = kor + eng;
		avg = (double)tot/2;
		System.out.println("총점 : "+tot);
		System.out.println("평균  : "+avg);
		
		names[count] = name;
		scores[count][0] = kor;
		scores[count][1] = eng;
		count++;
		}
		
	// 학생의 성적정보를 수정 (2번)
//	1) 수정할 학생명을 입력받아 검색 (누구꺼 수정?)
//	2) 검색된 정보를 표시 (이름, 성적)
//	3) 수정
//	4) 수정된 데이터를 배열에 입력 / 배열 정보 수정
	
	public void modify() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("성명을 입력하세요 > ");
		String findName = scan.nextLine();
		int tot = 0;
		double avg = 0;

		for (int i = 0; i < count; i++) {

			if (names[i].equals(findName)) {
				tot = scores[i][0] + scores[i][1];
				avg = (double) tot / scores[0].length;
				System.out.println("이름 : " + names[i]);
				System.out.println("국어점수 : " + scores[i][0]);
				System.out.println("영어점수  : " + scores[i][1]);
				System.out.println("총점 : " + tot);
				System.out.println("평균 : " + avg);
			}
			System.out.print("수정할 과목명을 입력하세요 > ");
			String findSub = scan.nextLine();
			System.out.print("점수를 입력하세요 > ");
			int modScore = scan.nextInt();

			if (findSub.equals("국어")) {
				System.out.println("국어점수 " + scores[i][0] + " 점이 " + modScore + " 점 으로 수정됐습니다.");
				scores[i][0] = modScore;
				break;

			} else if (findSub.equals("영어")) {
				System.out.println("영어점수 " + scores[i][1] + " 점이 " + modScore + " 점 으로 수정됐습니다.");
				scores[i][1] = modScore;
				break;
			}else {System.out.println("데이터를 다시 입력하세요.");
					break;}

		}// for 종료

	}

	// 학생 성적 정보를 조회 및 출력 (3번)
	public void search() throws Exception {

		System.out.print("성명을 입력하세요 > ");

		Scanner scan = new Scanner(System.in);
		String findName = scan.nextLine();
		int tot = 0;
		double avg = 0;
		boolean search = true;

		System.out.println("---------------------------");
		System.out.println("\t     성적표");
		System.out.println("---------------------------");
		System.out.println("| 이름 | 국어 | 영어 | 총점 | 평균");

		for (int i = 0; i < count; i++) {
			if (names[i].equals(findName) || findName.equals("")) { // 이름이 일치하거나 공백일때
				// TODO (총점, 평균을 계산하여 출력)
				tot = scores[i][0] + scores[i][1];
				avg = (double) tot / scores[0].length;


				System.out.print(names[i] + "  ");
				System.out.print(scores[i][0] + "  ");
				System.out.print(scores[i][1] + "  ");
				System.out.print(tot + " ");
				System.out.printf("%5.1f", avg);
				System.out.println();
				search = true;
				

			} else
				search = false;
		}
		int key = 0;
		key = System.in.read();
		if (search == false )
			System.out.println("결과를 찾을 수 없습니다.");
	}

	public void modify2() {
		
		Scanner scanner = new Scanner(System.in);
		String findName = "";
		System.out.print("검색할 학생명은 ?  ");
		findName = scanner.nextLine();
		
		
		for (int i = 0; i < count; i++) {
			if (names[i].equals(findName)) {
				System.out.println("성명 : " + names[i]);
				System.out.println("국어 : " + scores[i][0]);
				System.out.println("영어 : " + scores[i][1]);

				System.out.println();
				System.out.println("성적을 수정하세요");
				System.out.print("국어 : ");
				scores[i][0] = scanner.nextInt();

				System.out.print("영어 : ");
				scores[i][1] = scanner.nextInt();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		new ArrayExam4_2();
	}
}