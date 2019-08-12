package day15;

import java.lang.invoke.SwitchPoint;

import javax.swing.JOptionPane;

public class AnonymousTest {
	public static void main(String[] args) {
		String msg = JOptionPane.showInputDialog("1.list 2. updeae 3.delete 4.quit");
		Command cmd = new Command() { // 즉석으로 커맨드를 상속받는 클래스를 만들어서 메모리에 띄움
			// 클래스를 정의함과 동시에 생성. Anonymous 내부클래스
			// new 익명 implements Command 라는 뜻. 즉 익명의 커맨드를 상속받은 클래스를 생성하는것.

			@Override
			public void exec() {
				System.out.println("list 수행");
			}

		};
		//cmd.exec();

		Command update = new Command() {

			@Override
			public void exec() {
				System.out.println("update 수행");
			}

		};
		//update.exec();
		Command delete = new Command() {

			@Override
			public void exec() {
				System.out.println("delete 수행");
			}

		};
		//delete.exec();

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
			//System.out.println("정말 종료하려면 q/Q를 입력하세요");
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
