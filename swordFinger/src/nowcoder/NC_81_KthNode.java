package nowcoder;

public class NC_81_KthNode {
    private TreeNode target = null;
    private Integer k1 = 0;
    TreeNode KthNode(TreeNode pRoot, int k) {
        k1 = k;
        middleOrder(pRoot);
        return target;
    }

    private void middleOrder(TreeNode pRoot) {
        if (pRoot == null || k1 <= 0) {
            return;
        }
        middleOrder(pRoot.left);
        k1--;
        if(k1 == 0){
            target = pRoot;
            return;
        }
        middleOrder(pRoot.right);
    }
}
