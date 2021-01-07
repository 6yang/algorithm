package nowcoder;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;


public class NC_51_mergeKLists {

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists==null || lists.size()<1) return null;
        if(lists.size() == 1) return lists.get(0);
        if(lists.size()%2!=0) lists.add(null);
        ArrayList<ListNode> res = new ArrayList<>();
        for (int i = 0; i < lists.size(); i+=2) {
            res.add(mergeTwoList(lists.get(i),lists.get(i+1)));
        }
        return mergeKLists(res);
    }

    public ListNode mergeTwoList(ListNode l1, ListNode l2){
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = (l1 == null)?l2:l1;
        return res.next;
    }

    public ListNode mergeKLists_heap(ArrayList<ListNode> lists) {
        ListNode res = new ListNode(0);
        ListNode next = res;
        Queue<ListNode> heap = new PriorityQueue<>((o1, o2) ->o1.val -o2.val);
        for (ListNode list : lists) {
            if(list!=null){
                heap.offer(list);
            }
        }
        while (!heap.isEmpty()){
            ListNode cur = heap.poll();
            next.next = cur;
            next = next.next;
            if(cur.next!=null){
                heap.offer(cur.next);
            }
        }
        return res.next;
    }
}
