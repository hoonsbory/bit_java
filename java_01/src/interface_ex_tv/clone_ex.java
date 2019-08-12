package interface_ex_tv;

import java.util.Arrays;

import interface_ex.Point;

public class clone_ex {

	public static void main(String[] args) throws CloneNotSupportedException {

			int[] num = {11,22,33,44,55};
	 
			//int[] num2 = num;  //num의 주소를 num2에 집어넣은거라 주소가 같아서 num2를 바꿔도 num에 저장됨.
			int[] num2 = num.clone(); //이건 주소를 넣는게 아니라 값 자체를 복제해버리는거라 상관없음.
			num2[2] = 0;
			System.out.println(num);
			System.out.println(num2);
			System.out.println(Arrays.toString(num));
			System.out.println(Arrays.toString(num2));
			System.out.println("=========================================================");
			Point p = new Point(5,5);
			Point p2 = p.clone();  //복제함. Cloneable 인터페이스를 통해서.  객체의 복제
			p.setX(0);
			System.out.println(p);
			System.out.println(p2);
	}
	
}
