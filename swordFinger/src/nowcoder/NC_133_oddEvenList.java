package nowcoder;


//leetcode 328
public class NC_133_oddEvenList {
    public ListNode oddEvenList(ListNode head) {
        // write code here
        if (head == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode curOdd = head;
        ListNode curEven = evenHead;

        while (curEven != null && curEven.next != null) {
            curOdd.next = curEven.next;
            curOdd = curOdd.next;

            curEven.next = curOdd.next;
            curEven = curEven.next;
        }
        curOdd.next = evenHead;
        return head;

    }
}
