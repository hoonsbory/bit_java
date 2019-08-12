package interface_ex;

public class RectangleTest {

	public static void main(String[] args) {
		Shape[] r1 = {new Rectangle(new Point(5, 10), 10 ,10), //다중 상속을 하여 배열로 객체 생성가능
				new Rectangle(new Point(5, 10), 10 ,10)};
		System.out.println(r1[1]);
		System.out.println(r1[1].area());
		r1[0].move(5);
		System.out.println(r1[0]);
		r1[1].draw();
		
		for(Shape data: r1) {
			data.draw();
			data.move(4);
			System.out.println(data);
			data.area();
		}
	}

}
