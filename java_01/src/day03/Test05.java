package day03;

import java.util.Scanner;

public class Test05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner grade = new Scanner(System.in);
		String jh = "";
		int test = grade.nextInt();
		
		switch(test/10) //값을 10으로 나눠서 간소화함. 나올 수 있는 숫자가 100개에서 10개로 줄어들음.
		{
		
		case 10:	
		case 9:	
		
			
			
			jh ="A"; break;
			
		case 8:
			
			jh ="B"; break;
			
		case 7:
			
			jh ="C"; break;
			
			default:
				jh = "F";
			
		
		
		
		}
		System.out.println("귀하의 점수는" + jh + "입니다");

	}

}
