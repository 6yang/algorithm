package nowcoder;

/**
 * @author liuyang29 <liuyang29@kuaishou.com>
 * Created on 2021-01-07
 */
// 平衡二叉树
public class NC_62_IsBalanced_Tree {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(maxDepthTree(root.left) - maxDepthTree(root.right)) > 1) {
            return false;
        } else {
            return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
        }
    }

    public int maxDepthTree(TreeNode node) {
        return node == null ? 0 : Math.max(maxDepthTree(node.left), maxDepthTree(node.right)) + 1;
    }

}
