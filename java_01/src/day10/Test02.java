package day10;

import java.util.Arrays;

public class Test02 {
	//배열 삭제하는법.
	public static void main(String[] args) {
		char[] c = "ABCDEF".toCharArray(); //차의 배열로 만들어 씨에 넣어라. 
		
		int count =6;
		int d = 0;
		
		System.out.println(Arrays.toString(c));
		
		System.arraycopy(c, d+1, c, d, count-d-1);
		c[--count]= ' ';
		System.out.println(Arrays.toString(c));
	}

}
