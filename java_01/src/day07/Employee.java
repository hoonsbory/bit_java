package day07;

/**
 * 
 * @author 신재훈
 * @since 2019 07 16
 * @version 1.0
 * 
 */
public class Employee {

	private String name;
	private String dept;
	private boolean single;

	public Employee() { //생성자함수의 역할은 초기화 작업을 주로 한다. 퍼블릭 + 클래스이름.
	 System.out.println("Employee() call");
	 
	 	name = "사원이름";
	 	dept = "ooo 부서";
	 	single = true; //생성자함수 안에서 값을 초기화 할 수 있음.\
	 	//생성자함수를 쓰기전에는 생성자함수안에 아무것도 들어있지않았다. 
	 	//내가 생성자함수 관여를 시작하면 절대 기본으로 만들어주지않는다.
	 
	 
	}// 이런 함수를 자동으로 가지고있다. (생성자함수)
	public Employee(String name, String dept , Boolean single) {
			this.name = name;
			this.dept = dept;
			this.single = single;
		
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public boolean isSingle() {
		return single;
	}

	/**
	 * 
	 * @param single 솔로유무 판별
	 */
	public void setSingle(boolean single) {
		this.single = single;
	}

	/**
	 * Employee 정보 출력 역할
	 */
	public void print() { // 스태틱 못씀 네임 싱글이 인스턴스자원이라.
		System.out.printf("[이름 : %s , 부서 : %s , 솔로 : %b]%n", getName(), getDept(), isSingle());

		
		
	}
}
