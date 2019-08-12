package day08;

public class StaticTest3 {

	public static void main(String[] args) {  //하나의 소스코드에 클래스가 두개 존재할 경우 메인메소드가 있는 클래스로 
		//이름을 정해줘야함 퍼블릭한 클래스는 하나여야함. 두개면 에러. 
		System.out.println(StaticCount.count);
		StaticCount sc1 = new StaticCount(); //객체를 생성할때마다 생성자함수가 수행됨.
		System.out.println("sc1의 c :  " + sc1.c+",sc1의 count :" + sc1.count); //sc1의 주소. 즉 스태틱 카운트 클래스를 
		//사용할때마다 카운트됨
		
		StaticCount sc2 = new StaticCount();
		
		System.out.println("sc2의 c :  " + sc2.c+",sc2의 count :" + sc2.count);
		
		StaticCount sc3 = new StaticCount();
		
		System.out.println("sc3의 c :  " + sc3.c+",sc3의 count :" + sc3.count);
	}

}

class StaticCount {
	
	int c;
	static int count;
	public  StaticCount() { //생성자함수.
		c++;
		count++;
		
		
	}
		
}

