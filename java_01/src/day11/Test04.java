package day11;

public class Test04 {

	public static void main(String[] args) {

		String msg1 = "Hello";
		String msg2 = "Hello";
		
		System.out.println(msg1.toString());  //오토컨버팅이 됨.
		System.out.println(msg2);
		
		Book b1 = new Book("Java" , 700);
		Book b2 = new Book("Java" , 700);
		
		System.out.println(b1.toString()); //오토컨버팅
		System.out.println(b2);
	}

}

class Book extends Object { //오브젝트에서 물려받은 투스트링과 이퀄즈를 오버라이딩할 준비를 해야함.

	String title;
	int price;
	StringBuilder st = new StringBuilder();
	public Book() {

	}

	public Book(String title, int price) { //생성자함수로 값을 저장
		super();
		this.title = title;
		this.price = price;
	}
	@Override
		public String toString() {  //스트링 메소드를 오버라이딩.
		st.append("제목 : ");
		st.append(title);
		st.append("  :  ");
		st.append("가격 : ");
		st.append(price);
		String msg = new String(st);
			return msg;
		}
}
