package day23;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class RandomAccessFile_test {
	public static void main(String[] args) throws Exception {

		RandomAccessFile raf = new RandomAccessFile("rand.dat", "rw"); //파일네임,모드
		//얘는 혼자 읽기 쓰기 다 가능.
		String msg = "Hello, RandomAccessFile...";
		String result  = null;
		
		raf.writeBytes(msg); //라이트바이트로 스트링 파일넣고 와일루프로 입력
		raf.seek(0);
		
		while (true) {
			result = raf.readLine();
			if(result == null) break;
			System.out.println(result);
		}
		//raf.seek(raf.length());
		msg = "\n hi .. java test";
		raf.writeBytes(msg); //얘는 두번째 열에 들어감.
		raf.seek(7);  //7번째 문자부터 불러옴. 커서위치
		while (true) {
			result = raf.readLine();
			if(result == null) break;
			System.out.println(result);
		}
		//raf.seek(5);  //7번째 문자부터 불러옴. 커서위치
	
	}
}
