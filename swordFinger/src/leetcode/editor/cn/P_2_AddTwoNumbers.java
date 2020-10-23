package leetcode.editor.cn;
//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 5110 👎 0


//Java：两数相加
public class P_2_AddTwoNumbers{
    public static void main(String[] args) {
        Solution solution = new P_2_AddTwoNumbers().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode n1 = l1,n2 = l2,rn = res;
        int jw = 0;
        while(n1!=null && n2!=null){
            rn.next = new ListNode((n1.val+n2.val+jw)%10);
            jw = (n1.val + n2.val + jw)/10;
            n1 = n1.next;
            n2 = n2.next;
            rn = rn.next;
        }
        while(n1!=null){
            rn.next = new ListNode((n1.val+jw)%10);
            jw = (n1.val+jw)/10;
            n1 = n1.next;
            rn = rn.next;
        }
        while(n2!=null){
            rn.next = new ListNode((n2.val+jw)%10);
            jw = (n2.val+jw)/10;
            n2 = n2.next;
            rn = rn.next;
        }
        if(jw!=0){
            rn.next = new ListNode(jw);
        }
        return res.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}