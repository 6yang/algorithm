package nowcoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.omg.CORBA.INTERNAL;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @author liuyang29 <liuyang29@kuaishou.com>
 * Created on 2020-12-02
 */
public class NC_136_restoreTree {


    HashMap<Integer,Integer> map = new HashMap<>();
    public int[] solve (int[] xianxu, int[] zhongxu) {
        // write code here
        for (int i = 0; i < zhongxu.length; i++) {
            map.put(zhongxu[i],i);
        }
        TreeNode root = buildTree(xianxu,0,xianxu.length-1,zhongxu,0,zhongxu.length-1);
        List<Integer> list = rightView(root);
        int [] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private List<Integer> rightView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue =  new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                if(i == size-1){
                    res.add(node.val);
                }

            }
        }
        return res;
    }


    private TreeNode buildTree(int[] xianxu, int xl, int xr, int[] zhongxu, int zl, int zr) {
        if(xl>xr || zl >zr ) return null;
        TreeNode node = new TreeNode(xianxu[xl]);
        Integer zCenter = map.get(xianxu[xl]);
        int leftSize = zCenter - zl;
        node.left = buildTree(xianxu,xl+1,xl+leftSize,zhongxu,zl,zCenter-1);
        node.right = buildTree(xianxu,xl+leftSize+1,xr,zhongxu,zCenter+1,zr);
        return node;
    }
}
