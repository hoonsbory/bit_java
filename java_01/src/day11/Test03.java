package day11;

public class Test03 {

	public static void main(String[] args) {
		Person P = new Person("고길동" , 20 ); //다운캐스팅 불가. 퍼슨밑에 아무것도 없음
		
		Person S = new Student("홍길동" , 20 ,2002119); //다운캐스팅 가능 퍼슨에서 스튜던트로.
		Employee E = new Employee("고길동" , 20 , "ㄴㅇㄹㄴㅇ" ); 
		Object T = new Teacher("고길동" , 20 , "dsf");
		Object msg = new String("오브젝"); //어떤 타입이 메모리에 떠있는지가 중요함.
	
		((Teacher)T).printA();
		
	}

}
