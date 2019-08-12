package day15;

public class test04 {

	public static void main(String[] args) {
		Command cmd = new Deletecommand();
		cmd.exec();
		cmd = new UpdateCommand();
		cmd.exec();
	}

}
