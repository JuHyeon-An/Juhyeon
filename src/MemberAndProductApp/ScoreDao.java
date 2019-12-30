package MemberAndProductApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ScoreDao {

	Map<String, List<ScoreVo>> map;
	
	public ScoreDao(Map<String, List<ScoreVo>> map) {
		this.map = map;

	}
	
	public boolean insert(ScoreVo vo){
		boolean result = true;
		List<ScoreVo> list = new ArrayList<ScoreVo>();

		try {
			String key = vo.getSno();
			if (map.containsKey(key)) { // key�� �����ϴ���
				list = map.get(key); // Ű�� �ش��ϴ� value�� ������
				list.add(vo);
				
			} else { // key�� ���� ���
				list.add(vo);
				map.put(key, list); // Ű�� ���⶧���� ���Ӱ� �߰�
			}
		} catch (Exception ex) {
			result = false;
//			���� �� ��� �ϳ��� ������ ����� false ����
		}
		return result;
	}
	
	public boolean update(String key, int index, ScoreVo vo) {
		boolean b = true;
		
		try {
		  List<ScoreVo> list = map.get(key);
		  list.set(index, vo); // ���� �Է��� vo�� ����
		}catch(Exception ex) {
			b=false;
		}
		return b;
	}
	
	public boolean delete(String sno, int index) {
		boolean b = true;
		
		try {
			List<ScoreVo> list = map.get(sno);
			list.remove(index);
		}catch(Exception ex){
			b = false;
		}
		
		
		return b;
	}
	
	public Map<String, List<ScoreVo>> list(String findStr) {
		
		Map<String, List<ScoreVo>> newMap = 
				new HashMap<String, List<ScoreVo>>();
		
		Set<String> set = map.keySet();
		Iterator<String> iter = set.iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			if (key.indexOf(findStr) >= 0) {
				newMap.put(key, map.get(key));
//				�˻��� ���Ե� ���ο� �����Ͱ� newMap�� ����
			}
		}
		return newMap;
	}
}
