package nowcoder;

/**
 * @author liuyang29 <liuyang29@kuaishou.com>
 * Created on 2021-02-23
 */
public class NC_24_deleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        // write code here
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;

        ListNode prev = tempHead;
        ListNode curr = prev.next;
        while (curr != null) {
            int curRepeatNum = 0;
            ListNode difNode = curr;
            while(difNode!=null && curr.val == difNode.val){
                curRepeatNum++;
                difNode = difNode.next;
            }

            if(curRepeatNum>1){
                prev.next = difNode;
            }else {
                prev = curr;
            }
            curr = difNode;
        }
        return tempHead.next;
    }
}
