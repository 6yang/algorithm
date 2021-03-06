//给定一个非空二叉树，返回其最大路径和。 
//
// 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,3]
//
//       1
//      / \
//     2   3
//
//输出：6
// 
//
// 示例 2： 
//
// 输入：[-10,9,20,null,null,15,7]
//
//   -10
//   / \
//  9  20
//    /  \
//   15   7
//
//输出：42 
// Related Topics 树 深度优先搜索 
// 👍 780 👎 0


package leetcode.editor.cn;
//Java：二叉树中的最大路径和
public class P_124_BinaryTreeMaximumPathSum{
    public static void main(String[] args) {
        Solution solution = new P_124_BinaryTreeMaximumPathSum().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = Math.max(0,dfs(root.left)); //左孩子贡献
        int right = Math.max(0,dfs(root.right)); // 右孩子贡献
        res = Math.max(res,root.val+left+right); // 更新

        return root.val + Math.max(left,right);  //返回当前节点的总贡献较大的一个
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}