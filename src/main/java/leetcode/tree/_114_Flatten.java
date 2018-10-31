package leetcode.tree;

/**
 * 给定一个二叉树，原地将它展开为链表。
 * 例如，给定二叉树
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * 将其展开为：
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 * https://yq.aliyun.com/articles/3697
 */
public class _114_Flatten {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        while (root != null) {
            if (root.left != null) {
                TreeNode pre = root.left;
                while (pre.right != null)
                    pre = pre.right;
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }

    public void flatten1(TreeNode root) {
        if (root == null) return;
        flatten1(root.left);
        flatten1(root.right);
        TreeNode node = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) {
            root = root.right;
        }
        root.right = node;
    }

//    如果我们从图形的角度来说，每一次都将当前节点的右子树拼接到左子节点的右子树下，再将左节点替换原来的右节点。所以这个例题一步步的操作如下：
//
//            1           1           1
//            / \           \           \
//            2   5           2           2
//            / \   \         / \           \
//            3   4   6       3   4           3
//                                    \           \
//                                    5           4
//                                    \           \
//                                    6           5
//                                    \
//                                    6

    public void flatten2(TreeNode root) {
        if (root == null) return;
        TreeNode temp = root;
        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                temp = current.left;
                while (temp.right != null) temp = temp.right;
                temp.right = current.right;
                current.right = current.left;
                current.left = null;

            }
            current = current.right;
        }
    }
}
