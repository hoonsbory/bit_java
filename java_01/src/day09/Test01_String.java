package day09;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class Test01_String {

	public static void main(String[] args) {
		//String msg1 = args[0];
		//String msg2  = new String(new char[] {'g', 'd'});
		String msg1 = JOptionPane.showInputDialog("북 정보를 입력하세요 ex) (title/price)"); //입력창출력해서 입력
		//Java programming/23000
		//String msg1 = "Java programming/23000";
		
		
	//	System.out.println(msg1.toUpperCase()); //대문자로 모두 변환. 어퍼케이스 원본은 유지됨
	//	System.out.println(msg1 = msg1.toLowerCase()); //소문자로 모두 변환. 로어케이스 원본까지 바꾸려면 이러케
	//	System.out.println(msg1);
		if(msg1.indexOf("/") == -1) { //msg1 문자열에 슬래쉬가 없으면 -1을 반환하고 이프 조건 충족
			System.out.println("다시입력해요 제발");
			System.out.println("/////슬래쉬 넣으라고 했잖아요 한글 못읽어요?");
			return;
		}
		if(msg1.equals("/")) {
			System.out.println("다시입력해요 제발");
			System.out.println("/////슬래쉬 넣으라고 했더니 슬래쉬만 넣으면 어떻게 해요..");
			return;
		}
		
		String[] data = msg1.split("/" ); //데이터라는 이름의  스트링 배열을 생성. 슬래쉬 기준으로 문자열을 쪼개라 
		System.out.println(msg1);
		System.out.println(Arrays.toString(data));
		
		
		Book b1 = new Book(data[0].trim(), Integer.parseInt(data[1].trim())); //북클래스 객체 생성과 파스인트로 인트타입 형변환
		//트림으로 공백제거!! 트림 무조건 잊지말자
		b1.print();
	}
	

}
