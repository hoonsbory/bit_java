package day24;

import java.util.Arrays;



public class MyStack {
	int top = 0;
	int[] stack;
	public MyStack() {
		stack = new int[10];
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

	 public synchronized boolean isEmpty() {
			return top == 0 ? true:false;
		}
				
	    public synchronized boolean isFull(){
			return top == stack.length ? true : false;
		}
		
	    public synchronized void push(int data){
			if(isFull()) {
				//System.out.println("stack is full ...");
				//return;
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			stack[top] = data;
			top++;
			System.out.println("push => "+data);
			
			notifyAll();
		}

	    public synchronized int top(){
			if(isEmpty()) return -1;
			return stack[top-1];
		}

	    public synchronized int pop(){
			if(isEmpty()) { 
				//return -1;
			    try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			int data = stack[--top];
			System.out.println("                       pop  ==> "+ data);
			notifyAll();
			return data;
		}
}
