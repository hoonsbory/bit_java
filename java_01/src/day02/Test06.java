package day02;

import java.util.Scanner;

public class Test06 {


	public static void main(String[] args) {
		int num  = 100;
		System.out.println(++num);
		System.out.println(num);
	
	
	System.out.println(6%4); //나머지를 구하는 연산자 파센트연사자
	
	int x= 100, y = 100;
	System.out.println(x==y);
	
	int score = 99;
	
	boolean result = 0<= score && score <=100; //&두개던 한개던 상관없음
	System.out.println("score 유효성검증 결과\n" + result);
	
	System.out.println(3|4); //비트연산. 쓸 일 없음.
	
	
	System.out.println(4<<2); //000100 >> 010000 왼쪽으로 두자리 옮겨라.
	System.out.println(16>>2); //위와 반대
	
	
	
	Scanner hoon = new Scanner(System.in);
	
	String name = hoon.nextLine();
	System.out.printf("신재훈 본인 확인 완료 :  %s" , name);
	
	
	
	}

}
