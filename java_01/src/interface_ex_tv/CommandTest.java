package interface_ex_tv;

import javax.swing.JOptionPane;

public class CommandTest {

	public static void main(String[] args) {

			Command cmd= new ListCommand(); //디폴트값에 안넣고 여기서 리스트커맨드를 넣으면 됨
			String key = JOptionPane.showInputDialog("list/delete/insert/update 중 하나 입력");
			switch (key) {
		

			case "delete":
				cmd = new DeleteCommand();
				break;
			case "insert":
				cmd = new InsertCommand();
				break;
			case "update":
				cmd = new UpdateCommand();
				break;
			default:
				break;
			}
			
			cmd.exec(); //위에서 네개 중 하나를 입력하면 cmd로 객체생성이 되기때문에 exec함수가 작동됨
			//하나의 메소드로 상황에 따라 다른 반응. 이게 바로 다형성
			cmd.check();
	}

}
