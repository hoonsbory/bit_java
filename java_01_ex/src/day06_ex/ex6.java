package day06_ex;

public class ex6 {

	public static void main(String[] args) {

		String ex = "Java Programming";
		
		
		System.out.println((char)(ex.charAt(2))+""+(char)(ex.charAt(3)));
		int count = 0;
		for(int a =0; a<ex.length(); a++) {
			
			if(ex.charAt(a) == 114 ) {
				count++;
			}
			
			
		}
		System.out.println("r의 갯수는 =" + count);
	}

}
