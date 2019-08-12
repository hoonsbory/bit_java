package day03_ex;

import java.util.Scanner;

public class ex2 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String cmd = null;
		while (true) {
			System.out.println("******* 명령 선택   ********");
			System.out.println("1. insert(등록)\n");
			System.out.println("2. delete(삭제)\n");
			System.out.println("3. update(수정)\n");
			System.out.println("4. quit(종료)\n");
			System.out.println("***********************");
			System.out.println("수행할 명령을 선택하세요");
			System.out.println("1,2,3,4중 선택하세요");
			cmd = scanner.nextInt()+"";// 트림을 넣으면 양옆 공백제거가 가능하다.
			scanner.nextLine(); //인트로 바꿨기 때문에 엔터 공백이 생기므로 넥스트라인으로 공백을 정리해야함.
			switch (cmd) { // switch(cmd.trim())으로도 사용가능.

			case "1":
				System.out.println("등록");
				break;

			case "2":
				System.out.println("수정");
				break;

			case "3":
				System.out.println("t삭제");
				break;

			case "4":
				System.out.println("정말 종료하려면 q/Q를 입력하세요");
				String quit = scanner.nextLine().trim();
				if (quit.equals("q") || quit.equals("Q")) {
					// 명심하자 스트링은 이퀄스다. ==은 기본형타입

					scanner.close();
					scanner = null;
					// return; // 현재 함수의 종료의미
					System.exit(0); // 앱종료
				}
				break;

			default:
				System.out.println("다시입력하셈");
				break;
			}
		}
	}

}
