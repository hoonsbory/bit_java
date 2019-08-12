package day03;

public class Test02 {

	public static void main(String[] args) {

		int num = -30;
		
		System.out.println(num > 0 ? "양수" : "음수");
		System.out.println(num == 0 ? "0" : num > 0 ? "양수" : "음수");
		System.out.println(num > 0? "양수" : (num==0 ?"0" :  (num > -20 ? "-20보다 큼" : "-20보다작음")));
		//계속 추가해서 사용가능.
		System.out.println(num > 30 ? "업" : "다운");
		//
		
		String result = num > 0? "양수" : (num==0 ?"0" : (num > -20 ? "-20보다 큼" : "-20보다작음"));
		System.out.println(num + "은 " + result);
		
		
		
	}

}
