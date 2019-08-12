package day18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayListEx {
	public static void main(String[] args) {
//		String[] name = new String[100]; 구식
//		int index = 0;
		String[] name = {"dfsd", "sdfds", "dsfds", "dsfsd"};
		System.out.println(Arrays.toString(name)); //얘는 주소를 찍음   리스트는 알아서 투스트링해서 나옴.
		Arrays.sort(name);
		System.out.println(Arrays.toString(name));
		
		List<String> list = new ArrayList<String>();
		list.add("신재훈");
		list.add("신재후");
		list.add("신재호");
		list.add("신재현");
		list.add("신재홍");
		
		System.out.println(list);
		Collections.sort(list); //collect sort 수행
		System.out.println(list);
		
		List<String> list2 = new ArrayList<String>(list.subList(1, 4)); //1번째 인덱스부터 4-1 = 3개
		System.out.println(list2);
		
		Object[] obj = list.toArray(); 
		System.out.println(Arrays.toString(obj)); //오브젝트 타입
		
		String[] obj2 = new String[list.size()];
		list.toArray(obj2);
		System.out.println(Arrays.toString(obj2)); //스트링 타입

		String[] sss = {"111","999","777","555","888","333"};
		List<String> sslist = new ArrayList<String>(Arrays.asList(sss)); //asList로 스트링배열을 넣어버림
		System.out.println(sslist);
		
		System.out.println("================List 다루기 ==============================");

		System.out.println(list.contains("신재훈")); //불리언 타입의 콘테인즈 . 이런 스트링이 잇냐? 라는 뜻
		
		for(int i =0; i<list.size(); i++) {
			System.out.println(list.get(i).charAt(0)+"**");
		}
		for(String data : list) {
			System.out.print(data.charAt(0)+"**");
		}
		System.out.println();
		
		Iterator<String> i = list.iterator(); //순회를 돈다. 
		while(i.hasNext()) { //hasnext 데이터가 있는 동안
			String data = i.next(); //데이터를 하나하나 data에 넣는다. 
			if(data.equals("신재훈")) {
				System.out.println("신재훈 삭제완료");
				i.remove();
			}
		}
		System.out.println(list);
	}
}
