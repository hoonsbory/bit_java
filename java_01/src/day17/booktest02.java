package day17;

import day16.Book;

public class booktest02 {

	public static void main(String[] args) {
		Book b1 = new Book();
		b1.setTitle("java");
		try {
			b1.setPrice(-9000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		System.out.println(b1);
		System.out.println("===========================");
		Book b2 = null;
		try {
			 b2 = new Book("jsp", -9999);
		} catch (Exception e) {
			System.err.println(e.getMessage()); //err로 하면 위치랜덤에 색깔이 입혀짐.
		//	e.printStackTrace();
		}
		System.out.println(b2);
	}

}
