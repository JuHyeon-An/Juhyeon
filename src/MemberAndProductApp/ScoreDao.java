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
			if (map.containsKey(key)) { // key가 존재하는지
				list = map.get(key); // 키에 해당하는 value를 가져옴
				list.add(vo);
				
			} else { // key가 없는 경우
				list.add(vo);
				map.put(key, list); // 키가 없기때문에 새롭게 추가
			}
		} catch (Exception ex) {
			result = false;
//			문장 중 어느 하나라도 오류가 생기면 false 리턴
		}
		return result;
	}
	
	public boolean update(String key, int index, ScoreVo vo) {
		boolean b = true;
		
		try {
		  List<ScoreVo> list = map.get(key);
		  list.set(index, vo); // 새로 입력한 vo로 수정
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
//				검색어 포함된 새로운 데이터가 newMap에 저장
			}
		}
		return newMap;
	}
}
