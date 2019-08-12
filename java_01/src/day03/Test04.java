package day03;

import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) {

		
		Scanner scan = new Scanner(System.in);
		int month;
		do {
		System.out.println("******* 명령 선택   ********");
		System.out.println("1. insert(등록)\n");
		System.out.println("2. delete(삭제)\n");
		System.out.println("3. update(수정)\n");
		System.out.println("4. quit(종료)\n");
		System.out.println("***********************");
		System.out.println("수행할 명령을 선택하세요");
		System.out.println("1,2,3,4중 선택하세요");
		
		month = scan.nextInt(); //string으로 변환시 ""만 추가해주면됨
		
		
		
		
		String res = "";
		
		switch(month)
		{
		
		case 1:
			
		
					res ="등록을 완료했습니다."; break; //break가 없으면 밑으로 내려가서 그 값으로 바뀜.

					
		
		case 2:
					res = "삭제 완료"; break;
		
		case 3:
					res ="수정완료"; break;
					
		case 4:
			
			break;
	
		default :
					res = "1,2,3,4번 중에 입력하세요"; 
					
					
		}
		if(month!=4);{
		System.out.println(res);
		}
		}while(month !=4);
		
		
		
		
	
		
	}
		

}
