package e_class;

public class StaticExam {

	public static void main(String[] args) {
		Account2 p = new Account2();
		p.prn();
		p.withdraw(500);
		
		Account2 m = new Account2();
		m.prn();
		m.withdraw(1000);
		
		p.prn();
		
		Account2 c1 = new Account2();
		c1.prn();
		c1.deposit(5000);
		
		p.prn();
		
		}
		
	}
	
