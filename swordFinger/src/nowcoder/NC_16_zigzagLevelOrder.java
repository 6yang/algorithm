package nowcoder;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class NC_16_zigzagLevelOrder {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder (TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root ==null ) return res;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if(level%2!=0){
                    TreeNode node = queue.pollLast();
                    list.add(node.val);
                    if(node.left!=null){
                        queue.addFirst(node.left);
                    }
                    if(node.right!=null){
                        queue.addFirst(node.right);
                    }
                }else {
                    TreeNode node = queue.pollFirst();
                    list.add(node.val);
                    if(node.right!=null){
                        queue.addLast(node.right);
                    }
                    if(node.left!=null){
                        queue.addLast(node.left);
                    }
                }
            }
            res.add(list);
            level++;
        }
        return res;
    }

    public static void main(String[] args) {
    }
}
