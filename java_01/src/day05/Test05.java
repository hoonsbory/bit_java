package day05;

public class Test05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1차원배열을 모아서 관리
		int[][] t1 = new int[3][2];

		t1[0][0] = 1;
		t1[0][1] = 2;
		t1[1][0] = 3;
		t1[1][1] = 4;
		t1[2][0] = 5;
		t1[2][1] = 6;

		System.out.println(t1[0][0] + "," + t1[0][1]);

		int[][] t2 = { //큰 괄호로 묶고 1차원 배열을 초기화할때처럼  정방향말고 지그재그로 갈수도잇음
				//생성과 선언 초기화를 한번에 하는 경우가 많다.
				{1,2},{3,4},{5,6}
				
		};
	}

}
