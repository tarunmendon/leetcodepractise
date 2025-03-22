package src.leetcode.medium;

public class Problem19_RemoveNthFromEndOfList {
    public static void main(String args[]) {
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        Problem19_RemoveNthFromEndOfList obj=new Problem19_RemoveNthFromEndOfList();
        ListNode out=obj.removeNthFromEnd(list,2);
        ListNode out1=obj.removeNthFromEnd(list1,2);
        out.printListNode(out);
        out1.printListNode(out1);
        out=obj.removeNthFromEnd(out,4);
        out1=obj.removeNthFromEnd(out1,4);
        out.printListNode(out);
        out1.printListNode(out1);

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        int totalSize = 0,delPos=0;
        //get node size
        while (node != null) {
            totalSize++;
            node = node.next;
        }
        System.out.println("Size:" + totalSize);
            delPos=(totalSize-n)+1;

            if(delPos==1)
            {
                head=head.next;
                return head;
            }
            ListNode prev=null;
            node=head;
            while(delPos>1)
            {
            prev=node;
            node=node.next;
            delPos--;
            }
            prev.next=node.next;

        return head;
    }

    public ListNode removeNthFromEnd_nickWhiteSoln(ListNode head, int n) {
        ListNode dummy_head =new ListNode(0);
        ListNode slow_node=dummy_head;
        ListNode fast_node=dummy_head;
        for(int i=1;i<=n+1;i++)
        {
            fast_node=fast_node.next;
        }
        while(fast_node!=null)
        {
            slow_node=slow_node.next;
            fast_node=fast_node.next;
        }
        slow_node.next=slow_node.next.next;

        return dummy_head.next;
    }
}

