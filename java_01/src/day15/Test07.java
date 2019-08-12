package day15;

public class Test07 {

	public static void main(String[] args) {
		AAA a = new AAA() {

			@Override
			void exec() {

			}
		};
		III i = new III() {  //컨트롤 스페이스로 바로 오버라이딩가능.
			
			@Override
			public void exex() {
				
			}
		};
		
		CCC c = new CCC() { //일반클래스도 바로 오버라이딩 할 수 있따.
			void exec() { //anonymous 클래스로 표현이 가능함.
				
			}
		};
	}

}

abstract class AAA {
	abstract void exec();

}

interface III {
	void exex();
}

class CCC{
	void exec() {
		
	}
}