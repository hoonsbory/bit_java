package day17;

import java.util.ArrayList;
import java.util.List;

public class DiceGame {
	public static void main(String args[]) {
		DiceGame game = new DiceGame();

		int result1;
		try {
			result1 = game.countSameEye(10);
			System.out.println("면의 개수가 8개인 주사위 2개를  던져서 같은 눈이 나온 횟수 : " + result1);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			int result2 = game.countSameEye(-100);
			System.out.println("면의 개수가 8개인 주사위 2개를  던져서 같은 눈이 나온 횟수 : " + result2);
			
		
		
		
		} catch (Exception e) {
			System.out.println("음수는 나가주세요");
			e.printStackTrace();
		}

		

	}

	int countSameEye(int n) throws Exception {
		if (n <= 0)  throw new Exception();
		
		Dice d = new Dice(8);
		Dice d2 = new Dice(8);
		int count = 0;

		for (int i = 0; i < n; i++) {
			if (d.play() == d2.play()) {
				System.out.println(d.play()+","+d2.play());
				count++;

			}
		}
		return count;

//		int count =0;
//			List<Integer> list = new ArrayList();
//			
//			for(int i =0; i<=n; i++) {
//				for(int j=i+1; j<i; j++) {
//					
//					list.add((int)(Math.random()*8)+1);
//				
//				if(list.get(0) == list.get(1)) {
//					count++;
//				}
//				}
//			}
//		int[] a = new int[100];
//		int[] b = new int[100];
//		int count = 0;
//		try {
//			for (int i = 0; i <= n; i++) {
//				a[i] = (int) (Math.random() * 8) + 1;
//				b[i] = (int) (Math.random() * 8) + 1;
//				if (a[i] == b[i]) {
//					count++;
//
//				}
//			}
//
//		} catch (Exception e) {
//			// if(n<=0 || n>=101) {
//			//System.out.println(e.getMessage());
//			e.getStackTrace();
//		}
//
//		return count;
	}

}
