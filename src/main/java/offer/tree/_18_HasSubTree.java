package offer.tree;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 区别与leetcode572
 */
public class _18_HasSubTree {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean res = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                res = DoesR1HasR2(root1, root2);
            }
            if (!res) {
                res = HasSubtree(root1.left, root2);
            }
            if (!res) {
                res = HasSubtree(root1.right, root2);
            }
        }
        return res;
    }

    public boolean DoesR1HasR2(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        boolean res1 = false, res2 = false;
        if (root1.val != root2.val) {
            return false;
        }
        res1 = DoesR1HasR2(root1.left, root2.left);
        res2 = DoesR1HasR2(root1.right, root2.right);
        return res1 && res2;
    }
}
