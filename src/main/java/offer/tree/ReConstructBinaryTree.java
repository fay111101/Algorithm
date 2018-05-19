package offer.tree;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 解答：
 *
 * 递归思想，每次将左右两颗子树当成新的子树进行处理，中序的左右子树索引很好找，
 * 前序的开始结束索引通过计算中序中左右子树的大小来计算，然后递归求解，
 * 直到startPre>endPre||startIn>endIn说明子树整理完到。方法每次返回左子树活右子树的根节点
 */
public class ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree1(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0
                || pre.length != in.length) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return constructTree(pre, in, 0, pre.length - 1, 0, in.length - 1, map);
    }

    public TreeNode constructTree(int[] pre, int[] in, int prestart, int preend, int instart, int inend, HashMap map) {
        if (prestart > preend) {
            return null;
        }
        TreeNode root = new TreeNode(pre[prestart]);
        // 在中序遍历中找到根节点的位置
        int index = (int) map.get(pre[prestart]);
        root.left = constructTree(pre, in, prestart + 1, prestart + index - instart, instart, index - 1, map);
        root.right = constructTree(pre, in, prestart + index - instart + 1, preend, index + 1, inend, map);
        return root;
    }


    public TreeNode reConstructBinaryTree2(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode node = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (pre[0] == in[i]) {
                node.left = reConstructBinaryTree2(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                node.right = reConstructBinaryTree2(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
            }
        }
        return node;
    }
}
