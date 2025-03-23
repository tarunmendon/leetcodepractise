package src.leetcode.easy;

import src.leetcode.common.ListNode;

public class PalindromeLinkedList_Recursion {

    private static ListNode front;

    private static boolean checkPalindrome(ListNode current) {
        if (current == null) {
            return true;
        }

        if (!checkPalindrome(current.next)) {
            return false;
        }

        if (current.val != front.val) {
            return false;
        }

        front = front.next;
        return true;
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        front = head;
        return checkPalindrome(head);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(head)); // Output: true
    }
}
