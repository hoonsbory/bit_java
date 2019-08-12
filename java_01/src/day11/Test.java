package day11;

public class Test {

	public static void main(String[] args) {
		 Person  stu = new Student("홍길동", 20, 200201);
		 Person tea = new Teacher("이순신", 30, "J A V A"); //자식에 부모를 담을 순 없음.
		 Person emp = new Employee("유관순", 40, "교 무 과");  //부모타입으로 변수 선언후 자식 생성자함수를 메모리에 띄움.
		// stu.printA();
		// tea.printA();
		// emp.printA();
		//Student a = new Student("홍길동", 20, 200201); // 굳이 메모리를 변수선언과 함께할 필요가 없다.
		//new Teacher("이순신", 30, "J  A  V  A").print();
		//new Employee("유관순", 40, "교  무  과").print();
		
		Person p = stu;
		
		((Student)p).printA(); //스튜던트로 다운캐스팅 후 스튜던트의 프린트 메소드 호출.
		
		 p =  tea;
		((Teacher)p).printA();
		
		p = emp;
		((Employee)p).printA();
		

	}

}
