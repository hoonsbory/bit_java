package day09;

public class Test03_String {

	public static void main(String[] args) {

			String msg = "";
			msg = msg + "오늘 날짜는 " + new java.util.Date() +  "입니다";
			//System.out.println(msg);
			
			
			
			String msg2 = "";
			
			//StringBuffer sb = new StringBuffer();  //계속 어펜드로 문자열을 더해줄 수 있다. sb라는 이름의 변수에.
			StringBuilder sb = new StringBuilder();  //얘가 최근에 나온 놈임.
			sb.append("hello   ");
			sb.append(new java.util.Date());
			sb.append("java");
			sb.append("test");
			
		//	msg2 = sb.toString(); //sb는 스트링 버퍼타입이기때문에 투스트링으로 스트링타입 형변환
			msg2 = new String(sb); //스트링버퍼 하나를 매개변수로 갖는 생성자함수로 어레이카피 스트링에 넣어준다
			
			System.out.println(msg2);
			
		
	}	

}
