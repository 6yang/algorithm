package nowcoder;

import java.util.LinkedList;
import java.util.Queue;

public class NC_60_judgeIt {
    public boolean[] judgeIt (TreeNode root) {
        // write code here
        boolean [] res = new boolean[2];
        res[0] = isValidBST(root);
        res[1] = isValidCBT(root);
        return res;
    }
    // 完全二叉树
    private boolean isValidCBT(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        boolean leaf = false;
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            TreeNode left = curr.left;
            TreeNode right = curr.right;
            if((leaf&&(left!=null||right!=null)) || (left== null&& right!=null)) {
                return false;
            }
            if(left!=null) queue.add(left);
            if(right!=null) queue.add(right);
            else leaf = true;
        }
        return true;
    }

    // 验证是否为二叉搜索树 中序遍历的结果是从小到大的结果
    long pre  = Long.MIN_VALUE;
    private boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if(!isValidBST(root.left)) return false;
        if(pre >= root.val) return false;
        pre = root.val;
        return isValidBST(root.right);
    }
}
