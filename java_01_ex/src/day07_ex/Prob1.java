package day07_ex;

public class Prob1 {

//leftpad 라는 함수를 만든것이다.
	
	
	
	public String leftPad(String str, int size, char padChar) {

		for (int a = str.length(); a < size; a++) {
			// if를 안써도 포문에서 조건을 맞게 걸어줬기 때문에
			// 똑같이 움직임. 이렇게 하면 불필요한 동작이 최소화됨.
			// if(str.length()< size) {

			str = padChar + str; // 연산그대로다. 차 # 옆에 문자열 bit.

			// }

		}

		return str;

	}

	public static void main(String[] args) {
		Prob1 prob1 = new Prob1();

		System.out.println(prob1.leftPad("bit", 6, '#'));
		System.out.println(prob1.leftPad("bit", 5, '$'));
		System.out.println(prob1.leftPad("bit", 2, '&'));

	}

}
