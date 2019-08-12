package day11;

public class Teacher extends Person {
	String subject;

	public Teacher(String name2, int age2, String subject) {
		super(name2, age2);

		this.subject = subject;

	}
@Override
	public void printA() {
		super.printA();  //중복코드를 피하기위해 부모에서 받아오는 네임과 에이지를 출력하는 메소드 프린트를 부모클래서에서 만들고
		//슈퍼를 통해 불러옴.
		System.out.printf("담당과목 :  %s%n", subject);

	}

}
