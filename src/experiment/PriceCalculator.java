package experiment;

import javax.swing.JOptionPane;

public class PriceCalculator {
	String country = "";
	double weight = 0;
	int valueOfSupply = 0;

	PriceCalculator() {
		
		String[] countries = { "MY", "SG", "ID", "TH", "US", "JP", "PH", "HK", "TW", "VN", "CN" };
		country = JOptionPane.showInputDialog("Enter country");
		valueOfSupply = Integer.parseInt((JOptionPane.showInputDialog("Enter value of supply")));
		System.out.println("원가 + 마진 : "+((16000/1100)+(valueOfSupply/1100)));
		
		for (int i = 0; i < countries.length; i++) {

			if (country.equals(countries[i])) {
				weight = Double.parseDouble(JOptionPane.showInputDialog("Enter weight"));
				System.out.print("배송요금 : ");
				
				switch (i) {
				case 0:
					myPrice();
					break;
				case 1:
					sgPrice();
					break;
				case 2:
					idPrice();
					break;
				case 3:
					thPrice();
					break;
				case 4:
					usPrice();
					break;
				case 5:
					jpPrice();
					break;
				case 6:
					phPrice();
					break;
				case 7:
					hkPrice();
					break;
				case 8:
					twPrice();
					break;
				case 9:
					vnPrice();
					break;
				case 10:
					cnPrice();
					break;
				default:
					System.out.println("해당 국가는 배송이 불가합니다.");
				}
				
				
				
			}
		}
	}

	public void myPrice() {
		if (weight <= 0.5)
			System.out.println(getMY(0));
		else if (weight <= 1.0)
			System.out.println(getMY(1));
		else if (weight <= 1.5)
			System.out.println(getMY(2));
		else if (weight <= 2.0)
			System.out.println(getMY(3));
		else if (weight <= 2.5)
			System.out.println(getMY(4));
		else if (weight <= 3.0)
			System.out.println(getMY(5));
		else if (weight <= 3.5)
			System.out.println(getMY(6));
		else if (weight <= 4.0)
			System.out.println(getMY(7));
		else if (weight <= 4.5)
			System.out.println(getMY(8));
		else if (weight <= 5.0)
			System.out.println(getMY(9));
		else
			System.out.println("5키로 초과");
	}

	public void sgPrice() {
		if (weight <= 0.5)
			System.out.println(getSG(0));
		else if (weight <= 1.0)
			System.out.println(getSG(1));
		else if (weight <= 1.5)
			System.out.println(getSG(2));
		else if (weight <= 2.0)
			System.out.println(getSG(3));
		else if (weight <= 2.5)
			System.out.println(getSG(4));
		else if (weight <= 3.0)
			System.out.println(getSG(5));
		else if (weight <= 3.5)
			System.out.println(getSG(6));
		else if (weight <= 4.0)
			System.out.println(getSG(7));
		else
			System.out.println("5키로 초과");
	}

	public void idPrice() {
		if (weight <= 0.5)
			System.out.println(getID(0));
		else if (weight <= 1.0)
			System.out.println(getID(1));
		else if (weight <= 1.5)
			System.out.println(getID(2));
		else if (weight <= 2.0)
			System.out.println(getID(3));
		else if (weight <= 2.5)
			System.out.println(getID(4));
		else if (weight <= 3.0)
			System.out.println(getID(5));
		else if (weight <= 3.5)
			System.out.println(getID(6));
		else if (weight <= 4.0)
			System.out.println(getID(7));
		else
			System.out.println("5키로 초과");
	}

	public void thPrice() {
		if (weight <= 0.5)
			System.out.println(getTH(0));
		else if (weight <= 1.0)
			System.out.println(getTH(1));
		else if (weight <= 1.5)
			System.out.println(getTH(2));
		else if (weight <= 2.0)
			System.out.println(getTH(3));
		else if (weight <= 2.5)
			System.out.println(getTH(4));
		else if (weight <= 3.0)
			System.out.println(getTH(5));
		else if (weight <= 3.5)
			System.out.println(getTH(6));
		else if (weight <= 4.0)
			System.out.println(getTH(7));
		else
			System.out.println("5키로 초과");
	}

	public void usPrice() {
		if (weight <= 0.5)
			System.out.println(getSG(0));
		else if (weight <= 1.0)
			System.out.println(getUS(1));
		else if (weight <= 1.5)
			System.out.println(getUS(2));
		else if (weight <= 2.0)
			System.out.println(getUS(3));
		else if (weight <= 2.5)
			System.out.println(getUS(4));
		else if (weight <= 3.0)
			System.out.println(getUS(5));
		else if (weight <= 3.5)
			System.out.println(getUS(6));
		else if (weight <= 4.0)
			System.out.println(getUS(7));
		else
			System.out.println("5키로 초과");
	}

	public void jpPrice() {
		if (weight <= 0.5)
			System.out.println(getJP(0));
		else if (weight <= 1.0)
			System.out.println(getJP(1));
		else if (weight <= 1.5)
			System.out.println(getJP(2));
		else if (weight <= 2.0)
			System.out.println(getJP(3));
		else if (weight <= 2.5)
			System.out.println(getJP(4));
		else if (weight <= 3.0)
			System.out.println(getJP(5));
		else if (weight <= 3.5)
			System.out.println(getJP(6));
		else if (weight <= 4.0)
			System.out.println(getJP(7));
		else
			System.out.println("5키로 초과");
	}

