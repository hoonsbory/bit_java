package day05_ex;

import java.util.Arrays;

public class problast {

	public static void main(String[] args) {

		
		int[] num = new int[6];
		
		for(int a = 0; a<num.length; a++) {
			num[a] = (int)(Math.random()*45)+1; // 첫포문 안 이중포문 밖에서 난수를 받는다.
			//이중포문안에서 난수선언을 하면 b값이 0이라 포문을 바로 빠져나가서 난수 선언이 안된다.
			for(int b = 0; b<a; b++) {
				
				if(num[a] == num[b]) {
					a--;
					break; //맨위 포문으로 돌아가는 것이 아니라 안에있는 포문을 빠져나왔기 떄문에 a의 값이 1증가하는것이다.
				}
			
				
			}
			
		}
		int count = 0;
		for(int a = 0; a<num.length-1; a++) {
				int min = a;
			for(int b =a+1; b<num.length; b++) {
				if(num[min] > num[b]) {
					min = b;
					
				}
				
			}
			int tmp = num[a];
			num[a] = num[min];
			num[min]= tmp;
			count++;
			
		}
		System.out.println(count);
		System.out.println(Arrays.toString(num));
	}

}
