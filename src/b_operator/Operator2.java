package b_operator;

public class Operator2 {
	Operator2(){
	  int kor = 53;
	  int eng = 90;

	  String result = (kor>=60 && eng>=60)? "합격입니다!" : "불합격입니다";
	  // 국어성적이 60 이상이고, 영어성적도 60 이상일 때 '합격'
	  System.out.println(result);
	  
	  boolean b = (kor>=60)&&(eng>=60);
	  System.out.println(b);
	  
	  String result2 = (kor>=60 || eng>=60)? "\n합격입니다!" : "\n불합격입니다";
	  System.out.println(result2);
	  //국어성적이 60이상 이거나 영어성적이 60 이상이면 '합격'
	  
	  boolean b2 = (kor>=60)||(eng>=60);
	  System.out.println(b2);
	  
	}
	
	public static void main(String[] args) {
		new Operator2();
	}
}
