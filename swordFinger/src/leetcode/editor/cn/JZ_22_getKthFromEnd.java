package leetcode.editor.cn;

public class JZ_22_getKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode pre = head;
        ListNode next = head;
        while(next.next!=null){
            if(k>0){
                next = next.next;
                k--;
            }else{
                next = next.next;
                pre = pre.next;
            }
        }
        return pre;
    }
}
