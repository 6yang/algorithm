package nowcoder;

public class NC_96_isPail {
    public boolean isPail(ListNode head) {
        // write code here
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre= null  ,p = null;
        while (fast != null && fast.next != null) {
            p = slow;
            slow = slow.next;
            fast = fast.next.next;
            p.next = pre;  // 翻转前半部分
            pre = p;
        }
        if(fast != null) {  //  如果是奇数个节点跳过奇数节点
            slow = slow.next;
        }
        while(p!=null){
            if(p.val != slow.val){
                return false;
            }
            p = p.next;
            slow = slow.next;
        }
        return true;
    }
}
