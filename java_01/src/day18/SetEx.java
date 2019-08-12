package day18;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JOptionPane;

public class SetEx {
	public static void main(String[] args) {
		
		String a = JOptionPane.showInputDialog("사원번호를 입력하시오");
		String b = JOptionPane.showInputDialog("사원이름를 입력하시오");
		String c = JOptionPane.showInputDialog("사원부서를 입력하시오");
		
		Set<Employee> set = new HashSet<Employee>(); //hashset은 주머니같은 것 Set은 들어간 순서대로 출력되지않음.
//		set.add(new Employee(2017001, "신씨", "개발부")); //이콜즈 오버라이딩해야 중복 제거됨.
//		boolean flag = set.add(new Employee(2017001, "신씨", "개발부")); //불리언타입으로 중복 판별
//		
//		if(!flag) System.out.println("이미 있는 데이타 입니다");
//		set.add(new Employee(2017002, "김씨", "마케팅부"));
//		set.add(new Employee(2017003, "김씨", "마케팅부"));
//		set.add(new Employee(2017003, "씨", "마케팅부"));
		set.add(new Employee(Integer.parseInt(a), b, c));
		Iterator<Employee> i = set.iterator();
		while (i.hasNext()) {
			Employee data = i.next();
			System.out.println(data); //투스트링 오버라이딩해야 주소가 안찍히고 값이 찍힌다.
		}
		System.out.println("===========검색=======================");
			i = set.iterator();
			while (i.hasNext()) {
				Employee data =  i.next();
				if(data.number == 2017002) {
					System.out.println(data);
				}
				
			}
			
		
			
		};
		
	}


class Employee implements Comparable<Employee>{
	
	int number; 
	String name;
	String dept;
	public Employee() {
		
		
	}
	public Employee(int number, String name, String dept) {
		super();
		this.number = number;
		this.name = name;
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee [number=" + number + ", name=" + name + ", dept=" + dept + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result + ((dept == null) ? 0 : dept.hashCode());
//		result = prime * result + ((name == null) ? 0 : name.hashCode()); 사번중복만 피하고 싶을땐 이렇게
		result = prime * result + number;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
//		if (dept == null) {  사번중복 회피. 이름과 부서는 같아도 됨.
//			if (other.dept != null)
//				return false;
//		} else if (!dept.equals(other.dept))
//			return false;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
		if (number != other.number)
			return false;
		return true;
	}
	@Override
	public int compareTo(Employee o) {

		return (int) (number - o.number);
	}
	
	
	
	
}


