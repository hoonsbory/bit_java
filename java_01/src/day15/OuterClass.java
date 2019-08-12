package day15;

public class OuterClass {

	public static void main(String[] args) {
			A a = new A();
			a.p();
			A.B b = new A("dfsdfsdfs"). new B(); //이너클래스 객체 생성 하는 방법
			//아우터클래스 주소안의 이너클래스를 객체 생성하기 위해 변수 b를 생성하고
			//뉴키워드로 에이 객체를 띄우고 그 주소안의 b객체를 띄움.
			b.print();
			//A.C c = new A().new C();
			//c.print();
			
			A.C.print();
		
	}
}

class A {
	String name = "A";
	public A() {}
	public A(String name) {
		super();
		this.name = name;
	}


	void p() {
		System.out.println("A에서 호출");
		new B().print();   //객체 생성후 메소드 호출해야함.
	}
	
	
	class B {
		
		String name = "B";
		
		void print() { 
			System.out.println("B   " + this.name); //this 생략됐었음.  이 유형이 멤버형태의 내부클래스
			System.out.println("B   " + A.this.name);  //아우터 클래스의 변수 name쓰고자할때 아우터 클래스 주소의 this를 붙여쓴다.
		}
	}

	static class C{  //아우터클래스 안에 있는 이너클래스는 멤버변수이기에 static 허용
		static void print() {
			System.out.println("dfsdfs");  //스태틱 변수에 스테틱한 메소드라 클래스 이름으로 접근가능.
		}
		
		
	}
	class D{
		void p() {
			class E{ //local 이너클래스  얘는 재활용하기 힘듦. 그냥 여기서만 한번 쓰고 버림
				
			}
		}
		
	}
	
}
