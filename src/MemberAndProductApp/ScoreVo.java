package MemberAndProductApp;

public class ScoreVo {

	String sno;
	String mName;
	String exam;
	
	int grade;
	int kor;
	int eng;
	int mat;
	int tot;
	
	double avg;

	public ScoreVo() {} // 매개변수 없는 생성자 (작성 습관)
	
	public ScoreVo(String sno, String mName, String exam, int grade, int kor, int eng, int mat){
		this.sno = sno;
		this.mName = mName;
		this.exam = exam;
		this.grade = grade;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.tot = (kor+eng+mat);
		this.avg = (double)tot/3;
	}
	
	public ScoreVo(String sno, String mName, int grade, int kor, int eng, int mat, int tot, double avg){
		this.sno = sno;
		this.mName = mName;
		this.grade = grade;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.tot = tot;
		this.avg = avg;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean r = false;
		if (obj instanceof ScoreVo) {
			ScoreVo sv = (ScoreVo) obj;
			if (getSno().equals(sv.getSno())) r = true;
		}
		return r;
	}

	@Override
	public int hashCode() {
		int code = sno.hashCode();
		return code;
		
//		return sno.hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	
	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getExam() {
		return exam;
	}

	public void setExam(String exam) {
		this.exam = exam;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}
	
}
