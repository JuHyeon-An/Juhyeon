package b_operator;

public class Operator2 {
	Operator2(){
	  int kor = 53;
	  int eng = 90;

	  String result = (kor>=60 && eng>=60)? "�հ��Դϴ�!" : "���հ��Դϴ�";
	  // ������� 60 �̻��̰�, ������� 60 �̻��� �� '�հ�'
	  System.out.println(result);
	  
	  boolean b = (kor>=60)&&(eng>=60);
	  System.out.println(b);
	  
	  String result2 = (kor>=60 || eng>=60)? "\n�հ��Դϴ�!" : "\n���հ��Դϴ�";
	  System.out.println(result2);
	  //������� 60�̻� �̰ų� ������� 60 �̻��̸� '�հ�'
	  
	  boolean b2 = (kor>=60)||(eng>=60);
	  System.out.println(b2);
	  
	}
	
	public static void main(String[] args) {
		new Operator2();
	}
}
