package day11;

import java.util.Arrays;

public class Test02 {

	public static void main(String[] args) {

		Person[] stu = { new Student("홍길동", 20, 200201), 
									new Teacher("이순신", 30, "J A V A"), // 자식에 부모를 담을 순 없음.
									new Employee("유관순", 40, "교 무 과")  //부모타입의 배열에 자식타입의 객체를 넣음.
									//"2343423"  만약 퍼슨이 아니라 오브젝트 타입으로 선언하면 스트링도 넣을 수 있다.
		};
//		for(Person data:stu) {
//			data.printA();
//			System.out.println();
//		}
//		System.out.println("-------------------------------------------------------------------------");
		
//		for(Person data:stu) { //캐스팅없이 출력해보자.
//			if(data instanceof Student) ((Student)data).print(); //인스턴스오브를 통해 타입에 맞게 다운캐스팅. 왜 대괄호 생략해도되는거지.>??
//			if(data instanceof Teacher)((Teacher)data).print(); //인스턴스오브 = 데이터가 티처 타입이 아니면. 다운캐스팅해라.
//			if(data instanceof Employee)((Employee)data).print();//반드시 하단부에 어떤 객체가 바인딩 되어있는지 타입체크필요
//			//데이터가 이 타입이 맞나요? 맞으면 true값이 리턴되어 이프조건이 충족되어서 다운캐스팅함/.
//		}
//	}
		for(Person data : stu) {
			data.printA();
		}
		
//		callD(stu[0]);
//		callD(stu[1]);
//		callD(stu[2]);
//	}
//	public static void callD(Person a) {
//		a.printA();
//		
//	}

	}
}
