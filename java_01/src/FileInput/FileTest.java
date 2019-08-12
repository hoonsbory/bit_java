package FileInput;

import java.io.File;
import java.util.Date;

public class FileTest {
	public static void main(String[] args) {

		File dir = new File("c:\\");
		String[] list = dir.list(); //위에경로에 있는 파일 목록 넘겨주면 스트링 배열로 만듦
		
		File file = null;
		Date date = null;
		for(String data:list) {
			file = new File(dir,data);
			System.out.println(file.getName() + "\t");
			System.out.println(file.length()+"\t");
			date = new Date(file.lastModified());
			System.out.println(date);
			
			if(file.isDirectory()) {
				System.out.println("<dir>");
				System.out.println();
			}
		}
	}
}
