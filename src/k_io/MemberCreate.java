package k_io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class MemberCreate {

	public static void main(String[] args) throws Exception{

		// 1) member.dat 파일에 직렬화된 MemberVo 객체를 추가
		List<MemberVo> list = new ArrayList<MemberVo>();

		// sample data insert
		for (int i = 0; i < 500; i++) {
			MemberVo vo = new MemberVo("no" + i, "pwd" + i, "name" + i, "010-1111-" + i);
			list.add(vo);
		}
		
		OutputStream os = new FileOutputStream("member.dat");
//		자식개체 만들어서 부모객체에 대입
//		파일명을 지정해서 outputStream 만들었다
		
		ObjectOutputStream oos = new ObjectOutputStream(os);
		oos.writeObject(list);
		oos.flush();
		oos.close();
		os.close();
	}
}
