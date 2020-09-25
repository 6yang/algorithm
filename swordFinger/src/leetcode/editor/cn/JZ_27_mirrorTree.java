package leetcode.editor.cn;

public class JZ_27_mirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }

}
