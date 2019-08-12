package day13;

import java.util.Calendar;
import java.util.Formatter;

//포맷 쓰는법.  책 208페이지
//포매터는 정보들을 포맷을 유지하면서 파일에 기록하고 싶을 때 쓰임.
public class Test01 {

	public static void main(String[] args)  throws Exception{ //예외는 JVM에게 떠넘긴다는 뜻. 

		Calendar c = Calendar.getInstance(); // 뉴로 객체생성이 안됨. 겟인스턴스로 생성.
		System.out.println(c);
		String date = String.format("현재 시간은 %tk시 : %tM분 : %tS초 입니다%n", c, c, c);
		System.out.println(date);

		String f = String.format("%f", Math.PI);
		System.out.println(f);
		System.out.printf("%f%n", Math.PI);
		System.out.println("=================================================================");
		StringBuffer sb = new StringBuffer();
		//Formatter fm = new Formatter(sb);
		 Formatter fm = new Formatter("sss.txt"); //sss라는 텍스트파일에 가서 기록을 한다는 뜻
		 //버퍼에 한번에 모았다가 처리하는 기능
		fm.format("현재 시간은 %tk시 : %tM분 : %tS초 입니다%n", c, c, c);
		// sb.append(fm);
		fm.format("%f%n", Math.PI);
		System.out.println(sb);
		fm.flush(); //flush 버퍼에 있는 데이터들은 파일에 기록해줘 라는 뜻.
		//로그 파일 만들 때 많이 쓰임.
		//버퍼에 있는 모든 데이터는 sss라는 텍스트 파일에 기록됨.
		System.out.println("main end");
	}

}
