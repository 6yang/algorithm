package leetcode.editor.cn;

public class JZ_18_deleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode next = res;
        while (next.next != null) {
            if (next.next.val == val) {
                next.next = next.next.next;
                break;
            }
            next = next.next;
        }
        return res.next;
    }
}
