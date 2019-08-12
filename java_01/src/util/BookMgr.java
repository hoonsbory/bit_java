package util;

import java.awt.TextField;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BookMgr extends Object {
	
	Map<Integer, Book> map = new HashMap<Integer, Book>();
	
	String msg;
	Book list;
	public BookMgr() {
	}

	public BookMgr(int size) {
		
	}
	
	public BookMgr(Map<Integer, Book> map) {
		this.map = map;
	}


	// addBook(Book book)메소드
	public Book addBook(int num,Book book) {
		return map.put(num, book);
	}

	// Delete Method
	public String deleteBook(String string) {

		if (map.equals(string)) {
			map.remove(string);
		     return "삭제 정보: " +   " 도서가 삭제되었습니다.";
		} else

			return "%s 도서가 목록에 없습니다.\n" + string;
	}

	// Search Book Method
	public Object searchTitleBook(String title) {
		System.out.printf("%s 도서를 검색합니다.\n", title);

		Iterator<Integer> keynames = map.keySet().iterator();
		while (keynames.hasNext()) {

			Integer isbn = keynames.next();
			Book book = map.get(isbn);
			if (book.getTitle().equals(title)) {
				return book;
			} else {
				msg =  "입력한 도서가 목록에 없습니다.";
			}
		}
		return msg;
	}

	// 책 목록을 화면에 출력하는 printBookList()메소드
	public Book printBookList() {
		System.out.println("========== Book List ==========");

		Iterator<Integer> all = map.keySet().iterator();
		while (all.hasNext()) {

			Integer isbn = all.next();
			Book books = map.get(isbn);
			list = books;
		}
		System.out.println("===============================");
		return list;
	}
}
