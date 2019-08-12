package day17;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class test03 {
	public static void main(String[] args) {

		//List list = new Vector(); // 오브젝트 타입이라 모든 데이터를 넣을 수 있다.
		List list = new ArrayList(); // 오브젝트 타입이라 모든 데이터를 넣을 수 있다. 그 대신 다운캐스팅을 해야 핸들링가능.
		list.add("hello");
		list.add("java");
		list.add(200);
		list.add(new Date());

		System.out.println(list);
		System.out.println(list.get(1)); // 겟으로 원하는 인덱스의 정보를 ㄹ출력

		for (int i = 0; i < list.size(); i++) { // size는 length느낌
			System.out.println(list.get(i));
		}
	}
}
