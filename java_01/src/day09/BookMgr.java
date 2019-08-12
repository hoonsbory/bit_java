package day09;

import java.util.Arrays;

public class BookMgr {
	int count = 0;
	int sum = 0;

	Book[] booklist;

	// public Book[] getBooklist() {
	// return booklist;
	// }

	public void setBooklist(Book[] booklist) {
		this.booklist = booklist;
	}

	public BookMgr() {
		this(10); // 지금 이 함수는 기본 생성자 함수다. this(10) 은 생성자함수중에 인트타입을 매개변수로 가지는
		// 생성자함수에 10을 넣는다는 뜻이다.ㄹ

	}

	public BookMgr(int size) {

		booklist = new Book[size];

	}

	public void printBookList() {
		System.out.println("==== 책 목록 ====");
		if (count == 0) {
			System.out.println("책이 없습니다.");

		}
		for (int x = 0; x < count; x++) {
			if ((booklist[x] != null)) {
				booklist[x].print();
			}

			// System.out.println(booklist[x].getTitle());

		}
		System.out.println("총 " + count + " 권");
		System.out.println("=========== ====");

	}

	/*
	 * public void printTotalPrice() { System.out.println("====책 가격의 총합 ==="); for
	 * (int z = 0; z < count; z++) { //null값이 있어서 카운트로
	 * 
	 * sum = sum + booklist[z].getPrice(); } System.out.printf("책들의 총 가격 합은 : %d ",
	 * sum); }
	 */

	public int printTotalPrice() {
		System.out.println("====책 가격의 총합====");
		for (int i = 0; i < count; i++) {
			sum += booklist[i].getPrice();

		}
		return sum;
	}

	public void addbook(Book book) { // 선언부에는 모든 데이터 타입이 올 수 있다. 그 대신 리턴은 그 데이터타입으로.
		if (count == booklist.length) {
			Book[] copy = new Book[booklist.length * 2]; // 새로운 배열을 만든다 기존 배열보다 두배 큰.
			System.arraycopy(booklist, 0, copy, 0, booklist.length);// 배열 복사
			booklist = copy;
		}
		
		
		booklist[count] = book;
		count++;
		for(int i=0; i<count; i++) {
			if(i !=count-1 && count != 1 && booklist[count-1].getTitle().equals(booklist[i].getTitle())) {
				System.out.println("이미 등록된 책입니다");
				booklist[count-1] = null;
				count--;
				
			}
		}
			
		}
	

	public void Delete(String str) {
		for (int i = 0; i < count; i++) {
			if (str.equals(booklist[i].getTitle())) {
				/*
				 * if (str.equals(booklist[i].getTitle())) { count--; for (int j = i; j < count;
				 * j++) { booklist[j] = booklist[j + 1];
				 * 
				 * }
				 */

				System.arraycopy(booklist, i + 1, booklist, i, count - i - 1);
				count--;
				System.out.println("삭제완료");
				return;
			}
		}

		System.out.println("찾으시는 책이 없습니다.");

	}

	public void Search(String str2) {

		/*
		 * if (count == 0) { System.out.println("책이 없습니다.");
		 * 
		 * } for (int i = 0; i < count; i++) { if
		 * (booklist[i].getTitle().contains(str2)) { booklist[i].print2(); }
		 * 
		 * else { System.out.println("찾으시는 책이 없어요."); } }
		 */

		for (Book data : booklist) {
			if (count == 0) {
				System.out.println("책이 없습니다.");
			}
			if (data == null)
				return;
			if (data.getTitle().contains(str2)) {
				data.print2();
			}

		}
	}
}
