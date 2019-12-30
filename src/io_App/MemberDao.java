package io_App;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
	String fileName = "member.dat";

	public List<MemberVo> search(MemberSearch ms) {
		List<MemberVo> list = new ArrayList<>();
		// member.dat 에 있는 자료들을 읽어 list에 추가한 후 반환
		try {
			InputStream is = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(is); // VO 객체를 읽을 수 있는 클래스
			String find = ms.findStr.getText(); 
			// Membersearch를 매개변수로 받아 가져온 이유 => 텍스트필드 사용하기 위해 (UI단만 가져와도 됨)
			
			List<MemberVo> temp = (List) ois.readObject();
			for(MemberVo vo : temp) {
				if(vo.equals(find)) {
					list.add(vo);
				}
			}
			
		} catch (Exception ex) {
			list = null;
		}
		return list;
	}
	
	public boolean insert(MemberVo vo) { // 매개변수 MemberVo타입
		boolean b = true;
		
//		 파일의 정보를 읽어서 메모리에 적재
//		매개변수로 입력된 vo를 메모리에 추가
//		해당 내용을 다시 파일에 저장
		
		try {
			InputStream is = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(is);
			List<MemberVo> list = (List)ois.readObject();
			list.add(vo); // 매개변수에 있는 값을 추가한다
			ois.close();
			is.close();
			
			OutputStream os = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(list);
			oos.flush();
			oos.close();
			os.close();
			
		}catch(Exception ex) {
			b = false; // 오류 발생하면 false 후 return
		}finally { // 오류가 없으면 true
			return b;
		}
	}
	
	public MemberVo search(String findmId) { // 메소드 중복선언
		MemberVo vo = null;
		List<MemberVo> list;
		
		try {
			InputStream is = new FileInputStream(fileName);
//			"FileInputStream is = " 도 괜찮음. 다만 다형화시키기 위하여 부모인 InputStream에 담은 것
			ObjectInputStream ois = new ObjectInputStream(is);
//			ObjectInputStream의 매개변수 타입이 InputStream
			list = (List)ois.readObject();
			for(MemberVo v : list) {
				if(v.getmId().equals(findmId)) {
					vo = v;
					break;
				}
			}
			ois.close();
			is.close(); // close 반드시!!!
			
		}catch(Exception ex) {
			vo = null;
		}finally {
			return vo;
		}
	}
	
	public boolean modify(MemberVo vo) {
		boolean b = true;
		try {
			int index = -1;
			InputStream is = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(is);
			List<MemberVo> list = (List)ois.readObject();
			
			for(int i = 0; i<list.size(); i++) {
				MemberVo v = list.get(i);
				if(v.getmId().equals(vo.getmId())) {
					list.set(i, vo); // 수정될값 vo로 대체
					index = i;
					break;
				}
			}
			
			ois.close(); // InputStream 닫고
			is.close();
			
			if(index == -1) b = false;
//			데이터 찾았으면 i 가 index로 들어갈 것이고,
//			못 찾았으면 index 가 -1로 남아있을 것

			else { // 메모리에만 수정된 데이터를 파일에 저장
				OutputStream os = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(os);
				oos.writeObject(list);
				oos.flush();
				oos.close();
				os.close();
			}
			
		}catch(Exception ex) {
			b=false;
		}finally {
			return b;
		}
	}
	
	public boolean delete(String mId) {
		boolean b = true;
		try {
			int index = -1;
			InputStream is = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(is);
			List<MemberVo> list = (List)ois.readObject();
//			메모리에 적재하는 과정
			
			for (int i = 0; i < list.size(); i++) {
				MemberVo v = list.get(i);
				if(v.getmId().equals(mId)) {
					index = i;
					list.remove(index);
					break;
				}
			}
			
			ois.close();
			is.close();
			
			if(index >= 0) {
			
			OutputStream os = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(list);
			oos.flush();
			oos.close();
			os.close();
			
			} else b = false; // index가 -1인 경우
			
		}catch(Exception ex) {
			b = false;
			ex.printStackTrace();
		}finally {
			return b;
		}
	}
	
}
