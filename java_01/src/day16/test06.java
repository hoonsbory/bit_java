package day16;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class test06 {
	public static void main(String[] args) {

		System.out.println("main start");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("c://lib//sample.txt"); // 경로를 따로 지정안하면 프로젝트 폴더부터 뒤짐
			// 이클립스로 실행하면 자바프로젝트부터 도스창에서 실행하면 빈폴더부터.
			// 그래서 절대위치를 기준으로 잡아주는게 좋음
			System.out.println("파일 준비 완료!");
		} catch (FileNotFoundException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("sample.txt 파일을 준비해주세요");
		} finally { // 자원반납
			try {
				if (fis != null) {
					fis.close(); // 위에서 파일을 못찾으면 fis가 널이기 때문에 다시 try로 해줘야한다.
					fis = null;
				}
				System.out.println("자원반납	성공");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("main end");

	}
}
