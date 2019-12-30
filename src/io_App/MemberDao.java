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
		// member.dat �� �ִ� �ڷ���� �о� list�� �߰��� �� ��ȯ
		try {
			InputStream is = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(is); // VO ��ü�� ���� �� �ִ� Ŭ����
			String find = ms.findStr.getText(); 
			// Membersearch�� �Ű������� �޾� ������ ���� => �ؽ�Ʈ�ʵ� ����ϱ� ���� (UI�ܸ� �����͵� ��)
			
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
	
	public boolean insert(MemberVo vo) { // �Ű����� MemberVoŸ��
		boolean b = true;
		
//		 ������ ������ �о �޸𸮿� ����
//		�Ű������� �Էµ� vo�� �޸𸮿� �߰�
//		�ش� ������ �ٽ� ���Ͽ� ����
		
		try {
			InputStream is = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(is);
			List<MemberVo> list = (List)ois.readObject();
			list.add(vo); // �Ű������� �ִ� ���� �߰��Ѵ�
			ois.close();
			is.close();
			
			OutputStream os = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(list);
			oos.flush();
			oos.close();
			os.close();
			
		}catch(Exception ex) {
			b = false; // ���� �߻��ϸ� false �� return
		}finally { // ������ ������ true
			return b;
		}
	}
	
	public MemberVo search(String findmId) { // �޼ҵ� �ߺ�����
		MemberVo vo = null;
		List<MemberVo> list;
		
		try {
			InputStream is = new FileInputStream(fileName);
//			"FileInputStream is = " �� ������. �ٸ� ����ȭ��Ű�� ���Ͽ� �θ��� InputStream�� ���� ��
			ObjectInputStream ois = new ObjectInputStream(is);
//			ObjectInputStream�� �Ű����� Ÿ���� InputStream
			list = (List)ois.readObject();
			for(MemberVo v : list) {
				if(v.getmId().equals(findmId)) {
					vo = v;
					break;
				}
			}
			ois.close();
			is.close(); // close �ݵ��!!!
			
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
					list.set(i, vo); // �����ɰ� vo�� ��ü
					index = i;
					break;
				}
			}
			
			ois.close(); // InputStream �ݰ�
			is.close();
			
			if(index == -1) b = false;
//			������ ã������ i �� index�� �� ���̰�,
//			�� ã������ index �� -1�� �������� ��

			else { // �޸𸮿��� ������ �����͸� ���Ͽ� ����
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
//			�޸𸮿� �����ϴ� ����
			
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
			
			} else b = false; // index�� -1�� ���
			
		}catch(Exception ex) {
			b = false;
			ex.printStackTrace();
		}finally {
			return b;
		}
	}
	
}
