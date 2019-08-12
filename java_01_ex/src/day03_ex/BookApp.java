package day03_ex;

import java.util.Scanner;

public class BookApp {

	public static void main(String[] args) {

		Scanner book = new Scanner(System.in);

		int num;
		do {
			System.out.println("******* 명령 선택   ********");
			System.out.println("1. insert(등록)\n");
			System.out.println("2. delete(삭제)\n");
			System.out.println("3. 목록 출력\n");
			System.out.println("4. quit(종료)\n");
			System.out.println("***********************");
			System.out.println("수행할 명령을 선택하세요");
			System.out.println("1,2,3,4중 선택하세요");
			num = book.nextInt();
			if (num == 1) {
				System.out.println("등록을 수행했습니다");

			} else if (num == 2) {
				System.out.println("삭제를 수행했습니다");

			}

			else if (num == 3) {
				System.out.println("목록 출력을 완료했습니다");

			} else if (num > 4) {

				System.out.println("1,2,3,4 중 하나를 선택하세요");
			} else if (num < 1) {

				System.out.println("1,2,3,4 중 하나를 선택하세요");
			}
		} while (num != 4);
	}

}
