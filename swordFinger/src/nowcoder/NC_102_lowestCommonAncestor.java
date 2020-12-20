package nowcoder;

public class NC_102_lowestCommonAncestor {
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // write code here
        return lowestCommon(root,o1,o2).val;
    }

    public TreeNode lowestCommon(TreeNode  root,int o1,int o2){
        if(root==null || root.val == o1||root.val==o2){
            return root;
        }
        TreeNode left = lowestCommon(root.left, o1, o2);
        TreeNode right = lowestCommon(root.right, o1, o2);
        if(left==null){
            return  right;
        }
        if(right==null){
            return left;
        }
        return root;
    }
}
