package day14;

import javax.swing.JOptionPane;

public class sum {

	
	public static  void math(int a, int b) {

		System.out.println("더한 값은 "+(a+b)+"입니다");
	}
	
	
	public static void main(String[] args) {
		String s = JOptionPane.showInputDialog("숫자를 입력해주세요").trim();
			
		int num = Integer.parseInt(s);
		String a = JOptionPane.showInputDialog("더할 숫자를 입력").trim();
		int num2 = Integer.parseInt(a);
		
		math(num, num2);
		
	}

}
