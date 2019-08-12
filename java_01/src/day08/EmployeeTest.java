package day08;

public class EmployeeTest {

	public static void main(String[] args) {

		Employee emp1  = new Employee(); 
		
	
		emp1.print();
		Employee emp2  = new Employee("김주현", "개발부" );
		emp2.print();
		Employee emp3  = new Employee("김성현", "개발부" ,  true);//();  >>> 기본생성자로 객체 생성하겠습니다 라는 뜻.
		emp3.print();
		Employee emp4 = new Employee("신재훈", "개발부" ,  false);
		emp4.print();
		
	}

}
