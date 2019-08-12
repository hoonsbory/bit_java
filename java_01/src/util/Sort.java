package util;

import java.util.Arrays;

public class Sort {

	public int[] sort(int[] nums) { // 인트타입의 배열로 리턴
		//지금 이 정렬하는 메소드를 자주 쓰기때문에 함수로 만들어 바로바로 정렬 메소드를 호출한다
		int[] data2 = new int[nums.length];
		int count = 0;

		System.arraycopy(nums, 0, data2, 0, nums.length); //어레이카피 중요 ************
		
		//넘즈와 똑같은 배열 data2를 만들어서 정ㄹ렬하고 그 값을 리턴함. 그럼 함수를 수행한 s.sort(data)는 
		//정리된 data2 배열값을 받아서 정렬되어있고 그냥 data는 아무값도 반환받지 못하여 원본배열 그대로다.
		for (int a = 0; a < data2.length - 1; a++) {
			int min = a;
			for (int b = a + 1; b < data2.length; b++) {
				if (data2[min] > data2[b]) {
					min = b;

				}

			}
			int tmp = data2[a];
			data2[a] = data2[min];
			data2[min] = tmp;

		}

		return data2;

	}

}
