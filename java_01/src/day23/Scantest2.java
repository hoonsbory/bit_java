package day23;

import java.util.Scanner;

public class Scantest2 {
public static void main(String[] args) {
	String str = "1 and 2 and animal and lion and tiger";
	Scanner scan = new Scanner(str);
	scan = scan.useDelimiter("\\s*and\\s*");
	int firstToken =  scan.nextInt();
	int second =  scan.nextInt();
	String third = scan.next();
	String fourth= scan.next();
	String fifth = scan.next();
	
	System.out.printf("%d,%d,%s,%s,%s", firstToken,second,third,fourth,fifth);
}
}
