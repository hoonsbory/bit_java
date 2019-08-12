package day17;

public class test01 {

	public static void main(String[] args) {
		//Book b1 = new Book<T>(title, price)  자동으로 오브젝트처리됨 
		Book1 b1 = new Book1("dfsdf", 2000); //프라이스가 오브젝트 타입이라 자동으로 정수화됨.
		System.out.println(b1);
		
		Book1<Double> b2 = new Book1<Double>("df", 700.0); //T에 스트링타입을 넣어서 오브젝트에서 스트링이됨
		System.out.println(b2);
		
		Book1<Integer> b3 = new Book1<Integer>("123", 231); //이번엔 프라이스가 인트타입이됨.
		System.out.println(b3);
		System.out.println(Long.MAX_VALUE);
	}

}
