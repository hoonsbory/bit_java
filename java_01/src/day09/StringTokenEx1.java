package day09;

import java.util.StringTokenizer;

class StringTokenEx1 {
	public static void print(String z , String b) {
	StringTokenizer st2 = new StringTokenizer(z,b);
	StringBuffer a = new StringBuffer();
	while (st2.hasMoreTokens()) {
		String token = st2.nextToken();
		for(int i = 0; i <token.length()-1; i++) {
			if(i ==0) {
				
				a.append(token.charAt(i));
			}
			a.append("*");
		}
		a.append(" ");
		
	}
	System.out.println(a);
	}
//	StringTokenizer st;

//	public StringTokenEx1(String str) {
//		System.out.println("str : " + str);
//		st = new StringTokenizer(str);
//	}

	//public StringTokenEx1(String str, String delim) {
	//	st = new StringTokenizer(str, delim);
		
	//	System.out.println("str :" + str);
		
	//}

	//public static void print() {
		
		//System.out.println("Token count :" + st.countTokens());
		
	//	System.out.println("-------------------------------------------------------------");
		
	//}
	public static void main(String[] args) {
		
		print("홍길동  / 이진동  /   김재훈  / 박철", "/ ");
		//StringTokenEx1 st1 = new StringTokenEx1("Happy day");
		//st1.print();
		
//		StringTokenizer st2 = new StringTokenizer("      홍길동 / 이순신/     김유신    /박철 ","/ ");
//		StringBuffer a = new StringBuffer();
//		while (st2.hasMoreTokens()) {
//			String token = st2.nextToken();
//			for(int i = 0; i <token.length()-1; i++) {
//				if(i ==0) {
//					
//					a.append(token.charAt(i));
//				}
//				a.append("*");
//			}
//			a.append(" ");
//			
//		}
//		System.out.println(a);
		
	}
	
}
