package FileInput;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class filecopy2 {
	public static void main(String[] args) {
		String src = "c://lib//Ben.mp3";
		FileInputStream fis = null;
		FileOutputStream fos = null;
		System.out.println("파일 복사 시작~");
		try {
			fis = new FileInputStream(src);
			fos = new FileOutputStream("c://lib//copy2.mp3"); //복사하면서 경로 및 이름 정해줄 수 있음.
			//어펜드 파라미터에 트루를 주면 그 파일 위에 그 값을 더함.
			//false면 그냥 덮어쓰기
			
			int read = 0;
			int count = 0;
			
			byte[] buffer = new byte[fis.available()];   //fis의 사이즈만큼 버퍼를 잡겠따!
			//버퍼는 빠르지만 파일의 크기가 클 경우는 불가능하다.
			
			while ((read = fis.read(buffer)) != -1) {  //fis가 읽으면 카운트 1+
				fos.write(buffer); //버퍼 배열로 읽고 버퍼배열을 덮어씌움
				count++;
			}
			System.out.println("I/O횟수 : "+ count);
			System.out.println("파일 복사 완료");
		} catch (FileNotFoundException e) {
			System.out.println(src + "파일 확인해주세요");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(fis != null) fis.close();
				if(fos != null) fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("===========main end===============");
	}
}
