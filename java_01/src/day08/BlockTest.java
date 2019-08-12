package day08;

public class BlockTest {
	public static void main(String[] args) {
		Block b1 = new Block(); //블락 클래스를 동작시킴.
		b1.print();
		Block b4 = new Block(31);
		b4.print();
		
		
	}
}

class Block {
	int i = 0;
	int j= 0;
	static String name;
	static{
		System.out.println("static {    }   "); //딱 한 번 실행됨.  맨위에 쓰면 한번만 초기화
		name = "~~~~";
		//스태틱은 이미 공유되고 있으니까 한번만 하고 다음번엔 생략함.
	}
	{
		System.out.println("{  }"); //생성자보다 우선순위로 수행. 초기화 블락이라고 함.
		this. j = 99;
		
	}
	 	public Block() {
	 		System.out.println("생성자");
	 		
	 	}
	 	public Block(int i) {
	 		this.i = i;
	 	}
	 	public void print() {
	 		System.out.printf("i=%s, j=%s , name=%s %n" , i , j , name);
	 	}
}