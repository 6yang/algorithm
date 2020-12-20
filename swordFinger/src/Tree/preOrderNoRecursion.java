package Tree;

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class preOrderNoRecursion {
    /*
     * 先序非递归
     * 使用一个栈，右边先进、左边后进
     * */

    public void preOrderNoRecursion(TreeNode root){
        if(root!=null){
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            TreeNode p ;
            while (!stack.isEmpty()){
                p = stack.pop();
                // visit(p);
                if(p.right!=null){
                    stack.push(p.right);
                }
                if(p.left!=null){
                    stack.push(p.left);
                }
            }
        }
    }
}
