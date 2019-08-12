package day20;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class test03 {
	public static void main(String[] args) {
			Properties p = new Properties();
			
			try {
				p.load(new FileInputStream("c://lib//dbinfo.txt")); //파일에 있는거 다 등록됨. 겟으로 다 읽어옴
				
				String url = p.getProperty("url");  //파일에 있는 url 정보 가져옴  구분자는 = , : 로 하면된다.
				System.out.println(url);
				
				String dri = p.getProperty("driver");
				System.out.println(dri);
				
				p.setProperty("jdk", "1.8");  //셋으로 입력		
				p.setProperty("oraclever", "11g");
				p.setProperty("tomcatver", "9");
				
				p.storeToXML(new FileOutputStream("data.xml"),"DB Info"); // p에 입력된 정보들을 xml파일로 저장. storeToXML
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				
			}
	}
}
