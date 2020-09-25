package leetcode.editor.cn;

public class JZ_25_mergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode li = l1;
        ListNode lj = l2;
        ListNode res = new ListNode(0);
        ListNode ne = res;
        while(li!=null && lj !=null){
            if (li.val<=lj.val){
                ne.next = li;
                li = li.next;
            }else {
                ne.next = lj;
                lj = lj.next;
            }
            ne =ne.next;
        }
        if(li!=null){
            ne.next = li;
        }
        if(lj!=null){
            ne.next = lj;
        }
        return res.next;
    }
}
