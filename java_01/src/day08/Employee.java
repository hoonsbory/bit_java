package day08;

/**
 * 
 * @author 신재훈
 * @since 2019 07 16
 * @version 1.0
 * 
 */
public class Employee {
	 static	String cName="BIT";
	
	private String name;
	private String dept;
	private boolean single;

	public Employee() { 
		//생성자함수의 역할은 초기화 작업을 주로 한다. 퍼블릭 + 클래스이름.
		//디폴트 생성자. 기본생성자
		//객체 생성과정에서만 호출되는 함수.
	 	this("사원이름" ,  "ooo부서" , true); //this로 생성자 함수 호출 this는 제일 첫번째 줄에 위치해야만 한다.
	 	//this() 안에 매개변수에 따라 어떤 생성자 함수를 호줄할지 정해진다
	 	//this.name = "사원이름";
	 	//this.dept = "ooo 부서";
	 	//this.single = true; //생성자함수 안에서 값을 초기화 할 수 있음.\
	 	//생성자함수를 쓰기전에는 생성자함수안에 아무것도 들어있지않았다. 
	 	//내가 생성자함수 관여를 시작하면 절대 기본으로 만들어주지않는다.
	 	//생성자함수는 리턴이 필요없다.
	 
	}// 이런 함수를 자동으로 가지고있다. (생성자함수)
	
	public Employee(String name,String dept,boolean single) {  //메소드 오버로딩
		//생성자함수안에 매개변수를 넣는다. 그럼 임플로이 클래스를 뉴로 메모리에 띄운 후 인수를 넣어 쓸 수 있따.
		//디폴트 생성자. 기본생성자
	 	this.name = name;
	 	this.dept = dept;
	 	this.single = single;
	 	System.out.printf("Employee(%s,%s,%s) call%n" , name, dept,single);
//매개변수와 프라이빗 변수가 이름이 같기때문에 this를 넣어서 이 클래스 안에 있는 변수임을 알려준다.
	 	
	
	 
	 
	}// 이런 함수를 자동으로 가지고있다. (생성자함수)
	public Employee(String name,String dept) {  //메소드 오버로딩
		//생성자함수안에 매개변수를 넣는다. 그럼 임플로이 클래스를 뉴로 메모리에 띄운 후 인수를 넣어 쓸 수 있따.
		//디폴트 생성자. 기본생성자
	 	//this.name = name;
	 	//this.dept = dept;
		this(name, dept,false);
	 
	 	System.out.printf("Employee(%s,%s) call%n" , name, dept);
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
		System.out.println("회사명" + cName);
		
		System.out.printf("[이름 : %s , 부서 : %s , 솔로 : %b]%n", getName(), getDept(), isSingle());

		
		
	}
	
		

		
	
}
