package day06;

public class Test02 {

	public static void main(String[] args) { // 오브젝트(객체)는 곧 인스턴스
		
		Employee emp1 = new Employee(); 
		// 객체생성 임플로이 클래스를 메모리에 올리세요.
		emp1.age = 201903;
		//emp1.name = "훈재신";
		//emp1.dept = "마케팅부";
		System.out.println(emp1.getAge() + " : " + emp1.getName() + " : " + emp1.getDept());

		Employee emp2 = new Employee();

		emp2.age = 201901;
		//emp2.name = "홍길동";
		//emp2.dept = "인사부";
		//System.out.println(emp2.age + " : " + emp2.name + " : " + emp2.dept);

		//Employee emp3 = new Employee();
		/*emp3.age = 201902;
		//emp3.name = "신재훈";
		//emp3.dept = "영업부";
		//System.out.println(emp3.age + " : " + emp3.name + " : " + emp3.dept);

	}

}
