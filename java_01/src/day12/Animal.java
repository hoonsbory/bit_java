package day12;

public abstract class Animal { //추상클래스
	  protected String kind = "동물의 종류";
	  
	  
	public Animal() {
		
		
		
	}
	public Animal(String kind) {
		super();
		this.kind = kind;
	}

	public Animal(String name, String kind) {
		super();
		this.kind = kind;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public abstract  void breath() ; //추상메소드. 클래스도 abstract로 바꿔줘야 사용가능.

	public void print() {
		System.out.printf("종류 : %s" , this.kind);
		//	super.breath(); 오버라이딩을 했지만 부모클래스의 메소드를 쓰고싶을땐 슈퍼.
		}
}
