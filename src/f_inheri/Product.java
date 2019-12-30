package f_inheri;

public class Product {

	public String getProductName() {
		return "product";
	}

	public static void main(String[] args) {
		Product pr = new Radio();
		Product pr2 = new Video();
		Product pr3 = new TV();
		
		System.out.println(pr.getProductName());
		System.out.println(pr2.getProductName());
		System.out.println(pr3.getProductName());
	}

}
