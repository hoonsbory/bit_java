package interface_ex;

public class TestCircle {

	public static void main(String[] args) {
		Circle2 c1 = new Circle2(new Point(5,5),  4);
		System.out.println(c1);
		c1.move(4);
		System.out.println(c1);
		c1.draw();
	System.out.println("==============직사각형 테스트===========================");
		
	Rectangle r1 = new Rectangle(new Point(5, 10), 10 ,10);//다중 상속을 하여 배열로 객체 생성가능
				;
		System.out.println(r1);
		System.out.println(r1.area());
		r1.move(5);
		System.out.println(r1);
		r1.draw();
		System.out.println("=================통합 테스트====================");
		Shape[] shapes = {c1,r1};
		for(Shape data : shapes) {
			System.out.println(data);
			System.out.println(data.area());
			data.move(1);
			data.draw();
			System.out.println(data);
		}
		
		}
	}


