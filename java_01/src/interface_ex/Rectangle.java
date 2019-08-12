package interface_ex;
interface drawandmove extends  Drawable, Moveable  { 
	//이런식으로 여러개의 인터페이스를 부모로 가지는 인터페이스를 만들면
	//한번에 상속받을 수 있다.
	//이런식으로 많은 기능을 하나의 인터페이스에 몰아넣을 수 있다.
	
}

public class Rectangle extends Shape implements drawandmove{
	Point p;
	int width;
	int height;
	
	public Rectangle(Point p, int x , int y ) {
		this.p = p;
		this.width = x;
		this.height = y;
		
	}
	
	
	
	
	
	
	
	public double getX() {
		return width;
	}







	public void setX(int x) {
		this.width = x;
	}







	public double getY() {
		return height;
	}







	public void setY(int y) {
		this.height = y;
	}







	





	@Override
	public String toString() {
		return "Rectangle [p=" + p + ", x=" + width + ", y=" + height + "]";
	}







	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(width);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}






	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rectangle other = (Rectangle) obj;
		if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width))
			return false;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		return true;
	}






	@Override
	public void move(int m) {
			p.setX(p.getX()+m);
			p.setY(p.getY()+m);
	}

	@Override
	public void draw() {
		System.out.println(getClass().getName()+"그리기");
	}

	@Override
	public double area() {
	
		return width*height;
	}
	

}
