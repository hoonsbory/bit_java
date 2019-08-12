package day14;

public class ShapeTest {

	public static void main(String[] args) {

		Shape[] s = { new Rectangle(5, 6), 
								new RecTriangle(6, 2) };

		for (Shape data : s) {

			System.out.println("area = " + data.getArea());
			if (data.getNumSides() == 4) {
				//data instanceof Resizeable 인스턴스 오브 타입비교 연산자. 불리언타입임
				((Rectangle) data).resize(0.5);

			}

		}

	}
}
