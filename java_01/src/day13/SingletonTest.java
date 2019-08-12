package day13;

public class SingletonTest {

	public static void main(String[] args) {
		// Singleton s1 = new Singleton();
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		Singleton s3 = Singleton.getInstance();
		// 싱글톤 기본생성자함수는 프라이빗해서 스태틱한 함수를 만들어서 싱글톤 객체를 생성함.
		// 싱글톤 패턴
		// 생성자가 여러 차례 호출되더라도 실제로 생성되는 객체는 하나이고 최초 생성 이후에
		// 호출된 생성자는 최초의 생성자가 생성한 객체를 리턴한다.
		// 이와 같은 디자인 유형을 싱글턴 패턴이라고 한다.
	}

}

class Singleton {

	private static Singleton s = new Singleton(); // 이 클래스에서 s라는 싱글톤 객체를 생성해서 s를 넘겨줌.

	private Singleton() {
		System.out.println("싱글톤 객체 생성");
	}

	public static Singleton getInstance() { // 싱글톤 객체를 생성하는 메소드. 스테틱이라 위에서 쓸 수 있음.
		if (s == null)
			s = new Singleton();
		return s;

	}

}