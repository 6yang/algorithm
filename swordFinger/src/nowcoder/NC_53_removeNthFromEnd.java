package nowcoder;

public class NC_53_removeNthFromEnd {
    public ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        ListNode node = head;
        ListNode result = head;
        ListNode begin = head;
        int size = 0;
        while(node!=null){
            size++;
            node = node.next;
        }
        size = size-n;
        if(size==0){
            result = result.next;
            return result;
        }
        for (int i = 0; i < size-1; i++) {
            result = result.next;
        }
        result.next = result.next.next;
        return begin;
    }
}
