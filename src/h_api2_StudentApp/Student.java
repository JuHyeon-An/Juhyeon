package h_api2_StudentApp;

public class Student {
	public int sno;
	public String mName;
	public int score;
	
	
	Student(int sno){
		this.sno = sno;
	}
	
	Student(int sno, String mName, int score){
		this.sno = sno;
		this.mName = mName;
		this.score = score;
	}
	
	
	
	

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getName() {
		return mName;
	}

	public void setName(String name) {
		this.mName = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "                  "+ sno + "\t"+"\t" +score + "\t"+"               " + mName;
		
	}
	
	
}
