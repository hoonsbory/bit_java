package day04_ex;

public class prob4 {

	public static void main(String[] args)  {

		String sourceString = "everyday we have is one more than we deserve";
		String encodedString = "";

		// 프로그램을 구현부 시작.
		// 참고 : 문자 'a'의 정수값은 97이며, 'z'는 122입니다.

		// 프로그램 구현부 끝.
		char b;
		for (int a = 0; a < sourceString.length(); a++) { // 문자열 사이즈 -1이 마지막 문자
			b = sourceString.charAt(a);
			if (b == 'x' || b == 'y' || b == 'z') {

				encodedString += (char) (b + 23);

			} else if (b == ' ') {
				encodedString += b;
			} else if ('a' <= b && b <= 'z')
				encodedString += (char) (b + 3);
		}
	

	/*
	 * } else if (120 <= sourceString.charAt(a) && sourceString.charAt(a) <= 122) {
	 * encodedString += (char) (b - 23);
	 * 
	 * } else { encodedString += b; }
	 * 
	 * }
	 */

	System.out.println("암호화할 문자열 : "+sourceString);System.out.println("암호화된 문자열 : "+encodedString);

	System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

	int a;
	int d;
	int sum = 0;for(a=1;a<=10;a++)
	{

		for (d = 1; d <= a; d++) {

			sum += d;
		}

		System.out.println();
	}System.out.println("결과는 ="+sum);

	for(
	int z = 1;z<=10;z++)
	{

		{
			for (int x = 10; x >= z; x--)
				System.out.print(" ");

			for (int c = 1; c < z; c++)
				System.out.print("*");
			for (int v = 1; v <= z; v++)
				System.out.print("*");
		}
		System.out.println();
	}

	int sam = 0;for(
	int qw = 1;qw<=10;qw++)
	{

		for (int qe = 1; qe <= qw; qe++) {

			sam += qe;

		}
		System.out.println();

	}System.out.println(sam);

}
}
