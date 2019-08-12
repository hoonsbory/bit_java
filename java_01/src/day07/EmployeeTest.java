package day07;

public class EmployeeTest {

	public static void main(String[] args) {
		Employee emp1 = new Employee("김성현","영업부",true); // () 괄호 기본생성자로 부른다.
		emp1.print();
		Employee emp2 = new Employee("고길동","영업부", false); // () 괄호 기본생성자로 부른다.
		emp2.print();
		Employee emp3 = new Employee("신재훈", "개발부", false); // () 괄호 기본생성자로 부른다.
		emp3.print();
		
		
	
	}

}
