package leetcode.editor.cn;

public class JZ_24_reverseList {
    public ListNode reverseList(ListNode head) {
        ListNode ne = new ListNode(0);
        ListNode next = head;
        ListNode temp ;
        while(next.next!=null){
            temp = next.next;
            next.next = ne.next;
            ne.next = next;
            next = temp;
        }
        return ne.next;
    }
}
