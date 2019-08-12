package day18;

import java.util.Arrays;

public class asfsa {
	int size;
	static int[] stack;
	int top = 0;

	public asfsa() {
		this(10);
	}

	public asfsa(int n) {
		super();
		if(n < 0) {
			this.size = 10;
			stack = new int[10];
			return;
		}
		this.size = n;
		stack = new int[n];
	}

	void push(int number) {
		if (!isFull()) {
			stack[top++] = number;
		}
	}

	boolean isEmpty() {
		if (top == 0) {
			return true;
		}
		return false;
	}

	boolean isFull() {
		if (top == size) {
			return true;
		}
		return false;
	}

	int top() {
		if (isEmpty()) {
			return -1;
		}
		return stack[top - 1];
	}

	int pop() {
		int ret = -1;
		if (isEmpty()) {
			return -1;
		}
		ret = stack[--top];
	
		return ret;
		
	}
	
}
