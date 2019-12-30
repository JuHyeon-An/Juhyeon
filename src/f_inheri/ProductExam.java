//1) Radio Ŭ������ Video Ŭ������ ����ȯ�� �ȵ��� �����ϴ� �ڵ带 �ۼ� �Ͻÿ�.
//2) Radio, Video, TV Ŭ������ Product Ŭ������ ����ȯ�� �ɼ� ������ �����ϴ� �ڵ带 �ۼ� �Ͻÿ�.

package f_inheri;

public class ProductExam {

	public static void m1(Product p) {
		System.out.println(p.getProductName());
	}
	
	public static void main(String[] args) {

		Product p = new Radio();
		Product p2 = new Video();
		Product p3 = new TV();
		
		m1(p);
		m1(p2);
		m1(p3);
		
		
		if (p instanceof Video) {
			System.out.println("Radio�� Video�� ����ȯ ����");
		}else System.out.println("Radio�� Video�� ����ȯ �Ұ���");
		
		if (p2 instanceof Radio) {
			System.out.println("Video�� Radio�� ����ȯ ����");
		}else System.out.println("Video�� Radio�� ����ȯ �Ұ���");

		if (p instanceof Radio) {
			System.out.println("Radio�� Product Ŭ���� Ÿ������ ����ȯ ����");
		} else
			System.out.println("����ȯ �Ұ���");

		if (p2 instanceof Video) {
			System.out.println("Video�� Product Ŭ���� Ÿ������ ����ȯ ����");
		} else
			System.out.println("����ȯ �Ұ���");

		if (p3 instanceof TV) {
			System.out.println("TV�� Product Ŭ���� Ÿ������ ����ȯ ����");
		} else
			System.out.println("����ȯ �Ұ���");
	}
}
