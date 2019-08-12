package day21_ex_Book;

import java.io.Serializable;

public class Book2_Map  extends Object implements Serializable, Comparable<Book2_Map>{
	private int isbn;
    private String title;
    private int price;
    
    public Book2_Map() {   }
    public Book2_Map(String title,int price) {
    	this.title = title;
    	this.price = price;
    }
	public Book2_Map(int isbn, String title, int price) {
		super();
		this.isbn = isbn;
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
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", price=" + price + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + isbn;
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
		Book2_Map other = (Book2_Map) obj;
		if (isbn != other.isbn)
			return false;
		return true;
	}
	@Override
	public int compareTo(Book2_Map o) {
		return title.compareTo(o.title);
	}
	
}
