package day07;

import util.MyUtil;

public class MyMathTest {

	public static void main(String[] args) {

		System.out.println(MyUtil.add(33, 99));
		System.out.println(MyUtil.add(33, 99));
		System.out.println(MyUtil.add(33.01, 99.3, 11.1));
		System.out.println(MyUtil.add(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

		// 오토박싱 언박싱
		int i = 100;
		// Integer ii = new Integer(100);
		Integer ii = i; // 기본형은 필요에따라 자동으로 객체(레퍼런스)와 기본형을 넘나든다.
						// 그래서 레퍼형 타입에도 객체로써 쓰일 수 있따.
		i = ii;
		System.out.println(i + "," + ii);
	}

}
