package day23;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class test4 {
	public static void main(String[] args) {
		String filename = "data.obj";
		FileInputStream fos = null;
		ObjectInputStream oos = null;
		
		
		try {
			fos = new FileInputStream(filename); //파일인풋으로 데티어파일 읽어오고
			oos = new ObjectInputStream(fos); //읽어온 파일은 오브젝트인풋에 넣고
			String name = (String) oos.readObject(); //스트링객체는 스트링 타입에 데이트 객체는 데이트타입에 넣어준다.
			Date date = (Date) oos.readObject();  //아까 스트링을 먼저넣었기 때문에 스트링부터 불러와야함. 순서가 중요함.
			System.out.println(name + date);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
		try {
			if(fos != null) fos.close();
			if(oos != null) oos.close();
		} catch (Exception e2) {
		}	
		}
	
	System.out.println("======main end=======");
	}
	public static void main2(String[] args) {
		String filename = "data.obj";
		FileOutputStream fis = null;
		ObjectOutputStream oos = null;
		
		
		try {
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
		try {
			if(fis != null) fis.close();
			if(oos != null) oos.close();
		} catch (Exception e2) {
		}	
		}
	
	
	}
}
