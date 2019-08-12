package day12;

public class Circle extends Shape {

	private double radius;

	public Circle(String name, double radius) {
		super(name);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public void calculationArea() {
		// System.out.print(getName() + "의 면적은 ");
		setArea(this.radius * this.radius * Math.PI);
	}
//	@Override
//	public void print() {
//		//System.out.printf("%16.13f%n" ,this.radius*this.radius*Math.PI);
//		
//		setArea(this.radius*this.radius*Math.PI);
//		System.out.println(getArea());
//	}

}
