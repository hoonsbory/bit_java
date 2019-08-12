package day08_ex;

public class ex3 {

	public static int max(int... num) {
		int max = Integer.MIN_VALUE; //인트값의 가장 작은값. 인수에 음수가 들어오면 처리를 못하기 때문.
		for(int data:num) {
			if(max < data) {
				max = data;
			}
	
			}
		return max;
		}

}


