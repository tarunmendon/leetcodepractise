package src.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/*
 * Uses extra space for getting min.
 */
public class MinStackWithSupportStack {

	List<Integer> stack = new ArrayList<Integer>();
	List<Integer> stack_ss = new ArrayList<Integer>();
	int size = 0;
	int size_ss=0;

	/** initialize your data structure here. */
	public MinStackWithSupportStack() {

	}

	public void push(int val) {
		stack.add(val);
		if(size_ss<=0||stack_ss.get(size_ss-1)>=val)
		{
			stack_ss.add(val);
			size_ss++;
		}	
		size++;

	}

	public void pop() {
		if(size==0)
			return;
		int val = stack.get(--size);
		
		if(val==stack_ss.get(size_ss-1))
			--size_ss;
	}

	public int top() {
		return (size>=1)?stack.get(size-1):-1;
	}

	public int getMin() {
		return (size_ss>0 ) ? stack_ss.get(size_ss-1) : -1;
	}

	public static void main(String[] args) {
		MinStackWithSupportStack minStack = new MinStackWithSupportStack();
		minStack.push(0);
		minStack.push(1);
		minStack.push(0);
		System.out.println("Min is:"+minStack.getMin());
		minStack.pop();
		System.out.println("Min is:"+minStack.getMin());
		System.out.println("Top is:"+minStack.top());
	}

}
