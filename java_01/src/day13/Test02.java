package day13;

import interface_ex.Circle2;
import interface_ex.Point;

public class Test02 {

	public static void main(String[] args) {
		
		Point p = new Point(3,5);
		
		System.out.println(p); //투스트링 생략
		
		Circle2 c1 = new Circle2();
		c1.setP(p);
		System.out.println(c1);
		
		Circle2 c2 = new Circle2(new Point(7,7),5);  //써클2에서 포인트 타입 p를 선언했기에 생성자함수에 p타입이 들어가면 반응함.
		//포인트 타입 하나짜리 생성자함수에 값을 넣어서 써클에서의 투스트링과 포인트에서의 투스트링이 함께 작동함.
		System.out.println(c2);
	}

}
