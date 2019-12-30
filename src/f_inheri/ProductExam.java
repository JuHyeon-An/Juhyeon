//1) Radio 클래스와 Video 클래스는 형변환이 안됨을 증명하는 코드를 작성 하시오.
//2) Radio, Video, TV 클래스는 Product 클래스로 형변환이 될수 있음을 증명하는 코드를 작성 하시오.

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
			System.out.println("Radio는 Video로 형변환 가능");
		}else System.out.println("Radio는 Video로 형변환 불가능");
		
		if (p2 instanceof Radio) {
			System.out.println("Video는 Radio로 형변환 가능");
		}else System.out.println("Video는 Radio로 형변환 불가능");

		if (p instanceof Radio) {
			System.out.println("Radio는 Product 클래스 타입으로 형변환 가능");
		} else
			System.out.println("형변환 불가능");

		if (p2 instanceof Video) {
			System.out.println("Video는 Product 클래스 타입으로 형변환 가능");
		} else
			System.out.println("형변환 불가능");

		if (p3 instanceof TV) {
			System.out.println("TV는 Product 클래스 타입으로 형변환 가능");
		} else
			System.out.println("형변환 불가능");
	}
}
