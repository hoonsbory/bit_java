package day07_ex;

public class efsef {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String str = "bit";
		int size = 6;
		char c = '#';
		
		for(int a=  0; a<str.length(); a++) {
			if(str.length()< size) {
				
				str = c + str;
				
				System.out.println(str);
				
			}
			
			
		}
		
		
	}

}
