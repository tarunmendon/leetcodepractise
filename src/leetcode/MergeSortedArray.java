package src.leetcode;

public class MergeSortedArray {

	public static void main(String[] args) {
/*
 * Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]

Input: l1 = [], l2 = [0]
Output: [0]
 */
		ListNode l1=new ListNode(1);
		ListNode l1_1=new ListNode(2);
		ListNode l1_2=new ListNode(4);
		l1.next=l1_1;
		l1_1.next=l1_2;
		
		ListNode l2=new ListNode(1);
		ListNode l2_1=new ListNode(3);
		ListNode l2_2=new ListNode(4);
		l2.next=l2_1;
		l2_1.next=l2_2;
		MergeSortedArray mergeArray=new MergeSortedArray();
		ListNode out=mergeArray.mergeTwoLists(l1, l2);
		
		out.iterate();
		
	}
	  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		  ListNode head=null,curr=null;
		  while(l1!=null && l2!=null)
		  {
			  ListNode out=new ListNode();  
			  if(l1.val<l2.val)
			  {
				  out.val=l1.val;
				  l1=l1.next;
			  }
			  else
			  {
				  out.val=l2.val;
				  l2=l2.next;
			  }
			  if(head==null)
			  {
				  head=out;
				  curr=out;
			  }
			else
			{
				  curr.next=out;
			  curr=curr.next;
			}
		  }
		  
		  while(l1!=null)
		  {
			  ListNode out=new ListNode();
			  out.val=l1.val;
			  l1=l1.next;
			  if(head==null)
			  {
				  head=out;
				  curr=out;
			  }
			else
			{
				  curr.next=out;
			  curr=curr.next;
			}

		  }  
		  
		  while(l2!=null)
		  {
			  ListNode out=new ListNode();
			  out.val=l2.val;
			  l2=l2.next;
			  
			  if(head==null)
			  {
				  head=out;
				  curr=out;
			  }
			else
			{
				  curr.next=out;
			  curr=curr.next;
			}

		  }
		  return head;
	    }
}

class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  
	      public void iterate()
	      {
	    	  System.out.println();
	    	  ListNode element=this;
	    	  while(element!=null)
	    	  {
	    		  System.out.print(element.val+" ");
	    		  element=element.next;
	    	  }
	      }
}
