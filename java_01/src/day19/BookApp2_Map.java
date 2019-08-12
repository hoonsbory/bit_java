package day19;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class BookApp2_Map {

	public static void main(String[] args) {

		BookMgr2_Map mgr = new BookMgr2_Map();
		while (true) {

			String cmd = JOptionPane.showInputDialog("숫자 입력하세요 1.책 등록 2. 책 삭제  3. 책 리스트 4. 종료");
			if (cmd == null) {
				return;
			}
			switch (cmd) {
			case "1":
				mgr.addBook();
				break;
			case "2":
				mgr.deleteBook();
				break;
			case "3":
				mgr.bookListPrint();
				break;
			case "4":
				mgr.searchTitleBook();
				break;
			default:
				System.out.println("숫자를 제대로 입력해주세요");
				break;
			}
		}

	}

}
