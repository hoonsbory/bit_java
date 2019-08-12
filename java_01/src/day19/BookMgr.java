package day19;

import java.util.Iterator;
import java.util.function.Consumer;

import javax.swing.JOptionPane;

interface CommandBook {
	void exec();

}

class updateBook extends Book implements CommandBook  {

	@Override
	public void exec() {

		while (true) {

			String a = JOptionPane.showInputDialog("책 정보를 등록하세요 제목/가격");
			if (a == null) {
				return;
			}

			if (!(a.contains("/"))) {
				System.out.println("/를 넣어서 입력해주세요 ");
			} else {
				String[] data = a.trim().split("/");

				for (Book data2 : book)
					if (book.size() != 0 && data2.getTitle().equals(data[0])) {
						System.out.println("이미 있는 책입니다 다시 입력해주세요.");
						return;
					}
//				if (data[0] == "") {
//					System.out.println(" 입력해주세요. 제목/가격");
//				}
				if (data.length != 2 || data[0].equals("")) {
					System.out.println("다시입력해주세요 제목/가격");

				} else {
					try {
						book.add(new Book(book.size() + 1, data[0], Integer.parseInt(data[1])));
						System.out.println("등록 완료되었습니다");
						System.out.println(book);
					} catch (Exception e) {
						System.out.println("가격은 숫자로 입력해주세요");
					}finally {
						
					}
				
				}

				break;
			}
		}
	}
}

class deleteBook extends Book implements CommandBook {

	@Override
	public void exec() {
		researchBook.exec1();
		if (book.size() == 0) {

			return;
		}
		String a = JOptionPane.showInputDialog("삭제할 책이름을 입력하세요");
		if (a == null) {
			return;
		}
		
		Iterator<Book> it = book.iterator();
		int count = 0;
		while (it.hasNext()) {
			Book data = (Book) it.next();

			count++;
			if (data.getTitle().equals(a)) {
				System.out.println(data);
				it.remove();
				count--;
			} 
				
			

			data.setISBN(count);

//				String b = JOptionPane.showInputDialog("정말 삭제를 원하시면 Y를 입력해주세요");
//				if (b.equals("Y")) {
//					 data = (Book)null;
//				}

		}
		System.out.println("찾으시는 책이 없습니다 다시 입력하세요");
	}

}

class listBook extends Book implements CommandBook {

	@Override
	public void exec() {
		researchBook.exec1();
	}

}

class quitBook extends Book implements CommandBook {

	@Override
	public void exec() {
		String a = JOptionPane.showInputDialog("종료를 원하시면 q를 입력하세요");
		if (a == null) {
			return;
		}
		if (a.equals("q")) {
			System.exit(0);
		}
	}

}

class researchBook extends Book {

	public static void exec1() {
		Iterator<Book> it = book.iterator();
		if (book.size() == 0) {
			System.out.println("책이 없습니다. 등록해주세요");

		}
		while (it.hasNext()) {
			Book book = (Book) it.next();
			System.out.println(book);

		}

	}

}
