package nowcoder;

public class NC_50_reverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        // write code here
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode pre = res;
        ListNode end = res;
        while (end != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode start = pre.next;
            ListNode temp = end.next;
            end.next = null;
            pre.next = reverseList(start);
            start.next = temp;
            pre = start;
            end = start;
        }
        return res.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
