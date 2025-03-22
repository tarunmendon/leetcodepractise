package src.random;

public class CustomLinkedList {
public static void main(String[] args) {
    LinkedList l1_val1 = new LinkedList(10);
    LinkedList l1_val2 = new LinkedList(20);
    LinkedList l1_val3 = new LinkedList(30);
    l1_val1.next = l1_val2;
    l1_val2.next = l1_val3;

    LinkedList l2_val1 = new LinkedList(5);
    LinkedList l2_val2 = new LinkedList(15);
    LinkedList l2_val3 = new LinkedList(25);
    l2_val1.next = l2_val2;
    l2_val2.next = l2_val3;

    LinkedList l3_val1 = new LinkedList(8);
    LinkedList l3_val2 = new LinkedList(16);
    LinkedList l3_val3 = new LinkedList(25);
    l3_val1.next = l3_val2;
    l3_val2.next = l3_val3;

    LinkedList sorted=l1_val1.mergeLinkedListInSortedOrder(l1_val1,l2_val1,l3_val1);
    sorted.printLinkedListVal();

}
}

class LinkedList {
    LinkedList next;
    int data;

    protected LinkedList(int val, LinkedList next) {
        this.data = val;
        this.next = next;
    }

    protected LinkedList(int val) {
        this.data = val;
    }

    protected LinkedList() {
    }
    protected LinkedList mergeLinkedListInSortedOrder(LinkedList l1, LinkedList l2, LinkedList l3) {
    LinkedList merged=new LinkedList();
    LinkedList val=merged;
    while(l1!=null || l2!=null || l3!=null)
    {
        if(getData(l1)<=getData(l2) && getData(l1)<=getData(l3))
        {
            val.next=new LinkedList(l1.data);
            l1=l1.next;
        }
        else if(getData(l2)<=getData(l1) && getData(l2)<= getData(l3))
        {
            val.next=new LinkedList(l2.data);
            l2=l2.next;
        }
        else
        {
            val.next=new LinkedList(l3.data);
            l3=l3.next;
        }
        val=val.next;
    }
    return  merged.next;
    }

    private int getData(LinkedList list)
    {
        if(list!=null)
            return list.data;
        else
            return Integer.MAX_VALUE;
    }
    public  void printLinkedListVal()
    {
        LinkedList list=this;
        System.out.println("Printing list");
        while(list!=null)
        {
            System.out.print(list.data+" ->");
            list=list.next;
        }
        System.out.println();
    }

}
