package day10;

public class Animal {
	  protected String kind = "동물의 종류";
	  
	  
	
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

	public void breath() {
		System.out.println(kind + "  :   폐로 숨쉬기");
	}

	public void print() {
		System.out.printf("종류 : %s" , this.kind);
		//	super.breath(); 오버라이딩을 했지만 부모클래스의 메소드를 쓰고싶을땐 슈퍼.
		}
}
