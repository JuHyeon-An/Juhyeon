// fly ��������� �θ� ����ƴ��� ���θ޼ҵ尡 ����ƴ��� Ȯ��

package f_inheri;

public class SuperAirplaneExam {

	public static void main(String[] args) {

		SuperAirplane s = new SuperAirplane(50); // �ڽĸ� ȣ��
		s.takeoff(); // �̷�
		s.fly(); // �Ϲݺ���
		s.flymode = SuperAirplane.SUPERSONIC;
		s.fly(); // supersonic mode
		s.flymode = SuperAirplane.NORMAL;
		s.fly(); // normal�϶��� �θ�
		s.land();
		
	}

}
