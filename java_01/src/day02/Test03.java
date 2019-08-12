package day02;

public class Test03 {

	public static void main(String[] args) {
		
		int x = 600, y = 700, tmp = x;
		
		System.out.println("x=" +x+",y=" +y);
		System.out.printf("x=%d %ny=%d%n",x,y);

		x=y;
		y=tmp;
		System.out.printf("x=%d %ny=%d%n",x,y);
		
		double d1 = 99.9213, d2 = 77.33423, tmp2 = d1;
		
		System.out.printf("d1=%f , d2=%f%n",d1,d2);
		System.out.printf("d1=%5.3f , d2=%5.2f%n",d1,d2);
		
		d1=d2;
		d2=tmp2;
		
		System.out.printf("d1=%7.3f, d2=%6.1f%n",d1,d2);
		
		
		
	}

}
