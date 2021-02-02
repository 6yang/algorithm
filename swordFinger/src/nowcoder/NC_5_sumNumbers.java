package nowcoder;


// leetcode 129
public class NC_5_sumNumbers {
    public int sumNumbers (TreeNode root) {
        // write code here
        return getSum(root , 0);
    }

    private int getSum(TreeNode root, int i) {
        if (root == null ) return 0;
        int temp = root.val + i*10;
        if(root.left == null && root.right == null){
            return temp;
        }
        return getSum(root.left,temp) + getSum(root.right,temp);
    }
}
