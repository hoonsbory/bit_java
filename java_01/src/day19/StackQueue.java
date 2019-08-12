package day19;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.management.Query;

public class StackQueue {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		for(int i= 0; i<100; i++) {
			stack.push(""+i); //스택은 푸쉬로 입력
		}
		System.out.println(stack.pop()); //마지막 인덱스 출력과 동시에 인덱스 하나줄어듦
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < 100; i++) {
			queue.offer(i);  //큐는 오퍼로 입력
		}
		System.out.println(queue.poll());  //첫번째 인덱스 출력
	}
}
