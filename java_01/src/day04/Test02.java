package day04;

public class Test02 {

	public static void main(String[] args) {

		for (int b = 1; b <= 5; b++) {
			for (int a = 5; a >= b; a--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
