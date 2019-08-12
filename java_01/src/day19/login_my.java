package day19;

import javax.swing.JOptionPane;

public class login_my {
	public static void main(String[] args) {
		Command delete = new DeleteCommand();
		Command update = new UpdateCommand();
		Command select = new SelectCommand();
		Command insert = new InsertCommand();

		while (true) {
			String a = JOptionPane.showInputDialog("명령어 입력하셈 끄고 싶으면 q 누르고");
			if (a==null) {
				return;
			}
			//String cmd = args[0];  cmd에서 파일 실행할때 문자를 같이 입력하면 아규즈 0번째 인덱스에 들어감.
			String cmd = a;

			switch (cmd) {
			case "insert":
				insert.exec();
				break;
			case "update":
				update.exec();
				break;
			case "delete":
				delete.exec();
				break;
			case "select":
				select.exec();
				break;
			case "Q":
				System.out.println("소문자로 입력하라고 ㅡㅡ");
				break;
			
			case "q":
				System.out.println("종료");
				System.exit(0);
			
				
			default:
				System.out.println("다시 입력해요...");
				break;
			}
		}
	}
}
