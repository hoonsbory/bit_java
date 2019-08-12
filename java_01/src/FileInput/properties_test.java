package FileInput;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class properties_test {
	public static void main(String[] args) throws FileNotFoundException {
		
		FileReader fr = null;
		Properties p1 = new Properties();
		

		
		try {
			fr = new FileReader("C://lib//dbinfo.txt");
			p1.load(fr);
			String id = p1.getProperty("user");
			String pw = p1.getProperty("pw");
			System.out.println(id +"/"+ pw);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
				try {
					if(fr !=null)
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
			
			
	
	}
}
