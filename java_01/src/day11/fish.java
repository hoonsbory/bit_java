package day11;

import day10.Animal;

public class fish extends Animal {

	public fish() {
		super("물고기");
	}

	public fish(String name ) {
		super("물고기");
		this.name = name;
	//	this.kind = kind;

	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void fishprint() {
		System.out.printf("[%s : %s]%n", getKind(), name);
	}

	// 메소드 오버라이딩!!! => 부모로부터 물려 받은 기능을 다시 재정의 하는 것!!
	//부모 메소드의 선언부를 그대로 가져옴
   	@Override //오버라이딩 체크. @중요  
	public void breath() {
		System.out.println(getKind() + "아가미로 숨쉬기!!");
	//	super.breath(); 오버라이딩을 했지만 부모클래스의 메소드를 쓰고싶을땐 슈퍼.
	}
	@Override
	public void print() {
		super.print();
		System.out.printf("종류 : %s 이름 : %s%n" , name, getKind());
	
	}
}
