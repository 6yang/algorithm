package nowcoder;

/**
 * @author liuyang29 <liuyang29@kuaishou.com>
 * Created on 2020-12-14
 */
public class NC_70_sortInList {
    public ListNode sortInList (ListNode head) {
        // write code here
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        ListNode left = sortInList(head);
        ListNode right = sortInList(fast);
        ListNode res = new ListNode(-1);
        ListNode curr = res;
        while(left!=null&&right!=null){
            if(left.val<right.val){
                curr.next = left;
                left = left.next;
            }else{
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        curr.next = left!=null ? left :right;
        return res.next;
    }
}
