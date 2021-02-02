package nowcoder;


public class NC_21_reverseBetween {

    public ListNode reverseBetween (ListNode head, int m, int n) {
        // write code here
        if (head == null ) return null;
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode pre = res;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode curNext = cur.next;
        for (int i = m; i < n; i++) {
            cur.next = curNext.next;
            curNext.next = pre.next;
            pre.next = curNext;
            curNext = cur.next;
        }
        return res.next;
    }
}
