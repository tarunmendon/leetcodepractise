package src.leetcode.medium;

public class Problem92_ReverseLinkedList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
            this.next=null;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args)
    {
        ListNode head=new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        Problem92_ReverseLinkedList obj=new Problem92_ReverseLinkedList();
        ListNode reversed=obj.reverseBetween(head,2,4);
       // System.out.println("Reversed list in between:"+reversed.printList(reversed));
    }

    /* Solution from chat gpt */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;  // No need to reverse if left == right

        ListNode dummy = new ListNode(0); // Dummy node to handle edge cases where left == 1
        dummy.next = head;
        ListNode prev = dummy;

        // Move `prev` to one node before `left`
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Start reversing
        ListNode curr = prev.next;
        ListNode next;
        ListNode reverseTail = curr; // This will be the tail of the reversed sublist

        for (int i = left; i < right; i++) {
            next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

        return dummy.next; // If left == 1, return the new head; otherwise, return the original head
    }
}
