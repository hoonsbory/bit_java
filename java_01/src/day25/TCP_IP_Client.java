package day25;

import java.awt.BorderLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class TCP_IP_Client implements ActionListener {
	static String text = null;

	static TextField field1;
	FileWriter fw = null;
	static BufferedWriter bw = null;
	static BufferedReader br = null;
	static JFrame f1;
	static JTextArea area1;
	static Socket socket = null;
	public static void main(String[] args) {

		String serverIp = "127.0.0.2";
		// String serverIp = "192.168.0.135";
		try {
			System.out.println(serverIp + "연결시도 합니다");

			 socket = new Socket(serverIp, 1234); // 연결시도 소켓 객체 생성하면서 현재아이피로 7777포트로 접속시도
			System.out.println("서버와 연결이 되었습니다.");

//			f1 = new JFrame();
//			f1.setVisible(true);
//			f1.setSize(500, 500);
//			f1.add(field1 = new TextField(), BorderLayout.NORTH);
//			f1.add(area1 = new JTextArea(), BorderLayout.CENTER);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			new rm(br).start();

//			field1.addActionListener(new ActionListener() {
//				
//				@Override
//				
//				public void actionPerformed(ActionEvent e) {
//					try {
//						bw.write(field1.getText() + "\n");
//						field1.setText("");
//						bw.flush();
//					} catch (IOException e1) {
//						e1.printStackTrace();
//					}
//				}
//				
//			});

			while (true) {
				String sc = JOptionPane.showInputDialog("닉네임을 입력해주세요!");
			
					bw.write(sc + "\n");


				
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
				if(socket != null)
					socket.close();
				
				
				
				
				

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}

class rm extends Thread {

	BufferedWriter bw = null;
	BufferedReader br = null;

	public rm(BufferedReader br) {
		this.br = br;
	}

	public rm() {
	}

	@Override
	public void run() {

		try {
			String msg = null;
			while ((msg = br.readLine()) != null) {

				System.out.println(msg);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} 

	}

}
