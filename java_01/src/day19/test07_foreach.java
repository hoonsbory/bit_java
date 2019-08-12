package day19;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

import day18.SetEx;

public class test07_foreach {
	public static void main(String[] args) {
		List<Employee> emp = new ArrayList<Employee>();
		emp.add(new Employee(20190201, "신길동", "영업부"));
		emp.add(new Employee(20190202, "김길동", "개발부"));
		emp.add(new Employee(20190203, "갈길동", "마케팅부"));
		emp.add(new Employee(20190204, "홍길동", "베이비부"));
		emp.add(new Employee(20190205, "동길동", "영업부"));

		System.out.println("=========Iterator===========");

		Iterator<Employee> it = emp.iterator();
		while (it.hasNext()) {
			Employee data = (Employee) it.next();
			System.out.println(data);

		}
		System.out.println();
		System.out.println("=========foreach===========");

		emp.forEach(new Consumer<Employee>() { // 포이치는 컨슈머를 상속받기 때문에 컨슈머를 객체생성해주고 오버라이딩해야함.

			@Override
			public void accept(Employee t) {
				System.out.println(t);

			}
		});

		System.out.println("===============람다로 표현======================");
		emp.forEach((Employee t) -> {

			System.out.println(t);
		}

		);
		System.out.println("===============람다로 표현22222======================"); // 이거시 람다.
		// 포이치랑 비교해보고 어떤 걸 생략할 수 있는지 알아야한다.
		emp.forEach(t -> {

			System.out.println(t);
		}

		);
		System.out.println("===============람다로 표현22222======================"); // 이거시 람다.
		// 포이치랑 비교해보고 어떤 걸 생략할 수 있는지 알아야한다.
		emp.forEach(

				System.out::println  //이건 진짜 미친 생략. 막 줄여 다 줄여

		);
	}
	//map.forEach((k,v) -> 맵에서는 이렇게 포이치 람다
}
