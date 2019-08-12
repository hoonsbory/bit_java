package day12_ex;

public class Rectangular extends Shape {

	private double width;
	private double height;

	public Rectangular(String name, double width, double height) {
		super(name);
		this.width = width;
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public void calculationArea() {
		System.out.print(getName() + "의 면적은 ");

	}
	@Override
	public void print() {
	//	System.out.printf("%4.1f%n" ,this.width*this.height);
		setArea(this.width*this.height);
		System.out.println(getArea());
	}
}
