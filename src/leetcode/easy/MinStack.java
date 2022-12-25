package src.leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Uses extra space for getting min.
 */
public class MinStack {

	List<Integer> stack = new ArrayList<Integer>();
	PriorityQueue<Integer> priorityQ = new PriorityQueue<Integer>();
	int size = 0;

	/** initialize your data structure here. */
	public MinStack() {

	}

	public void push(int val) {
		stack.add(val);
		priorityQ.add(val);
		size++;
	}

	public void pop() {
		if(size==0)
			return;
		int val = stack.get(--size);
		priorityQ.remove(val);
	}

	public int top() {
		return (size>=1)?stack.get(size-1):-1;
	}

	public int getMin() {
		return (priorityQ.size() >= 1) ? priorityQ.peek() : -1;
	}

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(0);
		minStack.push(-3);
		System.out.println("Min is:"+minStack.getMin());
		minStack.pop();
		minStack.pop();
		System.out.println("Min is:"+minStack.getMin());
		System.out.println("Top is:"+minStack.top());
	}

}
