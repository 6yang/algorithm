package nowcoder;

/**
 * @author liuyang29 <liuyang29@kuaishou.com>
 * Created on 2021-02-23
 */
public class NC_16_isSymmetric {

    public boolean isSymmetric(TreeNode root) {
        // write code here
        return isSymmetricNode(root, root);
    }

    private boolean isSymmetricNode(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return isSymmetricNode(node1.left,node2.right) && isSymmetricNode(node1.right,node2.left);
    }

}
