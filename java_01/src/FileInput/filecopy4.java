package FileInput;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class filecopy4 {
	public static void main(String[] args) {
		String src = "c://lib//Ben.mp3";
		FileInputStream fis = null;
		FileOutputStream fos = null;
		System.out.println("파일 복사 시작~");
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;  //버퍼를 다 못채운 맨마지막에 남은 자료를 그냥 버림
		try {
			fis = new FileInputStream(src);
			fos = new FileOutputStream("c://lib//copy3.mp3"); // 복사하면서 경로 및 이름 정해줄 수 있음.
			// 어펜드 파라미터에 트루를 주면 그 파일 위에 그 값을 더함.
			// false면 그냥 덮어쓰기
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);

			int read = 0;
			int count = 0;

			while ((bis.read() != -1)) {
				bos.write(read);
			}
			//버퍼를 다 못채운 맨마지막에 남은 자료를 그냥 버림
			bos.flush(); //이 메소드를 통해 남겨진 자료를 가져옴
			System.out.println("I/O횟수 : " + count);
			System.out.println("파일 복사 완료");
		} catch (FileNotFoundException e) {
			System.out.println(src + "파일 확인해주세요");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("===========main end===============");
	}
}
