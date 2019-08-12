package day16;

public class test01 {

	public static void main(String[] args) {

			System.out.println("main strart");
			int a = 10 ,b = 0;
			
			try {
			System.out.println(1);
			System.out.println(a/b); 	//throw new ArithmeticException 에러가 발생해서 던져져버림
			//예외발생하는 순간 catch블락으로 가기 때문에 밑에 프린트는 실행안된다.
			System.out.println(2);
			}catch (ArithmeticException e) { //try catch로 감싸줌.
				//catch는 예외가 발생했을때만 수행.
					System.out.println("예외발생 : " + e.getMessage());
					e.printStackTrace(); //예외 정보만을 찍어주는 메소드! 위치가 랜덤임.
					System.out.println(3);
			}finally {
				System.out.println("finally {항상수행  } "); //예외가발생하든 안하든 수행함.
			}
			//ArithmeticException
			//NullPointerException
			//IndexOutOfBoundsException
			//런타임 익셉션의 자식이라 컴파일을 통과하긴함. => 언체크드 익셉션
			
			if(b!=0) System.out.println(a/b); 	//throw new ArithmeticException 에러가 발생해서 던져져버림
			//위에 코드는 아예 수행안함
			System.out.println("main end");
	}

}
