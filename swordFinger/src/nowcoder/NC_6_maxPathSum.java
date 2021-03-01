package nowcoder;

public class NC_6_maxPathSum {

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        // write code here
        if (root == null) {
            return 0;
        }
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0,dfs(root.left));
        int right = Math.max(0,dfs(root.right));
        res = Math.max(res,left + right +root.val);
        return root.val + Math.max(left,right);
    }
}
