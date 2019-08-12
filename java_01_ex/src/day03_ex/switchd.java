package day03_ex;

import java.util.Scanner;

public class switchd {

	public static void main(String[] args) {

		int b;
		int c;
		int d;
		for (int a = 1; a <= 6; a++) {

			for (b = 6; b >= a; b--) {
				System.out.print(" ");
			}

			for (c = 1; c <= b+1; c++) {

				System.out.print("*");
			}
			for(d =1; d<=b; d++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}

		

	}
}
