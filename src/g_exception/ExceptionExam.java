package g_exception;

public class ExceptionExam {

	public static void main(String[] args) {
		//NullPointerException
		System.out.println("----------------nullpointer����-----------------------");
		
		String data = null;
		try {
			System.out.println(data.toString());
			System.out.println("������ ���� ��� �����");
		} catch(NullPointerException ex2) {
			System.out.println("Null Pointer Error");
			System.out.println(ex2.toString());
		} catch(Exception ex){
			System.out.println("���ڿ� ���� data�� ���� ����");
		} finally {
			System.out.println("���� �߻��� ������� ������ ����");
		}		
		System.out.println();
		System.out.println("----------------Array Index ÷�ڿ���--------------------------");
		//ArrayIndexOutofBoundsException(÷�ڿ���)
		int[] s = {1,2,3};
		
		try {
			for (int i = 0; i <= 3; i++) {
				System.out.println(s[i]);
			}
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("Array Index ���� �� ����");
			ex.printStackTrace();
		} catch (Exception ex2) {
			System.out.println("����");
		} finally {
			System.out.println("���� �߻��� ������� ������ �����ϴ� finally");
		}
		System.out.println();
		System.out.println("----------------Number Format ����-------------------------");
		
		//NumberFormatException
		try {
		data = "123a";
		int su = Integer.parseInt(data); // (o)
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("���ڰ� ����ֽ��ϴ�");
		} finally {
			System.out.println("�����߻��� ������� ����Ǵ� finally");
		}
		
		
		System.out.println("----------------Number Format ����-------------------------");
		//ClassCastException(����ȯ ����)
		try {
		Car myCar = new Car(); // (x)
		SportsCar c = (SportsCar)myCar;
		}catch(Exception ex) {
			System.out.println("����ȯ ���� �߻�");
		}finally {
			System.out.println("��!");
		}
	}
	
}
