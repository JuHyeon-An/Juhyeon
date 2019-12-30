package h_api;

public class Student {
	public int sno;
	public String name;
	public int score;
	
	Student(int sno){
		this.sno = sno;
	}
	
	Student(int sno, String name, int score){
		this.sno = sno;
		this.name = name;
		this.score = score;
	}
	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return sno + " - " + name + " - "+score;
		
	}
	
	
}
