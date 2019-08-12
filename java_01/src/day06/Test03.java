package day06;

public class Test03 {

	public static void main(String[] args) { // 오브젝트(객체)는 곧 인스턴스

		Employee emp1 = new Employee();
		// 객체생성 임플로이 클래스를 메모리에 올리세요.
		//emp1.age = 201903;
		emp1.setAge(27); //AGE를 쓸 수 있는 메소드 호출함.
		emp1.setName("신재훈");
		//emp1.dept = "마케팅부";
		emp1.setDept("개발부");
		emp1.setSingle(true);

		emp1.display(); // 임플로이 클래스에서 퍼블릭 보이드로 디스플레이 함수를 선언했기때문에 출력가능.
		//디스플레이 함수를 써도 emp1의 주소를 향하기 때문에 주소에 따라 값이 다르게 출력된다.
		//this 키워드는 그 주소안의 값을 부를 떄 사용함. 주소를 사용하지않아도 this키워드를 사용해 호출.
		//this는 힙영역에서만 통용되는 키워드.
		Employee emp2 = new Employee();

		//emp2.age = 201901;
		//emp2.name = "홍길동";
		//emp2.dept = "인사부";
		emp2.display();

		Employee emp3 = new Employee();
		//emp3.age = 201902;
		//emp3.name = "신재훈";
		//emp3.dept = "영업부";
		emp3.display();

		//디스플레이는 퍼블릭이기 때문에 0과 null을 받아오긴한다
	}

}
