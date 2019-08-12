package day23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test01 {
	public static void main(String[] args) {
		//system.in 은 인풋스트림타입이라 바이트단위
		InputStreamReader ir = new InputStreamReader(System.in);  //키보드로부터 들어오는 데이터를 char로 바꿔주는 역할. 인풋스트림리다~
		BufferedReader br = new BufferedReader(ir); //차타입으로 바뀐걸 버퍼리더로 읽고 와일루프로 스트링 s에 값을 넣어줌
		
		String s = null;
		try {
			while ((s = br.readLine()) !=null) {
				System.out.println("keyboard input data => "+ s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(br != null)br.close();
				if(ir != null)ir.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Scanner1{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		System.out.println("스캔  ; %d", number);
		scan.close();
	}
}