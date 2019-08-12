package day05_ex;

import java.util.Arrays;

public class prob6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] num = new int[6];

		for (int i = 0; i < num.length; i++) {
			num[i] = (int) (Math.random() * 6) + 1;

		}
		int j;
		int z;
		System.out.println(Arrays.toString(num));
		System.out.println();
		for (j = 0; j < num.length; j++) {
			for (z = 0; z < num.length; z++) {
				if (j != z) {

					if (num[j] == num[z]) {

						num[j] = (int) (Math.random() * 6) + 1;
						z = -1;

					}

				}

			}

		}

		int b = 0;
		int c = 0;
		int count = 0;
		int small = 0;
		for (int a = 0; a < num.length - 1; a++) {
			c = num[a];
			for (b = a + 1; b < num.length; b++) {
				if (c > num[b]) {

					c = num[b];
					small = b;
					

				}

			}
			num[small] = num[a];
			num[a] = c;
			count++;

		}
		System.out.println(count);
		System.out.println(Arrays.toString(num));
	}

}
