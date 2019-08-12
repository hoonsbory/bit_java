package day13;

import interface_ex.Circle2;
import interface_ex.Drawable;
import interface_ex.Point;

public class Test03 {

	public static void main(String[] args) {
		Circle2 c1 = new Circle2(new Point(5,5),3);
		System.out.println(c1);
		System.out.println(c1.area());
		c1.draw();
		((Drawable)c1).draw();
	}

}
