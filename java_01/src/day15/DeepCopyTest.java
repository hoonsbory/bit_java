package day15;

import interface_ex.Circle2;
import interface_ex.Point;

public class DeepCopyTest {
	public static void main(String[] args) throws CloneNotSupportedException {
		Point p1 = new Point(5,5);
		Point p2 = p1.clone();
		
		Circle2 c1 = new Circle2(new Point(7,7), 2);
		Circle2 c2 = c1.clone();
		    
		
	//	c1.setP(new Point(1,5));
		c2.p.setX(50);
		System.out.println(c1);
		System.out.println(c2);
	}
}
