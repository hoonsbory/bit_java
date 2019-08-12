package day17;

import java.util.ArrayList;import java.util.Date;
import java.util.List;

public class test04 {
	public static void main(String[] args) {

		List<String> list = new ArrayList<String>(); //제너릭을 이용해 스트링으로 관리함.
		list.add("hello");
		list.add("java");
		//list.add(new Date) 스트링 타입아니라 못들어감
		
		for(String data:list) {
			System.out.println(data.toUpperCase());
		}
 	}
}
