package day06_ex;

public class ex2  {

	public static void main(String[] args) {

		String sourceString = 
				"everyday we have is one more than we deserve";
				String encodedString = "";
				
				char a;
			
				for(int b = 0; b<sourceString.length(); b++) {
					a = sourceString.charAt(b);
					if('a' <= a && a <='w') {
						encodedString += (char)(a+3);
						
					} else if('x'<= a && a <= 'z') {
						encodedString += (char)(a-23);
						
					}else if(a == ' ') {
						encodedString += a;
						
						
					}
				}
					
				
					
						
				
				// 프로그램을 구현부 시작.	
				// 참고 : 문자 'a'의 정수값은 97이며, 'z'는 122입니다. 
				
				// 프로그램 구현부 끝.
				
				System.out.println("암호화할 문자열 : " + sourceString);
				System.out.println("암호화된 문자열 : " + encodedString);
				
				
			}
}