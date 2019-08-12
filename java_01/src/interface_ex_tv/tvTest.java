package interface_ex_tv;

public class tvTest {

	public static void main(String[] args) {
		
		TV user = new STV();
		play(new STV());
		
		play(new LTV());
		user = new LTV();  //TV를 임플리먼츠 했기때문에 user로 STV 객체 생성을 하고 다시 LTV로도 객체 생성이 가능하다
		user.poweron();
		user.poweroff();
		
		user = new ITV();
		user.poweron();
		user.poweroff();
	}
	public static void play(TV tv){ //부모 타입을 매개변수로 가지면 그 자식들은 모두 뉴키워드를 통해 함수 사용가능.
		//부모타입으로하면 메소드 오버로딩할 필요도 없음.
		tv.poweron();
		tv.poweroff();
	}

}
