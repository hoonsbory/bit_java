package day15_ex;

import util.MyUtil;
import static util.MyUtil.rightPad;
public class test01 {
	public static void main(String[] args) {
		System.out.println(util.MyUtil.rightPad("java",10,'#'));
	//만약 레프트패드 메소드가 스테틱메소드가 아니라면 
		//임포트 후에 MYUtil을 뉴키워드로 객체생성해준 후 사용해야한다.
		MyUtil u = new MyUtil();
		String s = u.leftPad("java",10,'#');
		
		System.out.println(s);
		s = u.rightPad("sdfsd", 123, '@');
		System.out.println(s);
		
	}
  
}
