package day18;

import java.util.Arrays;

public class MyStack2 <E>{

	E[] stack;
	int top = 0;
	
	
	public MyStack2() {
		
	}
	public MyStack2(int size) {
		
		this.stack = (E[]) new Object[size];
	}
	public E[] getStack() {
		return stack;
	}
	public void setStack(E[] stack) {
		this.stack = stack;
	}
	public int getTop() {
		return top;
	}
	public void setTop(int top) {
		this.top = top;
	}
	@Override
	public String toString() {
		return "MyStack2 [stack=" + Arrays.toString(stack) + ", top=" + top + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(stack);
		result = prime * result + top;
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
		MyStack2 other = (MyStack2) obj;
		if (!Arrays.deepEquals(stack, other.stack))
			return false;
		if (top != other.top)
			return false;
		return true;
	}
	
	public void push(E num) {
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

	public E top() {
		if (!(isEmpty())) {
			return stack[top - 1];

		}

		return null;

	}

	public E pop() {  //스택이 이런 구조다.

		if (!(isEmpty())) {

			return stack[--top];

		}
		return null;
	}
	
	
}
