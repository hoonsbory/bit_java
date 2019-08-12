package day25;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class test01 {
	public static void main(String[] args) {

		InetAddress ip = null;

		try {
			ip = InetAddress.getLocalHost();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		System.out.println(ip.getHostName()+ ip.getHostAddress());
		System.out.println(ip);
		System.out.println(ip.toString());
		System.out.println("------------------------------------------------------------");

		
		try {
			ip = InetAddress.getByName("www.naver.com");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} //도메인 네임 설정.
		System.out.println(ip.getHostName()+ ip.getHostAddress());
		System.out.println(ip);
		System.out.println(ip.toString());
	}
}
