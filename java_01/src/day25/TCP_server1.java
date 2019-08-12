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
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class TCP_server1 implements ActionListener{
	static String text = null;

	public static void main(String[] args) {

		TextField field1;
		BufferedWriter bw = null;
		FileWriter fw = null;
		BufferedReader br = null;
		JFrame f1;
		JTextArea area1;

		String serverIp = "127.0.0.1";
		// String serverIp = "192.168.0.135";
		try {
			System.out.println(serverIp + "연결시도 합니다");

			Socket socket = new Socket(serverIp, 1234); // 연결시도 소켓 객체 생성하면서 현재아이피로 7777포트로 접속시도
			System.out.println("서버와 연결이 되었습니다.");

			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			f1 = new JFrame();
			f1.setVisible(true);
			f1.setSize(500, 500);
			f1.setLocation(600, 0);
			f1.add(field1 = new TextField(), BorderLayout.NORTH);
			f1.add(area1 = new JTextArea(), BorderLayout.CENTER);
			
			while(true) {
			String sc = JOptionPane.showInputDialog("닉네임을 입력해주세요!");

//			field1.addActionListener(new ActionListener() {
//
//				@Override
//
//				public void actionPerformed(ActionEvent e) {
//
//					text = field1.getText();
//					field1.setText("");
//				}
//
//			});

			
	
					bw.write(sc + "\n");
					bw.flush();
					
					area1.append(br.readLine()+"\n");

		
				
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
	public void actionPerformed(ActionEvent e) {

	}
}

