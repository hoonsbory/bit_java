package day12;

public class AnimalTest {

	public static void main(String[] args) {
		
		Animal[] ani = {new Dog("쫑이", "진돗개"),
									new fish("니모", "구피")};
		
		for(Animal data : ani) {
				data.breath();
				
				System.out.println(data); //투스트링 생략되어있음. 자동컨버팅
		}
	}

}
