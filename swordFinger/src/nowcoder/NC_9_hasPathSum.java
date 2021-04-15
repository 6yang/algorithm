package nowcoder;

public class NC_9_hasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        // write code here
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum - root.val == 0;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
