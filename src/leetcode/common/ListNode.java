package src.leetcode.common;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public String printListNode(ListNode head)
    {
        return printList(head);
    }
    public String printList(ListNode head)
    {
        ListNode node=head;
        StringBuffer stringBuffer=new StringBuffer();
        while(node!=null)
        {
            stringBuffer.append(node.val);
            stringBuffer.append("  ");
            node=node.next;
        }
        return stringBuffer.toString();
    }
    @Override
    public String toString()
    {
        return ""+this.val;
    }

}
