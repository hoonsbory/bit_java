package day06_ex;

public class Animal {
	
	
	private boolean live;
	private String name;
	private int age;
	

	
	public void display2() {
		System.out.printf("[이름  : %s, 생존여부 : %b]%n", this.name, this.live);
	}
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
		
	
	}
	public static void main(String[] args) {
		Animal a = new Animal();
		a.name = "~~~"; // 인스턴스 베리어블 주소가있어야만 접근
		a.printA();  //인스턴스 메소드 주소가 있어야만 접근가능
	}

	}
	

