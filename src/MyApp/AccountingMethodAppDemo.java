package MyApp;

public class AccountingMethodAppDemo {

	 static double valueOfSupply;
	 static double vatRate;
	 double expenseRate;
	 double vat = getVAT();

	AccountingMethodAppDemo(){
		
		valueOfSupply = 9000.0;
		vatRate = 0.1;
		expenseRate = 0.3;
		
		double total = valueOfSupply + getVAT();
		double expense = valueOfSupply * expenseRate;
		double income = valueOfSupply - expense;
		double div1 = income * 0.5;
		double div2 = income * 0.3;
		double div3 = income * 0.2;
		
		System.out.println("Value of supply : " + valueOfSupply);
		System.out.println("VAT : " + getVAT());
		System.out.println("Total : " + total);
		System.out.println("Expense : " + expense);
		System.out.println("Income : " + income);
		System.out.println("div1 : " + div1);
		System.out.println("div2 : " + div2);
		System.out.println("div3 : " + div3);
	}
	
	public static double getVAT() {
		return valueOfSupply * vatRate;
	}
	
	public static void main(String[] args) {
		new AccountingMethodAppDemo();

	}


}
