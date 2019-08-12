package day11;

public class Employee extends Person {
	String dept;

	public Employee(String name2, int age2, String dept) {
		super(name2, age2);
		this.dept = dept;

	}
@Override
	public void printA() {
	super.printA();  
	System.out.printf("부      서 : %s%n" ,dept);

	}
}
