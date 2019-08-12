package day05_ex;

import java.util.Arrays;

public class prob1 {

	public static void main(String[] args) {

		int[] num = new int[6];
		int j = 0;
		int z = j + 1;
		int y = 0;

		/*
		 * for (int i = 0; i < num.length; i++) { num[i] = (int) (Math.random() * 45) +
		 * 1;
		 * 
		 * }
		 */

		for (j = 0; j < num.length; j++) {

			for (y = 0; y < num.length; y++) {

				num[y] = (int) (Math.random() * 45) + 1;

				for (z = y + 1; z < num.length; z++) {

					while (num[y] == num[z]) {
						num[z] = (int) (Math.random() * 45) + 1;

					}
				}
			}

		}
		int c = 0;
		int count = 0;
		for (int a = 0; a < num.length - 1; a++) {

			for (int b = a + 1; b < num.length; b++) {
				if (num[a] > num[b]) {
					c = num[b];
					num[b] = num[a];
					num[a] = c;
					count++;
					System.out.println(Arrays.toString(num));

				}
			}
		}
		System.out.println(count);
	}
}
