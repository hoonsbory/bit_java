package day16;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class MyException {
	public static void main(String[] args) {
		System.out.println("main start");
		Scanner scanner = null;
		// FileInputStream fis = null;
		try {
			scanner = new Scanner(new File("c://lb//sample.txt"));
			while (scanner.hasNextLine()) {
				String[] data = scanner.nextLine().split("/");
				System.out.println(Arrays.toString(data));
			}
			System.out.println(" 파일준비완료");
		} catch (FileNotFoundException e) {
			System.out.println("찾으시는 파일이 없습니다");
			while (scanner == null) {
				String a = JOptionPane.showInputDialog("찾으시는 파일이 없습니다, 경로를 직접 입력하십시오");
				if (a == null)
					return;
				try {

					scanner = new Scanner(new File(a));
					System.out.println(" 파일준비완료");
					while (scanner.hasNextLine()) {
						String[] data = scanner.nextLine().split("/");
						System.out.println(Arrays.toString(data));

					}

					break;
				} catch (FileNotFoundException e1) {
					// e1.printStackTrace();

				}
			}

			// e.printStackTrace();
		} finally {
			if (scanner != null)
				scanner.close();
			scanner = null;
			System.out.println("자원반납완료");
		}

		System.out.println("main end");
	}
}
