package day07;

public class Page139 {
	public static int increase(int n) { //static은 new가 없어도 메모리에 올라감.
		++n;
		return n;
	}
	
	
	public static void main(String[] args) {
		int var1 =100;
		int  var2 = Page139.increase(var1); //스태틱한 자원이기때문에 클래스네임인 Page로 접근
		//var1에 100을 넣고 그 100은 위의 인크리즈 함수로 가서 대입되고 리턴을 통해 값을 반환받는다.
		System.out.println(var1+ "," +var2);
		
	}

}
