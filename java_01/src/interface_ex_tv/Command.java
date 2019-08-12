package interface_ex_tv;

public interface Command {
	public void exec();
	default public void check() {
		System.out.println("command check 함수");
	} //default를 붙이면 자식들이 굳이 오버라이딩을 안해도 에러가 안남.
	//앱스트랙메소드는 아니다. 그렇다고 인스턴스 메소드도 아니다. 마치 스테틱처럼 내부가 관리된다.
	//쓰고싶으면 오버라이딩하면됨.
}

class DeleteCommand implements Command {

	@Override
	public void exec() {
		System.out.println("Delete 수행");
	}
	@Override
	public void check() {
			System.out.println("delete check");
	}

}

class InsertCommand implements Command {

	@Override
	public void exec() {
		System.out.println("Insert 수행");
	}
}

class UpdateCommand implements Command {

	@Override
	public void exec() {
		System.out.println("Update 수행");
	}
}

class ListCommand implements Command {

	@Override
	public void exec() {
		System.out.println("List 수행");
	}
}