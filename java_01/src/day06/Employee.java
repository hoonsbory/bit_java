package day06;

public class Employee {
	// 임플로이라는 새로운 데이터 타입 하나가 만들어짐.
	// 뉴 키워드를 통해 메모리에(힙영역) 할당하는 것을 객체생성, 인스턴스 생성 이라함.
	// 이런 클래스들을 모아놓은게 라이브러리. (.jar)확장자.

	private String name; // 퍼블릭하게 만들어줘야 다른 패키지에서 임플로이 클래스를 사용가능.
	private String dept; // 퍼블릭이 없는 경우 접근지정자가 디폴트라 한다. 패키지가 같아야만 접근가능함.
	private int age; // 201901
	
	private boolean single;
	// 프라이빗 = 데이터히든. 이 클래스 안에서만 사용가능.
	// 바꾸고싶은 변수명 블락처리하고 리펙터로 바꾸면 한번에 다바뀜. 이 임플로이 클래스가 임포트돼있는 클래스.

	public void display() { // 리턴뒤에 데이터없이 그냥 돌아가는게 void. return은 값을 가지고 돌아감.
		// 그냥 할 일만 하고 돌아가는게 보이드. 할 일을 하고 그 결과값을 가지고 오는게 return.
		System.out.printf("[나이 :%d, 이름  : %s,  부서 : %s , 쏠로 : %b]%n", this.age, this.name, this.dept, this.single);
		// this가 생략된것. 나의 넘버 나의 네임.
		// 임플로이 클래스에서 퍼블릭 보이드로 함수를 만들었다. 다른 클래스에서 display메소드를 호출 가능.
		return;
	}

	public void setAge(int age) { //인캡슐레이션
		if (!(age > 0 && age <= 100)) {
			System.out.println("나이 정보가 올바르지 않습니다");
			return;
		}
		this.age = age; // 왼쪽에 있는 에이지는 멤버변수이기 때문에 this를 써줘야한다.
		// this는 지금 이 클래스안의 멤버변수라는 뜻.
		// 이 함수 안에서는 age를 모두 지역변수로 인식하기 때문.
		return;
	}

	public int getAge() {

		return age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(2>name.length() || name.length() > 10) {
			System.out.println("이름을 다시 입력하시오");
			return;
		}
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public boolean isSingle() { //boolean은 get대신 is.
		return single;
	}

	public void setSingle(boolean single) {
		this.single = single;
	}

}

//변수타입 앞에 아무것도 없으면 같은 패키지내에서 사용가능
//변수타입 앞에 private 프라이빗이 있으면 그 클래스 안에서만 사용가능
//변수타입 앞에 public 퍼블릭이 있으면 모든 곳에서 사용가능
//멤버 데이터를 프라이빗 처리하고 그 데이터를 쓰기위해 getAge나 setAge를 씀. 셋겟메소드
//source에서 제너럴 세터스 앤 게터스에서 한번에 셋겟메소드 만들수 있음.