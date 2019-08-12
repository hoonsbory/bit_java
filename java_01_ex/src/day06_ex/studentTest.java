package day06_ex;

public class studentTest {

	public static void main(String[] args) {

		student stu1 = new student();
		
		stu1.setName("신재훈");
		stu1.setNumber(20120736);
		stu1.setLive("석촌");
		
		
		
		student stu2 = new student();
		
		stu2.setName("김주현");
		stu2.setNumber(20140227);
		stu2.setLive("수원");
		
		student stu3 = new student();
		
		stu3.setName("김성현");
		stu3.setNumber(20130214);
		stu3.setLive("수원");
		
		student[] stu = {stu1, stu2, stu3};
		
		for(student data :stu) {
			if(data.getLive() != null && data.getLive().equals("수원")) {
				data.display();
			}
			
		}
		System.out.println();
		for(student data : stu) {
			if(data.getName().charAt(0) == '김') {
				data.display();
			}
			
		}
	}

}
