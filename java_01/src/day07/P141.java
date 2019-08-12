package day07;

import java.util.Arrays;

public class P141 {

	public void increase(int[] n) { // 스태틱이 없는 메소드라 new로 메모리에 올려야 쓸 수 있음.
		for (int i = 0; i < n.length; i++) {
			n[i]++;

		}

	}

	public static void main(String[] args) {
		P141 p = new P141();
		// 인크리즈는 스태틱한 메소드가 아니기에 뉴를 통해 메모리에 올려준다.
		int[] data = { 10, 100, 1000 };
		// 인크리즈 함수는 배열이기때문에 배열 data를 선언 및 초기화한다

		System.out.println(Arrays.toString(data));

		p.increase(data); // data 배열이 위의 인크리즈 함수를 만나 포문을 수행함. 주소를 넘겨줌.

		System.out.println(Arrays.toString(data));

	}

}
