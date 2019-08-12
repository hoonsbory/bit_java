package interface_ex;

public class Point implements Cloneable{ //Cloneable복제 능력을 point에 추가해줌

	private int x;
	private int y;

	public Point() {
		
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
@Override
public String toString() {
	return "Point [x=" + x + "y =" + y+ "]";  
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + x;
	result = prime * result + y;
	return result;
}

@Override //hash code and equals
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Point other = (Point) obj;
	if (x != other.x)
		return false;
	if (y != other.y)
		return false;
	return true;
}
@Override
public Point clone() throws CloneNotSupportedException { //복제하다가 문제가 발생할 수 있음을 알림. Exception.
		return (Point) super.clone();
	}

}



