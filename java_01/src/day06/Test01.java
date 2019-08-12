package day06;

public class Test01 {

	public static void main(String[] args) {

		int[] num = { 2, 4, 6, 8 };

		int[] num2;
		num2 = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		// 생성과 선언 초기화를 동시에 하지않으면 뉴를 통해 힙영역에 올려서 초기화 해야한다.
		
		String[] arr = {"할 수 ","있다"," 재훈아!"};
		for(int data :num) {
			System.out.print(data);
		}
		for(String data :arr) {
			System.out.print(data);
		}
	}

}
