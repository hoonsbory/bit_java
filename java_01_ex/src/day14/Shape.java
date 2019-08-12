package day14;

public abstract class Shape {
	private int numSides;

	public Shape(int numSides) {
		super();
		this.numSides = numSides;
	}

	public Shape() {

	}

	public int getNumSides() {
		return numSides;
	}

	public void setNumSides(int numSides) {
		this.numSides = numSides;
	}

	public abstract double getArea();

}
