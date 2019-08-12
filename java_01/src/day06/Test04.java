package day06;

import java.util.Arrays;

public class Test04 {

	public static void main(String[] args) {
		Employee emp1 = new Employee();
		emp1.setAge(27); // AGE를 쓸 수 있는 메소드 호출함.
		emp1.setName("신재훈");
		emp1.setDept("개발부");
		emp1.setSingle(true);
//set으로 값을 넣어준다. 다른 클래스에서 프라이빗화 했지만 셋 겟 메소드로 사용이 가능하다.
		Employee emp2 = new Employee();

		emp2.setAge(25);
		emp2.setName("홍길동");
		emp2.setDept("인사부");

		Employee[] emp = { emp1, emp2 };

		for (Employee data : emp) {
			 if(data.getDept().equals("개발부"))
			 data.display();
			//System.out.println(data.getDept()); //부서명만 출력.

			
		}
		for (int i = 0; i < emp.length; i++) {
			if (emp[i].isSingle()) {
				emp[i].display();

			}

		}
	}

}
