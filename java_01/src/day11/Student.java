package day11;

public class Student extends Person {

	int id;

	public Student(String name2, int age2, int id) {
		super(name2, age2);
		this.id = id;

	}

	public Student(String name2, int age2) {
		this(name2, age2, 0);
		
	}
	@Override
	public void printA() {
		super.printA();
		System.out.printf("번      호 :  %s%n", id);

	}
	
	
}
