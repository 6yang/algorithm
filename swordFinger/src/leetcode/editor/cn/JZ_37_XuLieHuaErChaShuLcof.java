
package leetcode.editor.cn;
//请实现两个函数，分别用来序列化和反序列化二叉树。 
//
// 示例: 
//
// 你可以将以下二叉树：
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
//序列化为 "[1,2,3,null,null,4,5]" 
//
// 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-b
//inary-tree/ 
// Related Topics 树 设计 
// 👍 74 👎 0


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//Java：序列化二叉树
public class JZ_37_XuLieHuaErChaShuLcof {
    public static void main(String[] args) {
        // Solution solution = new XuLieHuaErChaShuLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return preOrderSerialize(root,new StringBuilder());
    }

    private String preOrderSerialize(TreeNode root, StringBuilder str) {
        if(root == null) {
            str.append("NULL,");
        }else {
            str.append(root.val+",");
            preOrderSerialize(root.left,str);
            preOrderSerialize(root.right,str);
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] splitData = data.split(",");
        List<String> listData = new LinkedList<>(Arrays.asList(splitData));
        return preOrderDeserialize(listData);
    }

    private TreeNode preOrderDeserialize(List<String> listData) {
        if (listData.get(0).equals("NULL")){
            listData.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(listData.get(0)));
        listData.remove(0);
        root.left = preOrderDeserialize(listData);
        root.right = preOrderDeserialize(listData);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}