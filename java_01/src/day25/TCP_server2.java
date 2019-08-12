package day25;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

public class TCP_server2 implements Runnable {
	public static void main(String[] args) {
		
		
		BufferedWriter bw = null;
		FileWriter fw = null;
		BufferedReader br = null;
		String serverIp = "127.0.0.3";
		
		// String serverIp = "192.168.0.135";
		try {
			System.out.println(serverIp + "연결시도 합니다");
			Socket socket = new Socket(serverIp, 7777); // 연결시도 소켓 객체 생성하면서 현재아이피로 7777포트로 접속시도
			System.out.println("서버와 연결이 되었습니다.");
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(true) {
			String sc = JOptionPane.showInputDialog("아이디입력");
			bw.write(sc + "\n");
			bw.flush();
			System.out.println(br.readLine());
			
			if(sc.contains("quit")) {
				break;
			}
			}

			// 라인이라 한줄씩 읽으므로 write를 할때 \n을 넣어야한다.

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (br != null)
					br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		}
		@Override
		public void run() {
			
			
		}
		
}
