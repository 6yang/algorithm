package nowcoder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NC_123_SerializeTree {
    StringBuilder sb = new StringBuilder();

    String Serialize(TreeNode root) {
        preOrderSerialize(root);
        return sb.toString();
    }

    private void preOrderSerialize(TreeNode node) {
        if (node == null) {
            sb.append("NULL,");
        } else {
            sb.append(node.val).append(",");
            preOrderSerialize(node.left);
            preOrderSerialize(node.right);
        }
    }

    TreeNode Deserialize(String str) {
        String[] data = str.split(",");
        List<String> listData = new LinkedList<>(Arrays.asList(data));
        return preOrderDeserialize(listData);
    }

    private TreeNode preOrderDeserialize(List<String> listData) {
        if (listData.get(0).equals("NULL")) {
            listData.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(listData.get(0)));
        listData.remove(0);
        node.left = preOrderDeserialize(listData);
        node.right = preOrderDeserialize(listData);
        return node;
    }


}
