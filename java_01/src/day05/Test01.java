package day05;

import java.util.Arrays;

public class Test01 {

	public static void main(String[] args) {

		int num1 = 99;
		int num2 = num1; // 콜 바이 밸류 . 복사되는 느낌. 즉 그 순간 한번만 값이 덮어씌워진다.
		System.out.println("num1=" + num1 + " , num2=" + num2);
		num1 = 77;
		System.out.println("num1=" + num1 + " , num2=" + num2);
		int[] n1 = { 11, 22, 33, 44, 55 };
		int[] n2 = n1; // 배열은 선언한 순간 주소가 생기기때문에 같은 주소를 공유함. 즉 데이터도 공유함.
		// call by value, call by reference
		int[] n3 = new int[n1.length]; // 값이 변화할 수 있기때문에 렝스로.
		for (int i = 0; i < n1.length; i++) {
			n3[i] = n1[i]; //배열 카피방법.
			//배열은 메모리에 올라가면 리사이징이 안돼서 더 크게 할려면 더 큰 배열을 만들어서 카피해야함.
		}
		System.out.println(Arrays.toString(n1));
		System.out.println(Arrays.toString(n2));
		System.out.println(Arrays.toString(n3));
		n1[2] = 0;
		System.out.println(Arrays.toString(n1));
		System.out.println(Arrays.toString(n2));
		System.out.println(Arrays.toString(n3));
		//n3은 카피기 때문에 n1이 0으로바뀌것에 대한 영향을 받지 않는다.

	}

}
