package day06_ex;

public class student {

	
	private String name;
	private int number;
	private String live;
	
	
	public void display() { //인스턴스 자원
		System.out.printf("[이름 : %s 학번 : %d 주소 : %s]%n", getName() , number, live);
		//메인메소드에서는 this 못씀
		
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getLive() {
		return live;
	}
	public void setLive(String live) {
		this.live = live;
	}
	
	
	
}
