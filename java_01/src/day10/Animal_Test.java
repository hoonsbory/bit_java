package day10;

public class Animal_Test {

	public static void main(String[] args) {

			Animal a1 = new Animal(null);
			a1.breath();
			
			Animal a2 = new Animal("Tuna");  
			a2.breath();
			
			Animal a3 = new Animal("망고");
			
			Tuna t1 = new Tuna("시베리안허스키", "케리");
			t1.breath();
			
			t1.dogPrint();
			Tuna t2 = new Tuna("Dog", "코카스파니엘", "망고");
			t2.dogPrint();
			t2.breath();
			
			String animalKind = t2.getSuperKind(); //스태틱 영역에서는 this, super 못
					System.out.println(animalKind);;
	}
			
	
}
