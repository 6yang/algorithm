package nowcoder;

public class NC_2_reorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newList = reverseList(slow.next);
        slow.next = null ;
        while(newList!=null){
            ListNode temp = newList.next;
            newList.next = head.next;
            head.next = newList;
            head = newList.next;
            newList = temp;
        }
    }

    private ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
