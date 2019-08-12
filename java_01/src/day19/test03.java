package day19;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class test03 {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>(); // map가 서치속도가 훨씬 빠름 배열보다. 정렬하려면 TreeMap으로
		map.put("java01", "1234");
		map.put("java02", "1234");
		map.put("java02", "1235"); // 이름이 중복이라 뒤에 놈으로 덮어씌워짐. 키값이라서.
		map.put("admin", "admin");
		map.put("test01", "test");

		for (int i = 0; i < 30; i++) {
			map.put("test" + i, (int) (Math.random() * 3) + "00"); // 패스워드가 계속 바뀜
		}
	//	Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("로그인 처리");
			//System.out.println("ID / PW 입력해");
		//	String data = sc.nextLine();
			
			String data = JOptionPane.showInputDialog("ID / PW 입력해");
			if (data ==null) {
				return;
			}
			while (!(data.contains("/"))) {
				data = JOptionPane.showInputDialog("/를 넣어서 입력해주세요");
				if (data ==null) {
					return;
				}
			}
			String[] idpw = data.split("/");
			String id = idpw[0].trim();
			String pw = idpw[1].trim();
			if (map.containsKey(id)) {
				if (map.get(id).equals(pw)) {
					System.out.println("로그인 성공");
					break;
				} else {
					System.out.println("다시 로그인하세여");
				}
			} else {
				System.out.println("그런 ID없어요");
			}
		}
		
		System.out.println("서비스 이용가능");

	}
}
