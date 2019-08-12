package day20;

import java.util.Iterator;
import java.util.Properties;

public class test02 {
public static void main(String[] args) {
	
	Properties p = new Properties();
	p.setProperty("java01", "1231");
	p.setProperty("java02", "1232");
	p.setProperty("java03", "1233");
	p.setProperty("java04", "1234");
	p.setProperty("java05", "1235");
	
	System.out.println(p.getProperty("java01"));  //겟으로 그 키값을 찾아서  벨류값 출력함.
	
	Iterator it =  p.keySet().iterator();
	while (it.hasNext()) {
		String key = (String) it.next();
		System.out.println(key + " : " + p.getProperty(key));
	}
}
}
