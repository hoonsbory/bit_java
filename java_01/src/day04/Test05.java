package day04;

import java.util.Arrays;

public class Test05 {

	public static void main(String[] args) {
		// 배열의 생성과 초기화를 동시에
		int[] scores = {};
		String[] names = { "홍길동", "무길동", "구길동", "훈길동", "재길동", "신길동" };

		System.out.println(Arrays.toString(scores));
		System.out.println(Arrays.toString(names));

		if (names.length > 6)
			System.out.println(names[6]);

		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");

		for (String data : names) { // 새로나온 포문. 배열 네임스를 데이터라는 변수안에 모두ㅡ 받아버린다.
			System.out.println("**" + data.charAt(data.length() - 1)); // 데이터에 있는 문자열들의
			// 길이중 -1을해주어 마지막글자만 뽑아냄.

		}
		double sum = 0.0;
		for(int data: scores) {
			sum += data;
		}
		System.out.printf("평균 = %.2f", sum/scores.length);
	}
}
