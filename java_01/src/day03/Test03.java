package day03;

import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {
		int jumsu;

		Scanner a = new Scanner(System.in);

		System.out.println("점수를 입력하세요");
		// jumsu = a.nextInt();
		jumsu = Integer.parseInt(a.nextLine()); //키보드로부터 읽은 데이터는 스캐너를 널시켜도 사라지지 않는다.
		//파스인트는 주소를 모르기때문에 클래스로 접근. 내가 직접 뉴 키워드로 메모리에 올린게 아니라 주소가 없기 때문에 클래스로 접근해야함.
		

		

		// 네스트라인을 쓰고 싶으면 변수타입이 인트이기때문에 파스인트로 스트링을 인트로 캐스팅해줘야 함

		/*
		 * if(jumsu > 100) { System.out.println("다시 입력해주십시오."); }
		 * 
		 * if(jumsu >=80) { System.out.println("Pass"); } else {
		 * System.out.println("No Pass"); }
		 */
		a.close();
		a = null;
		
		if (!(jumsu >= 0 && jumsu <= 100)) { //0 이상 100이하가 아닌경우(!) 밑의 메시지 출력
			System.out.println("다시 입력하시오");
			return; //현재 수행중인 함수를 종료하고 호출한 자리로 돌아가는 문장, 메인함수안에서 쓰면 메인함수의 종료를 뜻함.
		} 

		String result = jumsu >= 80 ? "Pass" : "No Pass";

		System.out.println(result);

		 // next line은 점수를 많이 입력했을때 점수 하나만 읽고 남겨지는 잉여 데이터들을 소진하는 명령어 (엔터키 까지도 소진함)
		// 리턴 생략되어있음.

		String grade = "F";
		if(jumsu >=90) { //괄호안에서 선언된 기능은 이 안에서만 사용가능 {} 생략해도문제안됨 {}
			grade = "A";
		}else if(jumsu >=80){
			grade = "B";
		
		}else if(jumsu >=70) {
			grade = "C";

		}else if(jumsu >=60) {
			grade = "D";
		}
		
	
		System.out.printf("등급: %s 결과: %s 점수: %d", grade,result,jumsu);
		//삼항연산자로 위 명령 출력하기 - 과제
	
		
		System.out.println(jumsu >= 90 ? "A" : (jumsu >=80 ? "B" : (jumsu >=70 ? "C" : "D")));
		
		
		
		
		//인자값은 인트타입으로 프로모션이 가능한 데이터 타입.(switch)
		
		
		
	}
	
}

