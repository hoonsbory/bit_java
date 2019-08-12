package day23;

public class Therad_test {
	public static void main(String[] args) {
//	System.out.println(Thread.MAX_PRIORITY);
//	System.out.println(Thread.MIN_PRIORITY);
//	System.out.println(Thread.NORM_PRIORITY);

		System.out.println("========main start================");
		
		
		
		

		System.out.println(Thread.currentThread()); //현재 점유하고 있는 쓰레드를 표시해줌

//		T1 j = new T1();
//		Thread t1 = new Thread(j, "job1"); //쓰레드 이름도 설정가능
//
//		T2 j1 = new T2();
//		Thread t2 = new Thread(j1, "job2");
//스레드 실행대기 큐에넣기 start
		T1 t1 = new T1();
		t1.start();
		T2 t2 = new T2(); //쓰레드를 상속받아서 쓰레드하면서 러너블한 객체가 돼버림.
		t2.start();
		
		try {
			t1.join();	 //t1 t1 쓰레드가 끝날때까지 나머지는(모~든 메소드) 아무일도 못함.
			t2.join();	
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		// 서로 메인이되는 순서는 다르다. 랜덤임
		System.out.println("========main end================");
		System.out.println("홀수합 + 짝수합 : " + (t1.sum+t2.sum));
	}
}

class T1  extends Thread {
	int sum = 0;

	@Override
	public void run() {
		for (int i = 1; i < 100; i = i + 2) {
			sum += i;
			System.out.print(Thread.currentThread());
			System.out.println("1~" + i + " 홀수합 :" + sum);
			Thread.yield();
//			try {
//				Thread.sleep(50); //5초동안 잠자다가 쓰레드가 실행
//				//T1을 슬립	 위로 보내서  먼저 홀수합을 실행하고 그 다음 짝수합 쓰레드가 실행되면서 
//				//깔끔하게 정리됨
//			} catch (Exception e) {
//			}
		}
	}
	
}
class T2 extends Thread {
	int sum = 0;

	@Override
	public void run() {
		for (int i = 0; i < 100; i = i + 2) {
			sum += i;
			System.out.print(Thread.currentThread());
			System.out.println("0~" + i + " 짝수합 :" + sum);
			
		}
		
	}
}
