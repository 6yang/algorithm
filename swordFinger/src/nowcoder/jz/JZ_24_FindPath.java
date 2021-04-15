package nowcoder.jz;

import java.util.ArrayList;



public class JZ_24_FindPath {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        dfs(root,target);
        return res;
    }

    private void dfs(TreeNode node, int target) {
        if(node == null) return;
        path.add(node.val);
        target -= node.val;
        if(node.left == null && node.right ==null && target ==0){
            res.add(new ArrayList<>(path));
        }
        dfs(node.left,target);
        dfs(node.right,target);
        path.remove(path.size()-1);
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
