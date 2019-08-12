package day20;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class test01 {
	public static void main(String[] args) {
		List<Integer> list = new LinkedList<Integer>();
		list.add(5);
		list.add(10);
		list.add(15);
		list.add(20);

		list.forEach(i -> System.out.println(i));
		System.out.println();

		list.removeIf(i -> i % 2 == 0); // 조건 삭제
		list.forEach(i -> System.out.println(i));

		List<Employee> emp = new ArrayList<Employee>();
		emp.add(new Employee(20120736, "신재훈", "영업부"));
		emp.add(new Employee(20120735, "박영선", "인사부"));
		emp.add(new Employee(20120734, "노성진", "마케팅부"));
		emp.add(new Employee(20120733, "홍길동", "베비부"));

		System.out.println(emp.stream().filter(i -> i.getNumber() > 20120734).count());
		// 필터링을 넣어 34보다 큰 사번 몇명인지 확인 후 출력 Stream

		emp.stream().filter(i -> i.getNumber() > 20120734).forEach(i -> System.out.println(i));

		Employee[] e = {

				new Employee(20120732, "홍길동", "베비부"), 
				new Employee(20120731, "고길동", "영업부"),
				new Employee(20120730, "김길동", "개발부"),

		};
		System.out.println("=======배열 핸들링==================");
		Stream.of(e).filter(i->i.getDept().equals("개발부")).forEach(i->System.out.println(i));  
		//스트림오브로 기존 배열을 스트림으로 바꾸고 필터링.
		Stream.of(e).sorted().forEach(i->System.out.println(i));
		System.out.println("================컴페레이터-======================");
//		Stream.of(e).sorted(new Comparator<Employee>() { //컴패러블이 아니라 컴패레이터.
//
//			@Override
//			public int compare(Employee o1, Employee o2) {
//				
//				return o1.getName().compareTo(o2.getName());  //이름순으로 정렬
//			}
//		}).forEach(i->System.out.println(i));
		
		Stream.of(e).sorted((o1,o2) -> o1.getName().compareTo(o2.getName())).forEach(i->System.out.println(i)); //위에껄 람다식으로 표현
	// e를 스트림으로 만들고 두 값을 솔트한다. 겟네임과 겟네임을 비교 포이치로 반복출력. 
	}
}
