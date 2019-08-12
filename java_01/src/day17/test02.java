package day17;

public class test02 {

	public static void main(String[] args) {

		Book b1 = new Book("fsd", 393);
		System.out.println(b1);
		if(b1.getTitle() instanceof String)
		System.out.println(((String) b1.getTitle()).charAt(0)); // toString도 있음.
		
		
		Book<String, Integer> b2 = new Book<String, Integer>("sodf", 342);
		System.out.println(b2);

		Book<?, Integer> b3 = new Book<String, Integer>("sdf", 123213);  //물음표는 오브젝트로 처리됨.
		
		Book<?, ? extends Number> b4 = new Book<String, Integer>("sdf", 123213);  //물음표는 오브젝트로 처리됨.
		//넘버를 상속받을 수 있따 (넘버포함)
		System.out.println(b4.getPrice());
		Book<?, ? super Number> b5 = new Book<String, Object>("sdf", 123213);  //슈퍼는 넘버의 부모를 뜻함
		//그래서 객체 생성시 오브젝트를 선언해줘야 에러안남.
		System.out.println(b5);
	}

}
