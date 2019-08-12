package day07;

public class CalcTest {

	public static void main(String[] args) {

		Calc c1 = new Calc();
		
		System.out.println(c1.add(2, 4));	
		//add는 스태틱을 없애서 클래스네임으로 접근불가하기 때문에 뉴키워드를 통해 메모리에 띄운다.
		
		System.out.println(Calc.sub(2, 4));	
		System.out.println(Calc.multi(2, 4));	
		System.out.println(Calc.divide(2, 0));	
		//스태틱으로 메모리에 올렷기때문에 클래스 네임 Calc로 접근
		
	}

}
