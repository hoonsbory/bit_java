package day12_ex;

import java.util.Arrays;

public class Parent {
	public static void main(String[] args) {
		int[] a = new int[6];

		for (int i = 0; i < a.length; i++) {
			a[i] = (int) (Math.random() * 6) + 1;
			for (int j = 0; j < i; j++) {
				if (a[i] == a[j]) {
					i--;
					break;
					
				}
				System.out.println(Arrays.toString(a));
			}
		}
		
	}
}
