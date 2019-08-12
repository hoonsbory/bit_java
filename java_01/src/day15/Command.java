package day15;

public interface Command {
	void exec();

	default public void check() {
		System.out.println("check ~~~");
	}
}

class Deletecommand implements Command {

	@Override
	public void exec() {
		System.out.println("Delete 수행");
	}

}

class UpdateCommand implements Command {

	@Override
	public void exec() {
		System.out.println("Update 수행");
	}

}
