package leetcode.editor.cn;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
public class JZ_06_reversePrint {
    public int[] reversePrint(ListNode head) {
        int length = 0;
        ListNode next = head;
        while(next!=null){
            length++;
            next = next.next;
        }
        int [] print = new int[length];
        next = head;
        for (int i = length - 1; i >= 0; i--) {
            print[i] = next.val;
            next = next.next;
        }
        return print;
    }
}

