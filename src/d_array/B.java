/*
 * ������ ������ ���� ���� �׽�Ʈ
 * A.java, e_class.C.java
 */

package d_array;

public class B {

	B(){
		A a = new A();
		a.f1 = 1; // (o) public type
		a.f2 = 2; // (o) default type (package type)
//		a.f3 = 1; // (x) private type
	}	
}
