package src.leetcode.easy;

import src.leetcode.common.ListNode;

import java.util.List;

public class Problem206_ReverseLinkedList {

    public static void main(String[] args)
    {
        ListNode head=new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        Problem206_ReverseLinkedList obj=new Problem206_ReverseLinkedList();
        ListNode reversed=obj.reverseList(head);
        System.out.println("Reversed list:"+reversed.printList(reversed));
    }

    public ListNode reverseList(ListNode head) {

        if(head==null||head.next==null)
            return head;
        ListNode prev=null,node=head,next=head.next;

        while(next!=null)
        {
            node.next=prev;
            prev=node;
            node=next;
            next=next.next;
        }
         node.next=prev;
        return node;
    }
    }
