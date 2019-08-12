package day08;

public class ex1 {


		public static int  max ( int... nums) {
			int max = Integer.MIN_VALUE;
			
				 
			for(int b =1; b<nums.length; b++) {
				if(max < nums[b]) {
					max = nums[b];
					
				}
				
			}
		
				
			
			return max;
			
		}
		
		
	}


