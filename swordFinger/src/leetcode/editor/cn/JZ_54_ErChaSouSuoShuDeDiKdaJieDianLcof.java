package leetcode.editor.cn;
//给定一棵二叉搜索树，请找出其中第k大的节点。 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 1 ≤ k ≤ 二叉搜索树元素个数 
// Related Topics 树 
// 👍 68 👎 0


//Java：二叉搜索树的第k大节点
public class JZ_54_ErChaSouSuoShuDeDiKdaJieDianLcof {
    public static void main(String[] args) {
        Solution solution = new JZ_54_ErChaSouSuoShuDeDiKdaJieDianLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //思路：二插搜索树的中序遍历递增有序的（左中右）
    //所以要寻找第k大个只需要逆中序遍历就可以
    //逆中序遍历的是递减的（右中左）
    int res,k;
    public int kthLargest(TreeNode root, int k) {
        if(root == null) return 0;
        this.k = k;
        reverseMiddleOrder(root);
        return res;
    }

    private void reverseMiddleOrder(TreeNode root) {
        if(root!=null){
            reverseMiddleOrder(root.right);
            if(--k ==0) {
                res = root.val;
                return;
            }
            reverseMiddleOrder(root.left);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}