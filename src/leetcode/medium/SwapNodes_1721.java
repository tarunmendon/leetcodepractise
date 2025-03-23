package src.leetcode.medium;

import src.leetcode.common.ListNode;

import java.util.List;

public class SwapNodes_1721 {

    public ListNode swapNodes(ListNode head, int k) {
        //https://github.com/doocs/leetcode/blob/main/solution/1700-1799/1721.Swapping%20Nodes%20in%20a%20Linked%20List/README_EN.md
        ListNode fast = head;
        while (--k > 0) {
            if(fast==null)
                return head;
            fast = fast.next;
        }
        ListNode p = fast;
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode q = slow;
        int t = p.val;
        p.val = q.val;
        q.val = t;
        return head;
    }

    public static void main(String[] args) {
        ListNode node=new ListNode(1,
                new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        SwapNodes_1721 obj=new SwapNodes_1721();
        ListNode output=obj.swapNodes(node,7);
        node.printListNode(output);
    }

}
