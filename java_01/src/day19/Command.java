package day19;

@FunctionalInterface
public interface Command {
	void exec();
	default void print() { //default 넣으면 바디부 있어도 에러안난다 ㅎ
		System.out.println("==================================");
		
	}
}

class DeleteCommand implements Command{

	@Override
	public void exec() {

		System.out.println("Delete 수행");
	}
	
	
}
class InsertCommand implements Command{

	@Override
	public void exec() {

		System.out.println("Insert 수행");
	}
	
	
}
class SelectCommand implements Command{

	@Override
	public void exec() {

		System.out.println("Select 수행");
	}
	
	
}
class UpdateCommand implements Command{

	@Override
	public void exec() {

		System.out.println("Update 수행");
	}
	
	
}