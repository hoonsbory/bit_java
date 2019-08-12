package day19;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class test02 {
public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();   //map가 서치속도가 훨씬 빠름 배열보다. 정렬하려면 TreeMap으로
		map.put("java01", "1234");
		map.put("java02", "1234");
		map.put("java02", "1235"); //이름이 중복이라 뒤에 놈으로 덮어씌워짐.  키값이라서.
		map.put("admin", "admin");
		map.put("test01", "test");
		
		for (int i = 0; i < 30; i++) {
			map.put("test"+i, (int)(Math.random()*3)+"00");   //패스워드가 계속 바뀜
		}
		System.out.println(map);  //순서 랜덤

		System.out.println(map.get("admin")); //admin의 패스워드 출력.  다른 배열은 포문으로 찾아야할텐데 맵은 겟으로 바로 찾아버림.
		//admin 키값에 해당하는 벨류값을 가져오는 것임.
		System.out.println(map.get("java02"));
		System.out.println(map.get("java09")); //java09라는 이름의 사용자가 없어서 null이 출력됨
		System.out.println(map.get("test5"));
		System.out.println("==================================================");

		
		Set<String> keynames = map.keySet();
		
		Iterator<String> it = keynames.iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			System.out.println("ID : " + key + "PW : " + map.get(key));  //get(key)로 해당 아이디의 패스워드를 같이 출력
		}
		//System.out.println("등록된 계정 => "+keynames);  //key이름만 출력해주는것. 셋구조로 출력.
}
}
