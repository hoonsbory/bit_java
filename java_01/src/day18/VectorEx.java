package day18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class VectorEx {
	public static void main(String[] args) {
		// Student[] s = new Student[10]; //스튜던트 타입으로 배열 생성후에
		Vector<Student> list = new Vector<Student>(5,10); // 내부에 Student[] 만들어서 관리 5 크기 만큼 만들고 부족하면 10개를 늘리겟다
		//벡터라 가능 리스트는 안됨.
		System.out.println(list.size()); //현재 사이즈
		System.out.println(list.capacity()); 
		list.add(new Student("신재훈", 100, 100));
		list.add(new Student("신재하", 93, 100));
		list.add(new Student("신재호", 91, 100));
		list.add(new Student("신재현", 80, 100));

		System.out.println(list.capacity()); //수용량 오버되면 알아서 두배로 늘어남.
		Student[] sss = { 	new Student("김씨", 11, 93), 
										new Student("신씨", 12, 63), 
										new Student("한씨", 14, 53),
										new Student("이씨", 15, 33), 
										new Student("송씨", 17, 23) };
		Arrays.sort(sss);
		System.out.println(Arrays.toString(sss));

		// System.out.println(list);
		// System.out.println(Arrays.toString(s));
		Iterator<Student> it = list.iterator();
		while (it.hasNext()) {
			Student student = it.next();
			if (student.getAvg() >= 96) { // 스튜던트 주소로 들어가야함. 스튜던트 타입이니까.
				System.out.println(student);
			}
		}
		System.out.println(list.contains(new Student("신재훈", 100, 100)));
		// 내부적으로 equals 메소드가 없기때문에 비교를 못함
		// 소스에서 이콜즈 오버라이딩 해줘야함.
		// C U R D 크리에이트 업데이트 리서치 딜리트
		Student s1 = new Student("홍길동", 90, 90);
		boolean flag = list.add(s1); // Update
		if (flag)
			System.out.println(s1 + "등록완료");
		else
			System.out.println(s1 + "등록실패");
		// System.out.println(list);
		it = list.iterator(); // 이터레이터는 쓸 때마다 다시 생성해야함.
		System.out.println("=======학생목록==========");
		while (it.hasNext()) {
			Student student = it.next();
			if (student.getName().equals("홍길동")) { // 스튜던트 주소로 들어가야함. 스튜던트 타입이니까.
				// 만약 동명이인이 있다면 같이 값이 바뀌므로 학번같이 학생들을 구분할 수 있는 변수가 있어야함. =>프라이머리 키
				student.setKo(100);
				student.setMath(100);
				student.setAvg(); // 평균도 다시 등록해야함.
				System.out.println(student + "수정완료");
			}
			// System.out.println(student);

		}
		it = list.iterator();
		while (it.hasNext()) {
			Student student = (Student) it.next();
			if (student.equals(s1)) {
				it.remove();
				System.out.println("삭제완료");

			}
		}
		System.out.println(list);

		Collections.sort(list); // 컴패러블 상속받아 추상메소드인 컴페어투가 작동되어 소트가 가능.

		System.out.println(list);

	}
}

//class Student extends Object implements Comparable<Student> { // 컴패러블 상속받아서 정렬가능
//	String name;
//	int ko;
//	int math;
//	double avg;
//
//	public Student() {
//
//	}
//
//	public Student(String name, int ko, int math) {
//		super();
//		this.name = name;
//		this.ko = ko;
//		this.math = math;
//		setAvg();
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public int getKo() {
//		return ko;
//	}
//
//	public void setKo(int ko) {
//		this.ko = ko;
//	}
//
//	public int getMath() {
//		return math;
//	}
//
//	public void setMath(int math) {
//		this.math = math;
//	}
//
//	public double getAvg() {
//		return avg;
//	}
//
//	public void setAvg() {
//		this.avg = (ko + math) / 2.;
//	}
//
//	@Override
//	public String toString() {
//		return "Student [name=" + name + ", ko=" + ko + ", math=" + math + ", avg=" + avg + "]";
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		long temp;
//		temp = Double.doubleToLongBits(avg);
//		result = prime * result + (int) (temp ^ (temp >>> 32));
//		result = prime * result + ko;
//		result = prime * result + math;
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Student other = (Student) obj;
//		if (Double.doubleToLongBits(avg) != Double.doubleToLongBits(other.avg))
//			return false;
//		if (ko != other.ko)
//			return false;
//		if (math != other.math)
//			return false;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		return true;
//	}
//
//	@Override
//	public int compareTo(Student o) {
//
//		// return (int) (o.getAvg() - getAvg()); //국어점수로 비교.
//		// 0보다 크면 내림차순 0보다 작으면 오름차순
//		return name.compareTo(o.name); // 스트링은 빼기가 안되기때문 컴패어투로 비교. 스트링은 이미 컴패러블을 상속받아져있따.
//	}

//}