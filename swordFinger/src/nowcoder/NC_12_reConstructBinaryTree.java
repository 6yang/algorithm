package nowcoder;


import java.util.HashMap;

public class NC_12_reConstructBinaryTree {

    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return build(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode build(int[] pre, int preL, int preR, int[] in, int inL, int inR) {
        if (preL > preR || inL > inR) {
            return null;
        }
        TreeNode node = new TreeNode(pre[preL]);
        int inC = map.get(pre[preL]);
        int leftSize = inC - inL;
        node.left = build(pre,preL+1,preL+leftSize,in,inL,inC-1);
        node.right = build(pre,preL+leftSize+1,preR,in,inC+1,inR);
        return  node;
    }
}
