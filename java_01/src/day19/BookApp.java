package day19;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class BookApp {

	public static void main(String[] args) {
		CommandBook update = new updateBook();
		CommandBook delete = new deleteBook();
		CommandBook listBook = new listBook();
		CommandBook quitBook = new quitBook();
		
		while (true) {

			String cmd = JOptionPane.showInputDialog("숫자 입력하세요 1.책 등록 2. 책 삭제  3. 책 리스트 4. 종료");
			if (cmd == null) {
				return;
			}
			switch (cmd) {
			case "1":
				update.exec();
				break;
			case "2":
				delete.exec();
				break;
			case "3":
				listBook.exec();
				break;
			case "4":
				quitBook.exec();
				break;
			default:
				System.out.println("숫자를 제대로 입력해주세요");
				break;
			}
		}

	}

}
