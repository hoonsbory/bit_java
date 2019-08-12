package day06_ex;

public class AnimalTest {

	public static void main(String[] args) {

		Animal ani1 = new Animal();

		ani1.setAge(3);
		ani1.setName("큰뿔소");
		ani1.setLive(true);

		Animal ani2 = new Animal();

		ani2.setAge(4);
		ani2.setName("펭귄");
		ani2.setLive(true);

		Animal ani3 = new Animal();

		ani3.setAge(2);
		ani3.setName("호랑이");
		
		Animal ani4 = new Animal();

		ani4.setAge(7);
		ani4.setName("사자");
		ani4.setLive(true);
		
		Animal ani5 = new Animal();

		ani5.setAge(10);
		ani5.setName("돌고래");
		ani5.setLive(true);
		
		
		Animal[] ani = { ani1, ani2 , ani3, ani4 , ani5};

		for (Animal data : ani) {
			if (data.getAge() == 3) {
				data.display2();
			}
		}

		for (Animal data : ani) {
			if (data.getName().equals("큰뿔소")) {
				ani1.setName("펭귄");
				data.display2();

			}

		}

	}

}
