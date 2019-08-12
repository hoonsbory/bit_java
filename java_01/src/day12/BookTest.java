package day12;

public class BookTest {

	public static void main(String[] args) {

		String msg1 = "hello";
		String msg2 = "hello";
		System.out.println(msg1);
		System.out.println(msg2);

		System.out.println(msg1.equals(msg2));
		
		Book b1 = new Book("java", 2200);
		Book b2 = new Book("java", 2200);
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b1.equals(b2));
		
		b1.close();//close메소드를 자원반납한 후 null로 바꿔주면 언젠가 gc가 작동하면서 처리함.
		b2.close();
		b1 =null; //널로 안바꿔주면 gc를 돌려도 반납안되고 메모리를 쳐먹는다.
		b2 =null;
		
	//	System.gc(); //gc강제호출 null된 자원들 파이널라이즈 메소드 호출하면서 반납해버림
		
		System.out.println("=====================main end======================================");
		
	}

}
