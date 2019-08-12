package day03;

public class Test06 {

	public static void main(String[] args) {
//for는 얼마나 반복될지 모를떄 while은 얼마나 반복될지 알때
//for(초기식,조건식,증감식)

		int i;
		for (i = 1; i <= 10; i++) {
			System.out.println(i + "번째 수행");

		}

		System.out.println(i);

		int j = 10;
		while (j > 0) {
			System.out.println("while" + j);
			j--;

		}
		boolean flag = true;
		while (flag) {
			j++;

			System.out.println("dsfsdf" + j);
			if (j == 5)
				flag = !flag;  //증감하다가 j가 5가 되는 순간 트루값이 플래그를 부정하는 !를 붙여서 값이 false가됨
		//반복이 멈추면 그 값은 for while을 빠져나온다.
		}
		
		while(j<5) {
			
			System.out.println("do while"); //동작안됨
			
			
		}
		
		do { //do는 일단 수행하고 조건을 따짐. 그래서 와일이 뒤에 붙음. 최소 1회 출력을 보장함.
			System.out.println("do while");
		}while(j<4);
		
		
		
		
	}

}
