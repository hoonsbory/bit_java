package interface_ex;

import java.nio.file.Path;

interface Drawable{
	//자바에서는 이름뒤에 able가 붙어있으면 모두 인터페이스
	void draw(); //public abstract 생략되어 있음.
}
interface Moveable{
	void move(int m);
	
}
public class Circle2 extends Shape implements Drawable , Moveable , Cloneable{ //임플리먼트 뒤에 여러개 인터페이스 나열
	
	public  Point p; // has a 관계
	int r;
	public Circle2() {
		p = new Point(0,0);
	}

	public Circle2(Point p, int r) {
		this.p = p;
		this.r = r;
	}

	public Point getP() {
		return p;
	}

	public void setP(Point p) {
		this.p = p;
	}

	@Override
	public String toString() {
		return "Circle2 [p=" + p + ", r=" + r + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((p == null) ? 0 : p.hashCode());
		return result;
	}
//equals()와 hashcode()를 재정의 하여 객체가 논리적으로 일치하는지 확인하는 용도로 사용된다
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Circle2 other = (Circle2) obj;
		if (p == null) {
			if (other.p != null)
				return false;
		} else if (!p.equals(other.p))
			return false;
		return true;
	}

	@Override
	public void draw() {
		System.out.println(getClass().getName()+"그리기");
	}

	@Override
	public double area() {
		
		return r*r*Math.PI;
	}

	@Override
	public void move(int m) {
		p.setX(p.getX()+m); //입력된 xy값을 겟으로 가져와 m만큼 더한 후 set으로 xy좌표 재정의
		p.setY(p.getY()+m);
	}
	
	@Override
	public Circle2 clone() throws CloneNotSupportedException { //복제하다가 문제가 발생할 수 있음을 알림. Exception.
		Circle2 circle = (Circle2)super.clone();
		
		circle.p = circle.p.clone(); //딥카피 위에서 복제를 하면 P의 주소가 복제되지 않기 때문에
		//서클 변수안에 있는 p에 복제한 p를 다시 넣어서 주소를 다르게함.
		//has a관계이기 때문에 그럼
		return circle;
			
		}

}
