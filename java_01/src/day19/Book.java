package day19;

import java.util.ArrayList;
import java.util.List;

public class Book implements Comparable<Book>{
	private int ISBN  ;
	private String title;
	private int price;
	
	
	
	static List<Book> book = new ArrayList<Book>();
	public Book() {
		
		
	}
	

	public Book( int ISBN , String title, int price) {
		
		this.ISBN = ISBN;
		this.title = title;
		this.price = price;
	}

	
	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		this.ISBN = iSBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if(title == null) {
			return;
		}
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ISBN;
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
		if (ISBN != other.ISBN)
			return false;
		if (price != other.price)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", title=" + title + ", price=" + price + "]";
	}

	public void print() {
		System.out.printf("Book[%s ]\n" ,title  );
	}
	public void print2() {
		System.out.printf("Book[%s ] Price[%d]\n" ,title , price );
	}
	@Override
	public int compareTo(Book o) {
		
		return title.compareTo(o.title);
	}
}
