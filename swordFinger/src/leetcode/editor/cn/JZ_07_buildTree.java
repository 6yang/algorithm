package leetcode.editor.cn;

import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class JZ_07_buildTree {
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    public TreeNode build(int [] preOrder,int preL,int preR,int [] inOrder,int inL,int inR){
        if(preL>preR||inL>inR) return null;
        TreeNode root = new TreeNode(preOrder[preL]);
        int inCenter = map.get(preOrder[preL]);
        int inLeftSize = inCenter - inL;
        root.left = build(preOrder,preL+1,preL+inLeftSize,inOrder,inL,inCenter-1);
        root.right = build(preOrder,preL+inLeftSize+1,preR,inOrder,inCenter+1,inR);
        return root;
    }
}
