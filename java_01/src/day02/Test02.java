package day02;

import java.util.Date;

public class Test02 {
	public static void main(String[] args) {

		int a = 'a';
		
		char b = 'b';
		
		System.out.println(a);
		System.out.println((int)b);
		
		
		String address = new String("비트캠");
		
		System.out.println(address);
		
		String name = "홍길동";
		
		System.out.println(name);
		
		System.out.println("" + 1 + 1);
		
		System.out.println(1 + 1 + "1");
		
		Date today = new Date();
		
		System.out.println("today's Date : " + today);
		
		System.out.println(2 + 2 + "3");
		
		String bit = 2 + 2+ "5";
		
		System.out.println(bit);
		
		bit = null;
		
		System.out.println(bit);
		
		int z = 'a';
		char x = (char)z;
		System.out.println(x);
		
		String god = "홍길동";
		System.out.println(god.length());
		
		long number = 99999999999999999L;
		System.out.println(number);
		
		int t = 'A';
		
		System.out.println('z' + ":" + (int)'z');
		System.out.println('9' + ":" + (int)'9');
		
		System.out.println(t);
		
		
	
	}
}
