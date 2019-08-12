package day23;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Map;
import java.util.Set;

import day21.Book2_Map;

public class booktest {
public static void main(String[] args) {
	String filename = "book";
	FileInputStream fos = null;
	ObjectInputStream oos = null;
	
	
	try {
		fos = new FileInputStream(filename); //파일인풋으로 데티어파일 읽어오고
		oos = new ObjectInputStream(fos); //읽어온 파일은 오브젝트인풋에 넣고
		//Map<K, V> mapname = (Set<Account>) oos.readObject(); //스트링객체는 스트링 타입에 데이트 객체는 데이트타입에 넣어준다.
		//Date date = (Date) oos.readObject();  //아까 스트링을 먼저넣었기 때문에 스트링부터 불러와야함. 순서가 중요함.
		Set<Map<Integer, Book2_Map>> name = (Set<Map<Integer, Book2_Map>>)oos.readObject();
		//System.out.println(name);
		name.forEach(i -> System.out.println(i));
		//name.forEach(i -> System.out.println(i));
	} catch (Exception e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	}finally {
	try {
		if(fos != null) fos.close();
		if(oos != null) oos.close();
	} catch (Exception e2) {
	}	
	}
}
}
