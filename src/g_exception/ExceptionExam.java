package g_exception;

public class ExceptionExam {

	public static void main(String[] args) {
		//NullPointerException
		System.out.println("----------------nullpointer오류-----------------------");
		
		String data = null;
		try {
			System.out.println(data.toString());
			System.out.println("오류가 없는 경우 실행됨");
		} catch(NullPointerException ex2) {
			System.out.println("Null Pointer Error");
			System.out.println(ex2.toString());
		} catch(Exception ex){
			System.out.println("문자열 변수 data에 값이 없음");
		} finally {
			System.out.println("오류 발생과 상관없이 무조건 실행");
		}		
		System.out.println();
		System.out.println("----------------Array Index 첨자오류--------------------------");
		//ArrayIndexOutofBoundsException(첨자오류)
		int[] s = {1,2,3};
		
		try {
			for (int i = 0; i <= 3; i++) {
				System.out.println(s[i]);
			}
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("Array Index 영역 밖 오류");
			ex.printStackTrace();
		} catch (Exception ex2) {
			System.out.println("오류");
		} finally {
			System.out.println("오류 발생과 관계없이 무조건 실행하는 finally");
		}
		System.out.println();
		System.out.println("----------------Number Format 오류-------------------------");
		
		//NumberFormatException
		try {
		data = "123a";
		int su = Integer.parseInt(data); // (o)
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("문자가 들어있습니다");
		} finally {
			System.out.println("오류발생과 관계없이 실행되는 finally");
		}
		
		
		System.out.println("----------------Number Format 오류-------------------------");
		//ClassCastException(형변환 오류)
		try {
		Car myCar = new Car(); // (x)
		SportsCar c = (SportsCar)myCar;
		}catch(Exception ex) {
			System.out.println("형변환 오류 발생");
		}finally {
			System.out.println("끝!");
		}
	}
	
}
