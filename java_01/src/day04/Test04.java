package day04;

import java.util.Arrays;

public class Test04 {

	public static void main(String[] args) {
		// array; 첨자 있는 변수. 위치인덱스가 반드시 따라다님. 인덱스는 항상 0부터시작
		// ex) a라는 인트타입 변수의 인덱스 a[0] a[1] .... 쭉 인트타입
		// 배열은 1) 선언하고 2) 생성하고 3) 초기화 한다.
		// 인트타입 배열은 뉴키워드를 사용하면 힙영역에 얼로케이트되고 모든 만들어진 인트타입들은 0으로 초기화된다.
		// 배열은 위치첨자가 따라다니는 데이터다.
		// 참조형 타입의 배열선언은 힙영역에서 null로 초기화된다.
		// 스트링타입 배열에 스트링값을 넣으면 힙이 아니라 상수화 처리되는 곳으로 값이 간다.
		int[] scores; // 배열선언 [] 참조형으로 바뀜. 주소가 생기기때문. 배열표시 []를 scores[] 이렇게도 사용가능
		scores = new int[5]; // 배열생성 뉴키워드로 메모리에 올림.

		for (int a = 0; a < 5; a++) {
			System.out.print(scores[a] + "    ");
		}
		System.out.println();

		String[] name = new String[5];
		for (int a = 0; a < 5; a++) {
			System.out.print(name[a] + " ");

		}

		System.out.println("\n=============================");

		scores[0] = 99;
		scores[1] = 100;
		scores[2] = 69;
		scores[3] = 79;
		scores[4] = 89;

		name[0] = "홍길동";
		name[1] = "박길동";
		name[2] = "김길동";
		name[3] = "신길동";
		name[4] = "황길동";

		double avg = 0.0;
		int sum = 0;
		for (int i = 0; i < scores.length; i++) {
			sum += scores[i]; // 섬에 스코어 변수에 있는 수를 다 더하라.

		}
		avg = sum / scores.length;

		System.out.println(Arrays.toString(scores)); // 배열주소를 넘겨주면 데이터를 다 꺼내서 문자열로 만들어줌
		System.out.println(Arrays.toString(name));

		// 홍** 99 평균이상

		for (int i = 0; i < name.length; i++) {
			System.out.println(name[i].charAt(0) + "**  " + scores[i] + (scores[i] >= avg ? "평균이상" : "평균미달"));

		}
		double sam = 0.0;
		for(int data: scores) {
			sam += data;
		}
		System.out.printf("평균 = %.2f", sam/scores.length);
	}
}
