package offer.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class _62_SerialTree {

    String Serialize(TreeNode root){
        if(root==null){
            return "";
        }
        return Serialize1(root);
    }
    String Serialize1(TreeNode root) {
        String res = "";
        if (root == null) {
            return "#,";
        }
        res += root.val + ",";
        res += Serialize1(root.left);
        res += Serialize1(root.right);

        return res;
    }



    TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String[] values = str.split(",");
        Queue<String> queue = new LinkedList<String>();
        for (int i = 0; i < values.length; i++) {
            queue.offer(values[i]);
        }
        return deserialByPre(queue);
    }

    public TreeNode deserialByPre(Queue<String> q) {
        String value = q.poll();
        if (value.equals("#") ) {
            return null;

        }
        TreeNode root = new TreeNode(Integer.valueOf(value));
        root.left = deserialByPre(q);
        root.right = deserialByPre(q);
        return root;
    }
}
