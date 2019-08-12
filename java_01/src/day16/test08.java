package day16;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class test08 {
	public static void main(String[] args) {

		try (FileInputStream fis = new FileInputStream("c://lib//sample.txt");) { // 이렇게 하면 알아서 자원반납처리해줌.
			System.out.println("=======file 처리=======");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		try (Scanner scanner = new Scanner(new File("c://lib//sample.txt"));) {
//클로져블 인터페이스를 상속받아서 오토 클로즈됨
			while (scanner.hasNextLine()) {
				String[] data = scanner.nextLine().split("/");
				System.out.println(Arrays.toString(data));
			}
		} catch (Exception e) {

		}
		System.out.println("end");
	}
}
