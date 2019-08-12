package day03;

public class Test01 {

	public static void main(String[] args) {

		// ==  : 기본형의 값이 같은 지 비교,  
		//equals() : 참조형 데이터가 값이 같은 지 비교.
		
		int num1 = 99;
		int num2 = 99;
		
		String name1 = "홍길동";
		String name2 = "홍길동";
	
		String msg1 = new String("Hello");
		String msg2 = new String("Hello java");
		
		System.out.println("num1==num2 =>" + (num1==num2)); //연산은 순서대로 하기때문에 묶어주어야함.
		// 연산은 순서대로 하기때문에 묶어주어야함. 안묶으면 앞에 문자열과 num1의 값을 먼저 연산함.
		System.out.println("name1==name2 =>" + name1.contentEquals(name2));
		System.out.println("msg1==msg2=>" + (msg1==msg2));  //참조형은 주소이기 때문에 주소가 다르면 비교가안됨
		//equals 연산자를 써야함 참조형은 주소를 비교하기 떄문에 안됨 스트링은 둘다 가능.
		System.out.println("msg1==msg2=>" + msg1.equals(msg2)); 
		
		
		msg1 = msg2;
		
		System.out.println("msg1==msg2=>" + msg1.equals(msg2)); 
		System.out.println("msg1==msg2 =>" + (msg1==msg2));
		// msg1 = msg2; 대입을 통해 주소가 같아져서 ==으로도 값을 도출할 수 있다.
		
		
	}

}
