package c_control;

public class SwitchExample4 {

	SwitchExample4() {

	String position = "사장";
	String a = "";
	int i = 2;
	
	switch(position) {

	case "사장":
		a="700만원";
		break;
	case "부장":
		a="500만원";
		break;
	case "과장":
		a="400만원";
		break;
	default :
		a="300만원";
	
		}
	System.out.println(a);
	}
}
