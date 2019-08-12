package day14;

public class RecTriangle extends Shape {
	private double width;
	private double height;

	public RecTriangle(double width, double height) {
		super();
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
	public double getArea() {
		setNumSides(3);
		return (width * height) / 2;
	}

}
