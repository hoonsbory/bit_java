package day16;

import java.io.IOException;

public class test04 {
	public static void main(String[] args) {
		System.out.println("main strart");
//		throw new RuntimeException("예외 발생"); //언체크드
		int jumsu = 5000;
		try {
			if(!(jumsu>=0 && jumsu<=100))
			
			
			throw new IOException("jumsu가 유효하지 않습니다"); //에러메세지 등록 겟메세지로 출력
		} catch (IOException e) {
			System.out.println(e.getMessage());
			
		} finally {
			System.out.println(jumsu);
		}
		//체크드
		
		System.out.println("main end");
		}
}
		
