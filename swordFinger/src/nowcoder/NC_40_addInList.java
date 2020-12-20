package nowcoder;

import java.util.Stack;

public class NC_40_addInList {
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode res = new ListNode(0);
        int up = 0;

        while(head1!=null){
            stack1.push(head1.val);
            head1 = head1.next;
        }
        while (head2!=null){
            stack2.push(head2.val);
            head2 = head2.next;
        }
        while(!stack1.isEmpty()&&!stack2.isEmpty()){
            int val = stack1.pop() + stack2.pop()+ up;
            up = val/10;
            ListNode cur = new ListNode(val%10);
            cur.next = res.next;
            res.next = cur;
        }

        while(!stack1.isEmpty()){
            int val = stack1.pop() + up;
            up = val/10;
            ListNode cur = new ListNode(val%10);
            cur.next = res.next;
            res.next = cur;
        }
        while(!stack2.isEmpty()){
            int val = stack2.pop() + up;
            up = val/10;
            ListNode cur = new ListNode(val%10);
            cur.next = res.next;
            res.next = cur;
        }
        if(up!=0){
            ListNode cur = new ListNode(up);
            cur.next = res.next;
            res.next = cur;
        }
        return res.next;
    }
}
