package day11;

import day10.Animal;
import day10.Tuna;

public class AnimalTest extends Animal{

	public AnimalTest(String name, String kind) {
		super(name, kind);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
			Animal t = new Tuna("진돗개", "쫑이");
			if(t instanceof Tuna) ((Tuna)t).dogPrint();
			Animal f = new fish("구피");
			if(f instanceof fish) ((fish)f).fishprint();  //다운캐스팅을 통해 자식클래스 메소드 호출가능.
			//f는 애니몰 타입이기때문에 fish타입으로 다운캐스팅 가능해서 if구문을 충족한다. true값을 받기 때문.
				//t.dogPrint();
				t.breath();
			//	f.fishprint();
				f.breath(); //다운 캐스팅을 안해도 메소드 오버라이딩을 통해 자식클래스 메소드 호출가능.
				//애니몰 타입에 fish 생성자 함수를 넣었기 때문에 오버라이딩을 통해 fish의 메소드를 호출함.
			((fish)f).breath();
			
}
}