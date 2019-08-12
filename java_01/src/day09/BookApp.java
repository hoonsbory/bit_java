package day09;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class BookApp {

	public static void main(String[] args) {

		BookMgr mgr = new BookMgr(3); // 북매니저 객체 생성

		// Scanner scanner = new Scanner(System.in);
		String delete = null;
		String cmd = null;
		String search = null;
		// int cancle = 0;
		// int close = 0;
		while (true) {
			System.out.println("******* 명령 선택   ********");
			System.out.println("1. 책 등록\n");
			System.out.println("2. 책 검색\n");
			System.out.println("3. 책 삭제\n");
			System.out.println("4. quit(종료)\n");
			System.out.println("***********************");
			System.out.println("수행할 명령을 선택하세요");
			System.out.println("1,2,3,4중 선택하세요");
			cmd = JOptionPane.showInputDialog("1,2,3,4중에 입력해주세요");// 트림을 넣으면 양옆 공백제거가 가능하다.
			// scanner.nextLine(); // 인트로 바꿨기 때문에 엔터 공백이 생기므로 넥스트라인으로 공백을 정리해야함.
			// cancle = JOptionPane.CANCEL_OPTION;
			// close = JOptionPane.CLOSED_OPTION;
			if (cmd == null) {
				return;
			}
			switch (cmd) { // switch(cmd.trim())으로도 사용가능.

			case "1":
				System.out.println("등록");
				System.out.println("책 이름을 입력하세요");
				String title = JOptionPane.showInputDialog("책 제목을 입력해주세요");
				if (title == null) {
					return;
				} // 위에서 생성한 스캐너를 불러옴. 넥스트라인은 엔터까지 읽는다
				System.out.println("책 가격을 입력하세요");
				String price1 = JOptionPane.showInputDialog("책 가격을 입력해주세요");
				if (price1 == null) {
					return;
				}
				
				// 넥스트인트는 값만 읽고 엔터를 남김
					// scanner.nextLine(); // 엔터를 소진해줘야함 나중에 영향끼침.
				title = title.toLowerCase();
		
				int price = Integer.parseInt(price1);
				
				
				mgr.addbook(new Book(title, price));
				break;

			case "2":
				System.out.println("검색할 책 이름을 입력하세요");
				if (mgr.count != 0) {
					search = JOptionPane.showInputDialog("검색할 책 제목을 입력해주세요");
					if (search == null) {
						return;
					}
					search = search.toLowerCase();
				}
				mgr.Search(search);
				break;

			case "3":
				System.out.println("삭제할 책 이름을 입력하세요");
				mgr.printBookList();
				if (mgr.count != 0) {
					delete = JOptionPane.showInputDialog("삭제할 책 제목을 입력해주세요");
					if (delete == null) {
						return;
					}
				}
				// delete = delete.toLowerCase();
				// mgr.Search(search);
				mgr.Delete(delete);

				break;

			case "4":
				System.out.println("정말 종료하려면 q/Q를 입력하세요");
				String quit = JOptionPane.showInputDialog("종료하려면 q/Q를 입력하세요");
				if (quit == null) {
					return;
				}
				if (quit.equals("q") || quit.equals("Q")) {
					// 명심하자 스트링은 이퀄스다. ==은 기본형타입

					// scanner.close(); // 스캐너와 힙영역에 있는 데이터의 연결을 끊어줌
					// scanner = null; // 널로 초기화 시켜서 데이터 없앰
					// return; // 현재 함수의 종료의미
					System.exit(0); // 앱종료 0이 아닌 수를 넣으면 정상적인 종료가 아님.
				}
				break;

			default:
				System.out.println("다시입력하셈");
				break;
			}
		}
	}

}
