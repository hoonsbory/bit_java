package FileInput;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class test07 {
	public static void main(String[] args) throws FileNotFoundException {
		
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr =  new FileReader("c://lib//dbinfo.txt");
			br = new BufferedReader(fr);
			
			String id = null;
			String pw = null;
			
			String read = null;
			while ((read= br.readLine()) !=null) {
				String[] data = read.split("=");
				if(data[0].equals("user")) id = data[1];
				if(data[0].equals("pw")) pw = data[1];
			}
			System.out.println("login" + id + "/" +pw);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
				try {
					if(fr != null)
					fr.close();
					if(br != null)
						br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
