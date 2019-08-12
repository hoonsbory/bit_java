package day12;

public class fish extends Animal{
		
	String name;
	String kind;
	
	public fish() {
		super("물고기");
		
	}
	public fish(String name, String kind) {
		super("물고기");
		this.name = name;
		this.kind = kind;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	@Override
	public void breath() {
		System.out.println(super.kind+ " => 아가미로 숨쉬기");
	}
	@Override
	public String toString() {
		return "fish [name=" + name + ", kind=" + kind + "]";
	}
	
	
	
}
