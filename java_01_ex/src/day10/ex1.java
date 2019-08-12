package day10;

import java.util.Arrays;

public class ex1 {

	public static String result(String str) {
		String b = "";
		for(int i= str.length()-1; i>=0; i--) {
			b += str.charAt(i);
		}
		return b;
		}
	public static void main(String[] args) {
		
		System.out.println(result("Java Programming"));
	}
}
