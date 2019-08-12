package day15;

import javax.swing.JOptionPane;

public class Ramda {
	public static void main(String[] args) {
		String msg = JOptionPane.showInputDialog("1.list 2. updeae 3.delete 4.quit");
		Command cmd = () -> {	System.out.println("list 수행"); };
		// 추상메소드가 딱 하나일때 람다 표현이 가능.
		// 어차피 커맨드 타입이 올걸 알기에 생략하고 함수도 () 이걸로 생략하고 ->화살표로 바디부를 가리킴
		//람다는 jdk1.7부터 사용가능
		// cmd.exec();
		//람다식  = 변수에 함수를 바인딩 시키는 것이 람다.
		//변수에 함수를 등록하여 사용하는 기능
		Command update = () -> {
			System.out.println("update 수행");
		};

		// update.exec();
		Command delete = () -> {
			System.out.println("delete 수행");
		};

		// delete.exec();

		switch (msg) {
		case "1":
			cmd.exec();
			break;
		case "2":
			update.exec();
			break;
		case "3":
			delete.exec();
			break;
		case "4":
			// System.out.println("정말 종료하려면 q/Q를 입력하세요");
			String quit = JOptionPane.showInputDialog("종료하려면 q/Q를 입력하세요");
			if (quit == null) {
				return;
			}
			if (quit.equals("q") || quit.equals("Q")) {
				// 명심하자 스트링은 이퀄스다. ==은 기본형타입

				System.exit(0); // 앱종료 0이 아닌 수를 넣으면 정상적인 종료가 아님.
			}
			break;
		default:
			break;
		}
	}
}
