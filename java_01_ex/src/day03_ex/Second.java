package day03_ex;

import java.util.Scanner;

public class Second {

	public static void main(String[] args) {

		
		Scanner grade = new Scanner(System.in);
		
		String gd;
		int jumsu = grade.nextInt();
		if(0> jumsu || jumsu > 100) {
			
			System.out.println("유효하지 않은 정수입니다");
			
			return;
		}
		
		
		gd =   90<= jumsu && jumsu <= 100 ? "A" 
				: (jumsu >=80 ? "B" 
				: (jumsu >=70 ? "C" 
				: (jumsu >=60 ? "D" : "F")));
		

		
		System.out.printf("점수%s" , gd);
		
		
	
	
		
		
	
		
		
	}
}
	

