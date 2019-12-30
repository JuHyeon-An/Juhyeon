/*
 * 접근자 종류에 따른 접근 테스트
 * d_array.A.java, d_array.B.java
 */

package e_class;

import d_array.A;

public class C {

	C(){
		A a = new A();
		a.f1 = 1; //public type
//		a.f2 = 1; //default type 다른 패키지라서 사용불가
//		a.f3 = 1; //private type
		
	}	
}
