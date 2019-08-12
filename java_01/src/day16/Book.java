package day16;

import day17.PriceException;

public class Book {
	private String title;
	private int price;

	public Book() {
	}

	public Book(String title, int price) throws Exception {
		super();
		this.title = title;
		setPrice(price); //셋프라이스를 예외처리해서 여기서도 예외처리
		//여기서 생성자함수에 쓰로우즈를 하는게 아니고
		//트라이캐치로 프라이스를 감싸면 객체생성할때 하나하나 트라이캐치할 필요가없다 
		//하지만 에러메세지를 이 곳에서만 컨트롤해야한다. 장단점이 있다.
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

	public void setPrice(int price) throws PriceException {  //예외 클래스는 예외를 상속받아야함.
		//예외 이름을 바꾸는 대신 클래스를 생성해줘야함.
		if(price < 0) throw  new PriceException();  //강제로 예외발생시켜버림
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + price;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (price != other.price)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	

}
