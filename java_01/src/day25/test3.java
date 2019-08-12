package day25;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class test3 {
	public static void main(String[] args) {

		String address = "https://www.naver.com/index.html";
		String line = null;

		URL url = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		FileWriter fw = null;

		String file = "c://lib//naver.html";
		try {
			url = new URL(address);
			br = new BufferedReader(new InputStreamReader(url.openStream())); // 시스템인 같은 느낌
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw); // 변수는 와일루프돌기전에 선언해서 와일루프에서는 값만 받아온다.

			while ((line = br.readLine()) != null) {
				// System.out.println(line);

				bw.write(line + "\n"); // write는 무조건 여기서 해야됨. 라인을 한줄 씩 읽고 저장하기 때문에 와일루프안에서 write해야함
			}
			bw.flush();  //버퍼가 다차면 플러쉬할 수 있도록 와일문 밖에 선언.
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fw != null)
					fw.close();
				if(bw!=null) bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}
