package day06_ex;

public class ex3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1+(1+2)+(1+2+3)+(1+2+3+4)+...+(1+2+3+...+10) 의 결과를 계산하시오
		int sum = 0;
	for(int a =1; a<=10; a++) {
		for(int b= 1; b<=a; b++) {
			sum +=b;
			System.out.print(b);
		}
		System.out.println();
	}
		System.out.println(sum);
	}

}
