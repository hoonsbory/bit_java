package day11;

import day10.Animal;
import day10.Tuna;

public class AnimalTest2 extends Animal{

	

	public AnimalTest2(String name, String kind) {
		super(name, kind);
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
			
		
			Animal[] all  ={	new Tuna("진돗개", "쫑이") , 
										new Tuna( "시베리안허스키", "허숙희", "아몰랑" ),
										new fish("구피")};
			
	//	for(Animal data :all) {
				//data.breath();
				//data.print();
		//}
			Tuna t1 = new Tuna("진돗개", "쫑이", "헉스");
			t1.dogPrint();
			fish f1 = new fish("구피");
			//callD(t1);
			//callD(f1);
			callD(all[0]); //다형성. 같은 메소드지만 파라미터타입에 따라다르게 동작한다. 
			//그 이유는 callD 안에 있는 오버라이딩 된 breath메소드 때문.
			callD(all[1]);
			callD(all[2]); //애니멀 타입 변수인 all배열을 오버라이딩한 breath함수 호출.
	}	
//		public static void callD(Tuna t) { //tuna타입만 가능
//			t.breath();
//	}
//		public static void callD(fish t) { //fish타입만 가능 , 메소드 오버로딩.
//			t.breath();
//	}
		public static void callD(Animal t) { //Animal타입만 가능 , 메소드 오버로딩.
			t.breath();
			//부모클래스를 배열로 만들어 자식들을 전부 담아버리고 
			//오버라이딩된 함수를 호출해 표현할 수 있음. 각자 다르게.
			
			//부모타입으로도 오버라이딩을 하면 하단부를 동작시킬 수 있다.
	}
}
