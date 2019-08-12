package day16;

import java.io.File;
import java.util.Scanner;

public class BookTest {
	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			 scanner = new Scanner(new File("c://lib//sample.txt"));
			// 생성자함수에 쓰로우즈가 걸려있어서 트라이캐치해야함
			//여기서 트라이캐치를 하면 에러메세지를 따로 핸들링할 수 있어서 좋다.
			while(scanner.hasNextLine()) {
				String[] data = scanner
						.nextLine().split("/");
				Book book  =null;
				try {
					 book = new Book(data[0], Integer.parseInt(data[1]));
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				System.out.println(book);
		
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(scanner !=null)scanner.close();
			scanner =null;
			System.out.println("자원반납수행");
		}
		System.out.println("end");
	}
}
