package day19;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JOptionPane;

// Book 만든후 BookMgr을 Collection 기반으로 바꾸어서 CURD 가 다 되도록 만든다.

public class BookMgr2_Map {

	Map<Integer, Book2_Map> map = null;

	public BookMgr2_Map() {
		map = new HashMap<Integer, Book2_Map>();
	}

	public void addBook(String a) {
		

//			String a = JOptionPane.showInputDialog("책 정보를 등록하세요 제목/가격");
			if (a == null) {
				return;
			}

			if (!(a.contains("/"))) {
				System.out.println("/를 넣어서 입력해주세요 ");
			} else {
				String[] data = a.trim().split("/");

				if (data.length != 2 || data[0].equals("")) {
					System.out.println("다시입력해주세요 제목/가격");

				} else {
					try {
						map.put(map.size() + 1, new Book2_Map(map.size() + 1, data[0], Integer.parseInt(data[1])));
						System.out.println("등록 완료되었습니다");
						System.out.println(map);
					} catch (Exception e) {
						System.out.println("가격은 숫자로 입력해주세요");
					} finally {

					}

				}

				
			}
		}

	

	public void deleteBook() {
		if (map.size() == 1) {
			System.out.println("책이 없습니다. 등록해주세요");
			return;
		}
		String a = JOptionPane.showInputDialog("삭제할 책이름을 입력하세요");
		if (a == null) {
			return;
		}
		Iterator<Integer> it = map.keySet().iterator();
		int count = 0;
		while (it.hasNext()) {
			Integer isbn = it.next();
			Book2_Map data = map.get(isbn);
			count++;
			if (data.getTitle().equals(a)) {
				System.out.println(data + " 삭제됩니다.");
				// map.remove(isbn);
				it.remove();
				count--;
			}
			data.setIsbn(count);
		}
		System.out.println("찾으시는 책이 없습니다 다시 입력하세요");
	}

	public void searchTitleBook() {
		if (map.size() == 0) {
			System.out.println("책이 없습니다. 등록해주세요");
			return;
		}
		String a = JOptionPane.showInputDialog("찾고싶은 책이름을 입력하세요");
		if (a == null) {
			return;
		}
		System.out.println("제목 " + a + " 검색 결과 ");
		Iterator<Integer> it = map.keySet().iterator();
		while (it.hasNext()) {
			Integer isbn = it.next();
			Book2_Map data = map.get(isbn);
			if (data.getTitle().toUpperCase().contains(a.toUpperCase())) {
				System.out.println(data);
			}
		}
		System.out.println("----------------------------");
	}

	public void bookListPrint() {
		if (map.size() == 0) {
			System.out.println("책이 없습니다. 등록해주세요");
			return;
		}
		System.out.println("=========Book List  foreach 기반 ==========");
		map.forEach((k, v) -> System.out.println(v));
		System.out.println("=============================");
	}
}
