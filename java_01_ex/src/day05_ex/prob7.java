package day05_ex;

import java.util.Arrays;

public class prob7 {

	public static void main(String[] args) {

		int[] num = null;
		num = new int[6];

		for (int i = 0; i < num.length; i++) {
			num[i] = (int) (Math.random() * 6) + 1;
			for (int j = 0; i > j; j++) { // 기준점 i는 계속 이동하고 j는 아이 -1까지만 증가해서 비교.
				if (num[j] == num[i]) {

					i--;
					break;
					// i값을 1마이너스한 후 브레이크를 걸어 다시 맨위 포문으로 돌아간다.
					// 그럼 i값은 그대로기 떄문에 다시 난수를 발생해서 중복을 피한다.
				}
			}

		}
		System.out.println(Arrays.toString(num));
		int count = 0;
		for (int i = 0; i < num.length - 1; i++) {
			int min = i; //위의 포문에 변수를 선언하고 i값으로 초기화를 해준다.
			for (int j = i + 1; j < num.length; j++) {
				if (num[min] > num[j]) {
					min = j; // j위치의 값이 더작을때  민 값에 j를 대입.
					// 고로 이 포문을 빠져나갈때의 num[min]이 가장 작은 값.

				}
				System.out.println(i + "  =>  " + count);
			}
			if (i != min) { 
				//같지않을떄라고 선언하지않아도 값은 그대로다 . 하지만 불필요한 연산이 더해지기때문에
				//선언을해서 속도를 빠르게 함.
				int tmp = num[i];
				num[i] = num[min];
				num[min] = tmp;
				count++;
			}
		}
		System.out.println(Arrays.toString(num));
		System.out.println(count);
	}

}
