package leetcode.tree;

/**
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
 * <p>
 * Example 1:
 * Given tree s:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * Given tree t:
 * 4
 * / \
 * 1   2
 * Return true, because t has the same structure and node values with a subtree of s.
 * Example 2:
 * Given tree s:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * /
 * 0
 * Given tree t:
 * 4
 * / \
 * 1   2
 * Return false.
 */
public class _572_SubtreeofAnotherTree {


    public boolean hasSameVal(TreeNode s, TreeNode t) {
        if (t == null && s == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return hasSameVal(s.left, t.left) && hasSameVal(s.right, t.right);
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (hasSameVal(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isSubtree1(TreeNode s, TreeNode t) {
        // Write your code here
        if (s == null) {
            return t == null;
        }

        if (s.val == t.val && isSametree1(s, t)) {
            return true;
        }

        return isSubtree1(s.left, t) | isSubtree1(s.right, t);
    }

    private boolean isSametree1(TreeNode s, TreeNode t) {
        if (s == null) {
            return t == null;
        }
        if (t == null) {
            return false;
        }

        if (s.val != t.val) {
            return false;
        }

        return isSametree1(s.left, t.left) & isSametree1(s.right, t.right);
    }
}
