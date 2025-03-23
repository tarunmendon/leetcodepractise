package src.leetcode.medium;

import src.leetcode.common.ListNode;

//https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/
public class DeleteMiddleNodeLinkedList {

    public ListNode deleteMiddle(ListNode head) {
        /* Check Edge Cases*/
        if (head == null || head.next == null) {
            return null;
        }
        ListNode prev = null, curr = head, fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            prev = curr;
            curr = curr.next;
            fastPointer = fastPointer.next.next;
        }
        prev.next = curr.next;

        return head;
    }
}
