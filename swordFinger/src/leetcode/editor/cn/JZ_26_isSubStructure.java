package leetcode.editor.cn;

public class JZ_26_isSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A!=null&&B!=null)&&(recur(A,B)||isSubStructure(A.left,B)||isSubStructure(A.right,B));
    }

    private boolean recur(TreeNode a, TreeNode b) {
        if(b==null) return true;
        if(a == null || a.val != b.val) return false;
        return recur(a.left,b.left)&&recur(a.right,b.right);
    }
}
