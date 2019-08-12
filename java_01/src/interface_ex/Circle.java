package interface_ex;

 abstract class Shape implements drawandmove{ //부모클래스 쉐잎으로 인터페이스까지 상속받아
	 //쉐잎타입으로 모든 기능 핸들링 가능.
	 //drawandmove은 Drawable와 Moveable의 자식으로 그 기능을 상속받고 쉐이프는 그 자식인 drawandmove를
	 //상속받아서 모든 기능 핸들링.
	 
	public abstract double area(); //인터페이스의 추상메소드는 퍼블릭이 생략되어있음
	//인터페이스는 abstract도 생략해도됨
}


//interface Drawable{
//	//자바에서는 이름뒤에 able가 붙어있으면 모두 인터페이스
//	void draw(); //public abstract 생략되어 있음.
//}

public class Circle  extends Shape implements Drawable{ //가장 중요한 클래스를 상속받고 다른 클래스는 has a 관계로.
	//extends뒤에는 클래스명 implements 뒤에는 인터페이스명
	//인터페이스는 익스텐즈가 아니라 임플리먼츠로 상속.
	Point p;
	int r;
	
	public Circle(Point point, int r) {
		this.p = point;
		this.r = r;
	}

	@Override
	public String toString() {
		return "Circle [p=" + p + ", r=" + r + "]";
	}

	//@Override
	public double  area() {
		
		return r*r*Math.PI;
		
	}

	@Override
	public void draw() {
		System.out.println(getClass().getName()+ "그리기"); //getclass 지금 클래스에서 네임을 가져와라
		
	}

	@Override
	public void move(int m) {
		// TODO Auto-generated method stub
		
	}
}