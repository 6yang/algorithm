package nowcoder;

public class NC_40_addInList {
    public ListNode addInList(ListNode head1, ListNode head2) {
        head1 = reserveList(head1);
        head2 = reserveList(head2);
        ListNode res = new ListNode(0);
        int up = 0;
        while (head1 != null && head2 != null) {
            int val = up + head1.val + head2.val;
            ListNode cur = new ListNode(val % 10);
            up = val / 10;
            cur.next = res.next;
            res.next = cur;
            head1 = head1.next;
            head2 = head2.next;
        }
        ListNode noNUll = head1 == null ? head2 : head1;
        while (noNUll != null) {
            int val = up + noNUll.val;
            ListNode cur = new ListNode(val % 10);
            up = val / 10;
            cur.next = res.next;
            res.next = cur;
            noNUll = noNUll.next;
        }
        if (up != 0) {
            ListNode cur = new ListNode(up);
            cur.next = res.next;
            res.next = cur;
        }
        return res.next;
    }

    public ListNode reserveList(ListNode head) {
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
