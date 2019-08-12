package day07;

public class Calc {

	static int data = 0; //인스턴스 자원
	//밑에 스테틱에서 쓰고싶으면 이녀석도 스태틱으로 선언하면됨.
	
	//클래스 변수 >>스태틱은 클래스 네임으로 접근하기때문에 클래스변수라 부름
	
	public  long add(int a, int b) {
		
		System.out.println(Math.random());
		// 공유는 하되 인스턴스자원을 쓰지않을거면 스태틱 메소드를 사용하면된다.
		
		// 스태틱처리하면 바로 메모리에 올라가서 뉴 키워드로 메모리에 올릴 필요 x
		
		// 스태틱으로 메모리에 올렸기 때문에 스태틱 밖에 있는 변수 data를 사용할 수가 없다. 
		
		// 스태틱으로 설계하면 인스턴스 자원 사용 불가.
		
		// 클래스 메소드 >> 스태틱은 클래스 네임으로 접근하기때문에 클래스 메소드라 부름.
		
		// 인스턴스메소드에서 클래스(스태틱) 변수는 사용가능. 클래스 메소드에서 인스턴스자원은 사용불가.(주소를 모르기때문)
		
		System.out.println(Calc.data); //스태틱자원은 클래스명으로 접근해야하지만 지금은 같은 
		//클래스 안에 있으므로 클래스명 생략하고 변수명만 써도 호출 가능
		return a + b; // 연산결과값을 가지고 돌아가야하기 때문.
	}

	public static long sub(int a, int b) {
		return a - b; // 연산결과값을 가지고 돌아가야하기 때문.
	}

	public static long multi(int a, int b) {
		return a * b; // 연산결과값을 가지고 돌아가야하기 때문.
	}

	public static double divide(double a, double b) {
		if (b == 0) {
			return 0;

		}
		return a / b; // 연산결과값을 가지고 돌아가야하기 때문.

	}
}
