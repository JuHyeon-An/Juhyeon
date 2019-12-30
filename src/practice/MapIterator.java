package practice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapIterator {

	public static void main(String[] args) {

		Member member = new Member("juhyeon", 28, 3, "19920315");
		Map<Integer, Member> map = new HashMap<Integer, Member>();
		map.put(1, new Member("juhyeon", 28, 1, "19920315"));
		map.put(2, new Member("juhyeon2", 29, 2, "19920316"));
		map.put(3, new Member("juhyeon3", 30, 3, "19920317"));

		Set<Map.Entry<Integer, Member>> set = map.entrySet();
		Iterator<Map.Entry<Integer, Member>> iter = set.iterator();
		while (iter.hasNext()) {
			Map.Entry<Integer, Member> mapentry = iter.next();
			int key = mapentry.getKey();
			Member value = mapentry.getValue();
			System.out.print(key+"-"+value.toString());
		}
	}
}
