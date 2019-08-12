package FileInput;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;



public class TCP_IP_Server {
	public static void main(String[] args) {
		BufferedReader br = null;
		FileReader fr = null;
		BufferedWriter bw = null;
		Socket socket = null;
		ServerSocket serverSocket = null;
		String a = "quit를 입력해야 종료됩니다";
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("서버가 준비되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}

		while (true) {
			try {
				System.out.println("Client 요청을 기다립니다.");
				socket = serverSocket.accept(); // 요청이 올때까지 기다리는 메쏘드 소켓변수에는 클라이언트의 정보가 들어감.

				bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				System.out.println(socket.getInetAddress()); // 접속요청한 클라이언트의 아이피를 찍는다.
//				while(true) {
//				if(br.readLine().contains("quit")) {
//					System.exit(0);
//				}
//				System.out.println(br.readLine());
//				String msg = null;
//					bw.write(a + "\n");
//					bw.flush();
//				}
//				
				while(true) {
			//	System.out.println(br.readLine());
				bw.write(br.readLine()+"\n");
				bw.flush();
				}
				

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

	}
}

