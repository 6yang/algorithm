package nowcoder;

public class NC_66_FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode a = pHead1;
        ListNode b = pHead2;
        while(a!=b){
            a = a == null ? pHead2 : a.next;
            b = b == null ? pHead1 : b.next;
        }
        return a;
    }
}
