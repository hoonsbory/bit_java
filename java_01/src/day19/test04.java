package day19;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class test04 {
	static Map<Integer, String> map = new HashMap<Integer, String>();
	static String Q = null;

	public static void add() {

		String data = JOptionPane.showInputDialog("가입을 위해 사번과 사원명을 입력해주세요");
		if (data == null) {
			return;
		}
		while (!(data.contains("/"))) {
			data = JOptionPane.showInputDialog("/를 넣어서 입력해주세요");
			if (data == null) {
				return;
			}
		}

		String[] numname = data.split("/");
		Integer num = Integer.parseInt(numname[0]);
		String name = numname[1];

		map.put(num, name);

		Q = JOptionPane.showInputDialog("로그인을 하시려면 F를 입력하세요");
		if (Q == null) {
			return;
		}
		if (Q.equals("F")) {
			Q = "F";
		}
	}

	public static void find() {
		while (true) {
			String data1 = JOptionPane.showInputDialog("로그인을 위해 사번과 사원명을 입력해주세요");
			if (data1 == null) {
				return;
			}
			while (!(data1.contains("/"))) {
				data1 = JOptionPane.showInputDialog("/를 넣어서 입력해주세요");
				if (data1 == null) {
					return;
				}
			}

			String[] numname1 = data1.split("/");
			Integer num1 = Integer.parseInt(numname1[0]);
			String name1 = numname1[1];

			if (map.containsKey(num1)) {
				if (map.get(num1).equals(name1)) {
					System.out.println("로그인 성공");
					break;
				} else {
					System.out.println("다시 로그인하세여");
				}
			} else {
				System.out.println("그런 사원없어요");
			}
		}
		System.out.println("서비스 이용가능");

	}
}
