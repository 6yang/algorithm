package nowcoder;
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
public class NC_3_detectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean cycle = false;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                cycle = true;
                break;
            }
        }
        if(cycle==false) return null;
        ListNode temp =  slow;
        slow = slow.next;
        fast = head;
        while(fast!=slow){
            fast = fast==temp?temp.next:fast.next;
            slow = slow==temp?head:slow.next;
        }
        return fast;

    }
}
