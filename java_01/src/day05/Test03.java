package day05;

import java.util.Arrays;

public class Test03 {

	public static void main(String[] args) {

		String msg = "Hello JAVA!";
		String msg2 = "hi sql";

		// char[] c = {'h', 'e', 'l'};

		char[] c = new char[msg.length()];
		for (int i = 0; i < msg.length(); i++) {
			c[i] = msg.charAt(i);

			
		}// 포문은 전체가 아닌 일부를 바꾸고 싶을때
		
		char[] cc = msg.toCharArray(); //toCharArray로 한번에 문자열을 차타입으로 바꿈.전체를 바꿀때 편할듯
		
		char[] cc2 = msg2.toCharArray(); //toCharArray로 한번에 문자열을 차타입으로 바꿈.전체를 바꿀때 편할듯
		//배열을 선언과 동시에 문자열을 차타입으로 바꾸는 명령으로 초기화.
		
		cc[0] = 'Q'; 
		String ne = new String(cc); //char의 배열을 문자열로 형변환하는 코드. "" 필요없음. 차의 배열은 곧 문자열
		
		System.out.println(msg);
		System.out.println(Arrays.toString(c));
		System.out.println(Arrays.toString(cc));
		System.out.println(Arrays.toString(cc2));
		System.out.println(ne);

	}

}
