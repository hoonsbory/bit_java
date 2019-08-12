package day18;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JOptionPane;

public class SetEx2 {
	public static void main(String[] args) {
		Set<Employee> set = new  TreeSet<Employee>(); //hashset은 주머니같은 것 Set은 들어간 순서대로 출력되지않음.
		
		set = (Employee)JOptionPane.showInputDialog("message");
//		set.add(new Employee(2017001, "신씨", "개발부")); //이콜즈 오버라이딩해야 중복 제거됨.
//		boolean flag = set.add(new Employee(2017001, "신씨", "개발부")); 
//		
//		if(!flag) System.out.println("이미 있는 데이타 입니다");
//		set.add(new Employee(2017002, "김씨", "마케팅부"));
//		set.add(new Employee(2017003, "김씨", "마케팅부"));
//		set.add(new Employee(2017003, "씨", "마케팅부"));
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



	
	



