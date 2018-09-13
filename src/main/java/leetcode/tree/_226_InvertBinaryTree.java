package leetcode.tree;

/**
 * Invert a binary tree.
 *
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * Trivia:
 * This problem was inspired by this original tweet by Max Howell:
 *
 * Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.
 */
public class _226_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        if(root.left==null&&root.right==null) return root;
        //交换两个子节点
        TreeNode tmp=root.left;
        root.left=root.right;
        root.right=tmp;
        //对左右子树分别调用递归函数交换他们的子节点
        if(root.left!=null) invertTree(root.left);
        if(root.right!=null) invertTree(root.right);
        return root;
    }
}
