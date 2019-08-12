package day23;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class test03 {
	public static void main(String[] args) {
		String filename = "data.obj";
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		
		try {
			fos = new FileOutputStream(filename);
			oos = new ObjectOutputStream(fos);
			String name = "홍길덩";
			Date d = new Date();
			oos.writeObject(name);
			oos.flush();
			oos.writeObject(d);
			oos.flush();
			System.out.println("파일에 저장되었습니다!");
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
