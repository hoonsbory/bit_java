package day18;

import java.util.Arrays;

public class MyStack {
	int[] stack;
	int top = 0;

	public MyStack() {

	}

	public MyStack(int size) {
		if (size < 0) {
			this.stack = new int[10];
		} else {
			this.stack = new int[size];
		}

	}

	@Override
	public String toString() {
		return "MyStack [stack=" + Arrays.toString(stack) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(stack);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyStack other = (MyStack) obj;
		if (!Arrays.equals(stack, other.stack))
			return false;
		return true;
	}

	public void push(int num) {
//		stack[0]  = num;
//		for(int i =0; i<stack.length; i++) {
//			if(stack[i] !=0) {
//			stack[i] = num;
//			}
//			
//		}
		stack[top++] = num;

	}

	public boolean isEmpty() {

		if (top == 0) {
			//return top == 0 ? true:false; 3항 연산자 까먹지말자.
			return true;
		}
		return false;

	}

	public boolean isFull() {

		if (!(isEmpty())) {
			return true;
		}
		return false;
	}

	public int top() {
		if (!(isEmpty())) {
			return stack[top - 1];

		}

		return -1;

	}

	public int pop() {  //스택이 이런 구조다.

		if (!(isEmpty())) {

			return stack[--top];

		}
		return -1;
	}
}
