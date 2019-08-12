package day16;

public class test05 {
	public static void main(String[] args) {

		System.out.println("main start");

		for (int i = 0; i < 10; i++) {
			System.out.println("hello ~~~~~" + i);

			try {
				Thread.sleep(1000);  //밀리세컨즈.  1초
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}
		System.out.println("main end");
	}
}
