package day23;

import java.io.File;
import java.util.Scanner;

public class scanTest {
	public static void main(String[] args) {
		Scanner scan = null;
		try {
			scan = new Scanner(new File("c://lib//scan.txt"));
			while (scan.hasNextDouble()) {
				System.out.printf("스캔 double : %, .2f %n", scan.nextDouble());
			
			}
		} catch (Exception e) {
		}
		
	}
}

