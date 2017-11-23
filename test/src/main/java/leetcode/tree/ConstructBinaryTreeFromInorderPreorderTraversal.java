package leetcode.tree;

public class ConstructBinaryTreeFromInorderPreorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder == null || preorder == null || inorder.length == 0 ||
                preorder.length == 0) {
            return null;
        }
        int length = preorder.length;
        return createTree(preorder, 0, length - 1, inorder, 0, length - 1);
    }

    public TreeNode createTree(int[] preorder, int pstart, int pend, int[]
            inorder, int istart, int
                                       iend) {
        if (pstart > pend || istart > iend) {
            return null;
        }
        int val = preorder[pstart];
        int index = 0;
        for (int i = 0; i < preorder.length; i++) {
            if (inorder[i] == val) {
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(val);
        int leftlen = index - istart;
        root.left = createTree(preorder, pstart + 1, pstart + leftlen, inorder,
                istart, index - 1);
        root.right = createTree(preorder, pstart + leftlen + 1, pend, inorder,
                index + 1, iend);
        return root;
    }
}
