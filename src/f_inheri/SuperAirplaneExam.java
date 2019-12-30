// fly 실행됐을때 부모가 실행됐는지 본인메소드가 실행됐는지 확인

package f_inheri;

public class SuperAirplaneExam {

	public static void main(String[] args) {

		SuperAirplane s = new SuperAirplane(50); // 자식만 호출
		s.takeoff(); // 이륙
		s.fly(); // 일반비행
		s.flymode = SuperAirplane.SUPERSONIC;
		s.fly(); // supersonic mode
		s.flymode = SuperAirplane.NORMAL;
		s.fly(); // normal일때는 부모
		s.land();
		
	}

}
