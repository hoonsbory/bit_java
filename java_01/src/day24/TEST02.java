package day24;

import java.util.Arrays;

public class TEST02 {
	public static void main(String[] args) {
		System.out.println("==========main start=========");

		MyStack stack = new MyStack();
	//	int[] stack = new int[10];
		Push p = new Push(stack);
		Pop p1 = new Pop(stack);
		
		Thread push = new Thread(p, "push");  // 쓰레드를 피씨에 올린다
		Thread pop = new Thread(p1, "pop");
		push.start();
		pop.start();
		
		System.out.println("==========main end=========");

	}
}

class Push implements Runnable {
	MyStack stack;

	public Push(MyStack stack) {
		super();
		this.stack = stack;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			stack.push(i);
			try {
				Thread.sleep((int) (Math.random() * 100));

			} catch (Exception e) {
			}
		}
	}
}

class Pop implements Runnable {

	MyStack stack;

	public Pop() {

	}

	public Pop(MyStack stack) {
		super();
		this.stack = stack;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			stack.pop();
		}
		try {
			Thread.sleep((int) (Math.random() * 100));			
		} catch (Exception e) {
		}

	}
}