	public void phPrice() {
		if (weight <= 0.5)
			System.out.println(getPH(0));
		else if (weight <= 1.0)
			System.out.println(getPH(1));
		else if (weight <= 1.5)
			System.out.println(getPH(2));
		else if (weight <= 2.0)
			System.out.println(getPH(3));
		else if (weight <= 2.5)
			System.out.println(getPH(4));
		else if (weight <= 3.0)
			System.out.println(getPH(5));
		else if (weight <= 3.5)
			System.out.println(getPH(6));
		else if (weight <= 4.0)
			System.out.println(getPH(7));
		else
			System.out.println("5키로 초과");
	}

	public void hkPrice() {
		if (weight <= 0.5)
			System.out.println(getHK(0));
		else if (weight <= 1.0)
			System.out.println(getHK(1));
		else if (weight <= 1.5)
			System.out.println(getHK(2));
		else if (weight <= 2.0)
			System.out.println(getHK(3));
		else if (weight <= 2.5)
			System.out.println(getHK(4));
		else if (weight <= 3.0)
			System.out.println(getHK(5));
		else if (weight <= 3.5)
			System.out.println(getHK(6));
		else if (weight <= 4.0)
			System.out.println(getHK(7));
		else
			System.out.println("5키로 초과");
	}

	public void twPrice() {
		if (weight <= 0.5)
			System.out.println(getTW(0));
		else if (weight <= 1.0)
			System.out.println(getTW(1));
		else if (weight <= 1.5)
			System.out.println(getTW(2));
		else if (weight <= 2.0)
			System.out.println(getTW(3));
		else if (weight <= 2.5)
			System.out.println(getTW(4));
		else if (weight <= 3.0)
			System.out.println(getTW(5));
		else if (weight <= 3.5)
			System.out.println(getTW(6));
		else if (weight <= 4.0)
			System.out.println(getTW(7));
		else
			System.out.println("5키로 초과");
	}

	public void vnPrice() {
		if (weight <= 0.5)
			System.out.println(getVN(0));
		else if (weight <= 1.0)
			System.out.println(getVN(1));
		else if (weight <= 1.5)
			System.out.println(getVN(2));
		else if (weight <= 2.0)
			System.out.println(getVN(3));
		else if (weight <= 2.5)
			System.out.println(getVN(4));
		else if (weight <= 3.0)
			System.out.println(getVN(5));
		else if (weight <= 3.5)
			System.out.println(getVN(6));
		else if (weight <= 4.0)
			System.out.println(getVN(7));
		else
			System.out.println("5키로 초과");
	}

	public void cnPrice() {
		if (weight <= 0.5)
			System.out.println(getCN(0));
		else if (weight <= 1.0)
			System.out.println(getCN(1));
		else if (weight <= 1.5)
			System.out.println(getCN(2));
		else if (weight <= 2.0)
			System.out.println(getCN(3));
		else if (weight <= 2.5)
			System.out.println(getCN(4));
		else if (weight <= 3.0)
			System.out.println(getCN(5));
		else if (weight <= 3.5)
			System.out.println(getCN(6));
		else if (weight <= 4.0)
			System.out.println(getCN(7));
		else
			System.out.println("5키로 초과");
	}

	


	double getMY(int i) {
		double[] prices = { 9.0, 10.0, 11.5, 13.5, 16.0, 18.5, 21.0, 23.5, 26.0, 28.0 };
		return prices[i];
	}

	double getSG(int i) {
		double[] prices = { 8.5, 11.0, 13.5, 15.5, 16.5, 17.5, 19.0, 19.5, 20.5, 23.5 };
		return prices[i];
	}

	double getID(int i) {
		double[] prices = { 16.5, 24.5, 32.5, 40.5, 48.5, 56.5, 64.0, 72.0, 80.0, 83.0 };
		return prices[i];
	}

	double getTH(int i) {
		double[] prices = { 12.0, 13.5, 16.0, 18.0, 20.0, 21.0, 23.5, 25.5, 27.5, 30.5 };
		return prices[i];
	}

	double getUS(int i) {
		double[] prices = { 14.0, 19.5, 23.0, 47.0, 48.5, 50, 50, 50, 50, 50, 50, 50 };
		return prices[i];
	}

	double getJP(int i) {
		double[] prices = { 9.5, 11.5, 12.5, 13.0, 13.5, 14.0, 15.0, 15.5, 16.0, 19.0 };
		return prices[i];
	}

	double getPH(int i) {
		double[] prices = { 12.5, 18.0, 23.5, 29.0, 35.0, 40.5, 46.0, 51.5, 57.5, 60.5 };
		return prices[i];
	}

	double getHK(int i) {
		double[] prices = { 12.0, 14.0, 16.0, 18.0, 205., 22.0, 23.5, 25.5, 27.0, 30.0 };
		return prices[i];
	}

	double getTW(int i) {
		double[] prices = { 10.0, 11.0, 13.5, 14.5, 15.5, 17.0, 17.5, 20.0, 21.0, 24.0 };
		return prices[i];
	}

	double getVN(int i) {
		double[] prices = { 11.5, 16.0, 21.0, 25.5, 30.0, 35.0, 40.0, 45.0, 49.5, 52.5 };
		return prices[i];
	}

	double getCN(int i) {
		double[] prices = { 10.5, 13.0, 15.0, 18.0, 22.0, 25.0, 28.5, 32.0, 35.0, 38.0 };
		return prices[i];
	}
	public static void main(String[] args) {
		PriceCalculator a = new PriceCalculator();
		
	}
}
