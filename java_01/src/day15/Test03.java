package day15;

import interface_ex.Point;

public class Test03 {

	public static void main(String[] args) {
		Outer.Inner i = new Outer().new Inner();
		i.print();
	}

}

class Outer {
	Point p = new Point(3,3);
	class Inner {
		Outer o;
		void print() {
			System.out.println(p);
		}
}
	
	
}