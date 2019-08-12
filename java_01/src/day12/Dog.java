package day12;

public class Dog extends Animal { // 추상클래스를 상속받았기 때문에 자식클래스도 추상클래스로 바꾸거나
	// 부모클래스의 추상메소드를 구현해야함

	String kind;
	String name;

	
	public Dog() {
		super("강아지");
	}
	public Dog(String kind, String name) {
		super("강아지");
		this.kind = kind;
		this.name = name;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void breath() {
		System.out.println(super.kind+ " => 폐로 숨쉬기");

	}
	@Override
	public String toString() {
		return "Dog [kind=" + kind + ", name=" + name + "]";
	}//제네레이트 투스트링
	
	
}
