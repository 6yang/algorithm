package nowcoder;

public class NC_50_reverseKGroup {

    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode pre = res;
        ListNode end = res;
        while(end!=null){
            for (int i = 0; i < k&&end!=null; i++) {
                end = end.next;
            }
            if(end==null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = start;
        }
        return res.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
