package day25;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TCP_IP_Server {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		List<BufferedWriter> list = new ArrayList<BufferedWriter>();

		try {
			serverSocket = new ServerSocket(1234);
			System.out.println("서버가 준비되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}

		while (true) {
			try {

				System.out.println("Client 요청을 기다립니다.");
				Socket socket1 = serverSocket.accept();
				// 요청이 올때까지 기다리는 메쏘드 소켓변수에는 클라이언트의 정보가 들어감.
				// 소켓에 클라이언트의 정보를 담아서 생성자함수로 스레드에서 아이피찍어준다.
				new T1(socket1, list).start();

//				socket1.close();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}

		}
	}
}

class T1 extends Thread {

	BufferedReader br = null;
	FileReader fr = null;
	BufferedWriter bw = null;
	Socket socket = null;
	String text = null;
	List<BufferedWriter> list = null;

	public T1(Socket socket, List<BufferedWriter> list) {
		this.socket = socket;
		this.list = list;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			list.add(bw);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		String msg = null;
		try {
			while ((msg = br.readLine()) != null) {
				broadcast(msg);
				if(msg.equals("q")) {
					broadcast(" 님이 퇴장하셨습니다.");
				}
				
			}
		} catch (Exception e) {

		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (bw != null) {
					list.remove(bw);
					bw.close();
				}
				if (socket != null) {
					socket.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	private synchronized void broadcast(String msg) {
		list.forEach(bw -> {
			try {
				bw.write(msg + "\n");
				bw.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

}
