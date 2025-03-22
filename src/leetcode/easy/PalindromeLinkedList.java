package src.leetcode.easy;

import src.leetcode.common.ListNode;

import java.util.Stack;


public class PalindromeLinkedList {

	 public boolean isPalindrome(ListNode head) {
	 //1 2 2 1 -> Palindrome
	//1 2 3 2 1	 -> Palindrome
		 ListNode middle=head,fastPointer=head;
		 boolean isPalindrome=true;
		 int size=0;
		 Stack<Integer> stack=new Stack();
		 while(fastPointer!=null && fastPointer.next!=null)
		 {
			 stack.push(middle.val);
			 middle=middle.next;
			 fastPointer=fastPointer.next.next;
			 size+=2;
		 }
		 if(fastPointer!=null)
			 size++;
		 if(size%2!=0)
			 middle=middle.next;
		 
		 while(middle!=null)
		 {
			 if(stack.pop()!=middle.val)
				 return false;
			 middle=middle.next;
		 }
		 
		 return isPalindrome;
	    }
	 
	public static void main(String[] args) {
		ListNode node1=new ListNode(1, new ListNode(2,new ListNode(2,new ListNode(1))));
		ListNode node2=new ListNode(1, new ListNode(2,new ListNode(3,new ListNode(2,new ListNode(1)))));
		PalindromeLinkedList obj=new PalindromeLinkedList();
		System.out.println(obj.isPalindrome(node1));
		System.out.println(obj.isPalindrome(node2));
	}

}
