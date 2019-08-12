package day03;

public class Test07 {

	public static void main(String[] args) {

		int i;
		int sum = 0;
		int sum4 = 0;
		for(i = 1; i<=100; i++) {
			//sum = sum+i;
			sum +=i;
			if(i%4 == 0)sum4 += i; //i의 값이 4의배수일때는 나머지가 0이므로 4의 배수만 더한다.
			
			
			
			
			
			

	}
		System.out.println(sum);
		System.out.println(sum4);

		
		
		for(int q = 1; q<=6; q++  ) {
			
			
			for(int w = 1; w<q; w++){
				
				System.out.print("*");
				
				
			}
			System.out.print("\n");
		}
	}

}
