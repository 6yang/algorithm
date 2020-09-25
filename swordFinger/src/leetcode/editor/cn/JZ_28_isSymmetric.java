package leetcode.editor.cn;

public class JZ_28_isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode l1, TreeNode r1) {
        if (r1 == null && l1 == null) {
            return true;
        }
        if (r1 == null || l1 == null) {
            return false;
        }
        return l1.val == r1.val &&isMirror(l1.left,r1.right)&&isMirror(l1.right,r1.left);
    }
}
