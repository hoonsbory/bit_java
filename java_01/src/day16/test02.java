package day16;

public class test02 {

	public static void main(String[] args) {
		System.out.println("main strat");
		String msg = null;
		msg = "xmㄴㅇㄹs";
		try {
			System.out.println(msg.charAt(3));
			int num = Integer.parseInt(msg);
		} catch (StringIndexOutOfBoundsException e) {  //or로 여러개 익셉션을 잡을 수 있음

			System.out.println("예외발생" + e.getMessage()); // index  
		} catch (NullPointerException e) {
			System.out.println("예외발생" + e.getMessage()); // null
		} catch (NumberFormatException e) {
			System.out.println("예외발생 : 정수로 입력하세요");
		} catch (Exception e) {
			System.out.println("예외발생" + e.getMessage()); 

		} finally {
			System.out.println("finally {자원반납 코드}");
			
		}
		System.out.println("main end");
	}

}
