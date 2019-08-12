package day19;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JOptionPane;

public class Test06_map {
	public static void main(String[] args) {
		Command delete = new DeleteCommand();
		Command update = new UpdateCommand();
		Command select = new SelectCommand();
		Command insert = new InsertCommand();
		Map<Integer, Command> map = new HashMap<Integer, Command>();

		map.put(1, delete);
		map.put(2, update);
		map.put(3, select);
		map.put(4, insert);
		map.put(5, new Command() { // 풋에서 객체 생성후 익명 메소드로 바로 생성

			@Override
			public void exec() {
				System.out.println("기능추가");
			}

		});

		while (true) {
			int num2 = 0;
			String num = JOptionPane.showInputDialog("숫자1~5입력");
			if (num == null) {
				return;
			}
			try {

				num2 = Integer.parseInt(num.trim());
			} catch (Exception e) {
			//	System.out.println("숫자를 입력하세요 1~5");

			}
			// System.out.println(num);
			if (0 < num2 && num2 < 6) {
				map.get(num2).exec();
			} else {
				System.out.println("1~5사이의 숫자를 입력하세요");
			}
		}

	}
}
