package nowcoder;

public class NC_25_deleteDuplicates {
    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        ListNode cur = head;
        while (cur!=null && cur.next!=null){
            if(cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;
    }
}
