package day13;

import java.util.Arrays;

import interface_ex.Point;

public class Rectangle {
	//int width;
	//int height;
	Point[] p = new Point[4];

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(p);
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
		if (!Arrays.equals(p, other.p))
			return false;
		return true;
	}
	
}
