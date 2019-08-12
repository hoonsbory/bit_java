package day14;

public class Rectangle extends Shape implements Resizeable {
	private double width;

	private double height;

	public Rectangle(double width, double height) {
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
	public void resize(double s) {
		this.width *= s;
		this.height *= s;
		System.out.println("new area = " + this.width * this.height);
	}

	@Override
	public double getArea() {
		setNumSides(4);

		return (width * height);
	}

}
