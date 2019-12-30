package MyApp;

public class AccountingAppArray {
	public static void main(String[] args) {
		
	
		double valueOfSupply = Double.parseDouble(args[0]);
		double vatRate = 0.1;
		double expenseRate = 0.3;
		double vat = valueOfSupply * vatRate;
		double total = valueOfSupply + vat;
		double expense = valueOfSupply * expenseRate;
		double income = valueOfSupply - expense;
		
		double[] rate = new double[3];
		
		rate[0] = 0.5;
		rate[1] = 0.3;
		rate[2] = 0.2;
				
		for(int i=0; i<rate.length; i++) {
			System.out.println(income*rate[i]);
		}		
		
		double rate1 = 0.5;
		double rate2 = 0.3;
		double rate3 = 0.2;
		
		double div1 = income * rate1;
		double div2 = income * rate2;
		double div3 = income * rate3;
		
		System.out.println("Value of supply : " + valueOfSupply);
		System.out.println("VAT : " + vat);
		System.out.println("Total : " + total);
		System.out.println("Expense : " + expense);
		System.out.println("Income : " + income);
		System.out.println("Income : " + div1);
		System.out.println("Income : " + div2);
		System.out.println("Income : " + div3);
		
		
	}
}
