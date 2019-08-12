package day08_ex;

public class Card {

	final static int HEIGHT = 250; // 어떤 카드던 규격은 변하지 않으므로 모두 그 값을 쉐어하기위해 스태틱.
	final static int WIDTH = 100; //파이널로 상수화처리. 이제 절대 값을 못바꿈 상수화된 변수는 변수명을 올대문자로.
	String kind = "다이아몬드";
	int num;

	public static void main(String[] args) {
		System.out.println(WIDTH+" * " +HEIGHT);
		System.out.println(new Card().kind); // 인스턴스자원이기때문에 뉴 클래스네임으로 객체생성
	}
}
