package day04;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {

		System.out.println("알파벳 아스키 코드 값 확인");

		char b = 'a';
		char a = 'A';

		for (int i = 0; i < 26; i++) { // 포는 단지 반복일뿐이다. 직접적인 값은ㅇ ㅏ님
			System.out.println(a + " : " + (int) a++ + " , " + b + " : " + (int) b++);

		}

		char ch = 'A';
		char s = ch;
		if (65 <= ch && ch <= 90) {

			System.out.printf("대문자를 소문자로 변경 : %c%n", ch + 32);

		} else
			System.out.println("대문자를 입력해주십시오 : " + s);

		Scanner v = new Scanner(System.in);
		System.out.println("문자열을 입력하세요");
		String msg = v.nextLine();

		for (int i = 0; i < msg.length(); i++) { //메시지 변수에 렝스를 걸어줘서 내가 적은 만큼만 변환.
			char ch2 = msg.charAt(i); // 메세지주소에서 몇번쨰 문자를 찾아오라는뜻. 

			char q = (ch2 >= 'A' && ch2 <= 'Z') ? (char) (ch2 + 32) : ch2; // 차는 인트로 자동캐스팅
			System.out.print(q);
		
		}
		//과제 소문자를 대문자로
		//대문자를 소문자로.
	}
}
