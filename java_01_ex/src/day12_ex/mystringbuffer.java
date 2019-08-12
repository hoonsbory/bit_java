package day12_ex;

import java.util.StringTokenizer;



public class mystringbuffer {
	
	
	
	public static void print(String str, String str2) {
		StringTokenizer st2 = new StringTokenizer(str,str2);
		StringBuffer a = new StringBuffer();
		while (st2.hasMoreTokens()) {
			String token = st2.nextToken();
			for(int i = 0; i <token.length()-1; i++) {
				if(i == 0) {
					a.append(token.charAt(i));
				}
				a.append("*");
			}
			a.append(" ");
			
		}
		System.out.println(a);
		
	}
	public static void main(String[] args) {
				print(" 홍길동 / 이순신/김유신 /박철 ","/, ");
	}
}
