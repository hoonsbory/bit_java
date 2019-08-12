package day25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class test02 {
	public static void main(String[] args) {
		
		String address= "https://www.naver.com/index.html";
		String line = null;
		
		URL url =null;
		BufferedReader br = null;
		try {
			url = new URL(address);
			br = new BufferedReader( new InputStreamReader(url.openStream())); //시스템인 같은 느낌
			
			while ((line = br.readLine())!=null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				try {
					if(br!=null)
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			
		}
	}
}
