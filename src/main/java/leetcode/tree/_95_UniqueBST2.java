package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * * Created by fay on 2017/12/6.
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */
public class _95_UniqueBST2 {

    public List<TreeNode> generateTrees(int n) {
        return createTree(1, n);
    }

    public List<TreeNode> createTree(int low, int high) {
        List<TreeNode> result = new ArrayList<>();
        if (low > high) {
            result.add(null);
            return result;
        }
        for (int i = low; i <= high; i++) {
            // 求根结点i的左右子树集合
            List<TreeNode> left = createTree(low, i - 1);
            List<TreeNode> right = createTree(i + 1, high);
            for (int j = 0; j < left.size(); j++) {
                for (int k = 0; k < right.size(); k++) {
                    // 将左右子树相互配对，每一个左子树都与所有右子树匹配，每一个右子树都与所有的左子树匹配
                    TreeNode newNode = new TreeNode(i);
                    newNode.left = left.get(j);
                    newNode.right = right.get(k);
                    result.add(newNode);
                }
            }
        }
        return result;
    }

    void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getVal());
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        _95_UniqueBST2 test = new _95_UniqueBST2();
        List<TreeNode> list = test.generateTrees(3);
        for (TreeNode t : list) {
            TreeNode root = t;
            test.preOrder(root);
            System.out.println();
        }
    }
}
