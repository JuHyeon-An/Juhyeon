package d_array;

public class Exam8 {

	int[][] array = new int[5][5];
	int sum = 0;
	int max = array[0][0];
	int min = 200;
	int rowMax = 0;
	

	Exam8() {
		// 정수형 2차원배열을 5행 5열을 만들어 100~200 사이의 임의의 정수값을 Math.random()을 사용하여 대입
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = (int) (Math.random() * 101) + 100;

				// 1) 배열 전체 출력 (5행 5열)
				System.out.print(array[i][j] + "  ");

				// 2) 전체 값들의 합계
				sum += array[i][j];

				// 3) 전체 최대값
				if (array[i][j] > max) {
					max = array[i][j];
				}

				// 4) 전체 최소값
				if (array[i][j] < min) {
					min = array[i][j];
				}

			}
			System.out.println();
		}

		System.out.println("----------------");
		System.out.println("합계 : " + sum);
		System.out.println("----------------");
		System.out.println("전체 최대값 : " + max);
		System.out.println("전체 최소값 : " + min);
		System.out.println();

		// 5) 각 행의 최대값

		for (int j = 0; j < array.length; j++) {
			rowMax = 0;
			for (int i = 0; i < array[0].length; i++) {
				if (array[j][i] > rowMax)
					rowMax = array[j][i];
			}
			System.out.println((j + 1) + "행 최대값 : " + rowMax);
		}
	}

	
	public static void main(String[] args) {
		new Exam8();

	}

}
