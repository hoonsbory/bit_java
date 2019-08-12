package day12;

public class Book extends Object {

	private String title;
	private int price;

	public Book() {

	}

	public Book(String title, int price) { // 파라미터타입이 순서가 다르기때문에 오버로딩가능.
		super();
		this.title = title;
		this.price = price;
	}

	public Book(int price, String title) {
		super();
		this.title = title;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	StringBuilder st = new StringBuilder(); // 스트링빌더 쓰는법 잊지말자.

	@Override // 오브젝트에 있는 투스트링을 오버라이딩 하는법.
	public String toString() {
		st.append("제목 : ");
		st.append(title);
		st.append("  :  ");
		st.append("가격 : ");
		st.append(price);
		// String msg = new String(st);
		// return msg;
		// return new String(st);
		return st.toString();
	}

	@Override
	public boolean equals(Object book) { // equals메소드의 오버라이딩.
		boolean flag = false;
		if (book == null || !(book instanceof Book)) {
			return false;
		}
		Book data = (Book) book; // 오브젝트 타입의 book를 Book타입으로 다운캐스팅한 후 data변수에 넣어서 비교함.
		if (price == data.price && title.equals(data.title)) {
			flag = true;
		}
		// if (this.price == ((Book)book).price) {//오브젝트는 맨위라 다운캐스팅 필수. 북 클래스로 다운캐스팅.
		// return this.title.equals(((Book)book).title);

		// }
		return flag;

	}

//	@Override
//	protected void finalize() throws Throwable { 
//		//객체가 소멸되기 직전에 호출되는 메소드이지만 자바에서는 사용안하고
			//별도의 자원반납 기능을 만들어 사용한다. ex) close();
//		System.out.println("자원반납" );
//	}
	public void close() { //close 메소드로 자원반납
		System.out.println("자원반납" );
	}
}
