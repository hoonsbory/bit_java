package day06_ex;

import java.util.Arrays;

public class ex4 {

	public static void main(String[] args) {
		
		
		int[][] arr = new int[4][4];
		for (int a = 0; a < arr.length; a++) {
			for (int b = 0; b < arr.length; b++) {
				if (a == b) {
					arr[a][b] = 1;

				}else {
					arr[a][b] = 0;
				}

			}
			System.out.println(Arrays.toString(arr[a]));

		}
		
	}

}
