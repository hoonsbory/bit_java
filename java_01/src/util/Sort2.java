package util;

import java.util.Arrays;

public class Sort2 {

	public static void main(String[] args) {  
		Sort s = new Sort();
		int[] data = {15,8,26,11,1};
		
		
		int[] result = s.sort(data);
		System.out.println("원본 배열" + Arrays.toString(data));
		System.out.println("정렬된 배열"+ Arrays.toString(result));
		
		
				
	}
}
