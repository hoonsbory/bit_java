package day05;

import java.util.Arrays;

public class Test04 {

	public static void main(String[] args) {

		System.out.println((int) (Math.random() * 10));// 난수발생 0이상 1미만 실수가 나옴. 고로 더블형.

		// 정수로 형변환하면 0만나옴 소수점이 짤려서 . 뒤에 10을곱하면 정수가 나옴.

		if (args.length == 0) {
			System.out.println("배열의 사이즈 정보를 실행 매개변수로 넘겨주세요");
			System.out.println("실행예) java day05.Test04 5");
			return; // 아규즈 배열 사이즈가 0이면 리턴.

		}

		int[] nums = new int[Integer.parseInt(args[0])];

		for (int i = 0; i < nums.length; i++) {

			nums[i] = (int) (Math.random() * 45) + 1;

		}

		System.out.println("--------------정렬--------------------");
		System.out.println(Arrays.toString(nums));

		int[] in = { 1, 9, 8, 2, 4 };
		int c;
		int count = 0;
		int v = 0;
		for (int a = 0; a < in.length - 1; a++) {

			for (int b = a + 1; b < in.length; b++) {
				if (in[a] > in[b]) {
					c = in[b];
					
					
					System.out.println(Arrays.toString(in));

					System.out.println(c);

				}
				System.out.println(Arrays.toString(in));
				System.out.println(count);
			}

		}
	}
}
