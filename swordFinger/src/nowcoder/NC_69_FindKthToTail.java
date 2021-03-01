package nowcoder;


public class NC_69_FindKthToTail {

    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode p = head, q = head;
        while (p != null) {
            if (k <= 0) {
                q = q.next;
            }
            p = p.next;
            k--;
        }
        return k <= 0 ? q : null;
    }
}
