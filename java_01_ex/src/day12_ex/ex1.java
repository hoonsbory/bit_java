package day12_ex;

public class ex1 {

	
	
	
	public static StringBuilder result(String str) {
	StringBuilder st = new StringBuilder();
	
	for(int i = str.length()-1; i >=0; i--) {
		st.append(str.charAt(i));
	}
	return st;
	
}
	public static void main(String[] args) {
		System.out.println(result("Java Programming"));
		a(2012);
		
	}
	public static  void  a(int a) {
		
		if((a%4)==0) {
			System.out.println("윤년입니다.");
			
		}else {
			System.out.println("윤년이 아닙니다");
		}
		
		
		
	}
	
}

