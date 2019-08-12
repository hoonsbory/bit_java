package day08_ex;

public class ex1 {


		public static int  max ( int... nums) {
			int max = Integer.MIN_VALUE;
			
				 
			for(int b =0; b<nums.length; b++) {
				if(max < nums[b]) {
					max = nums[b];
					
				}
				
			}
		
				
			
			return max;
			
		}
		
		
	}


