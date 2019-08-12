package FileInput;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class filecopy {
	public static void main(String[] args) {
		String src = "c://lib//Ben.mp3";
		FileInputStream fis = null;
		FileOutputStream fos = null;
		System.out.println("파일 복사 시작~");
		try {
			fis = new FileInputStream(src);
			fos = new FileOutputStream("c://lib//copy.mp3", true); //복사하면서 경로 및 이름 정해줄 수 있음.
			//어펜드 파라미터에 트루를 주면 그 파일 위에 그 값을 더함.
			//false면 그냥 덮어쓰기
			
			int read = 0;
			int count = 0;
			
			while ((read = fis.read()) != -1) {  //fis가 읽으면 카운트 1+
				fos.write(read); //읽어드일 값을 반복문ㅁ으로 fos에 덮어씌움.
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
