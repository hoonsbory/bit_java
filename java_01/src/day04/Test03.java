package day04;

public class Test03 {

	public static void main(String[] args) {

		OUT: for (int a = 1; a < 10; a++) {

			for (int b = 1; b < 10; b++) {
			//	if (b == 5)
					//break OUT; // b가 5가됐을떄 브레이크. 고로 4단까지만 출력됨. OUT이라는 이름을 붙여서
				//(라벨링작업)밖에 있는 포문밖으로 나감.
				// 컨티뉴는 b가 5가 됐을때 5행만 처리를 하지않고 넘어감.

				System.out.printf("%d*%d=%2d |", b, a, a * b); // 2는 자릿수 b가 단이다.
				// 이중 포문 중 안에있는 포문은 행이다. 행을 수행하는 안 줄은 변하지않는다.
			}
			System.out.println();
		}

	}

}
