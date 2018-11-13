package leetcode.tree;

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example 1:
 *
 * Given the following tree [3,9,20,null,null,15,7]:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Return true.
 *
 * Example 2:
 *
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *    / \
 *  4   4
 *  二叉平衡树为该二叉树中任意节点的左右字数的深度之差都不大于1.
 */
public class _110_BalancedBinaryTree {

    public boolean isBalanced(TreeNode root){
        if(root==null){
            return true;
        }
        int left= getDepth(root.left);
        int right= getDepth(root.right);
        if(Math.abs(left-right)>1){
            return false;
        }
        return isBalanced(root.left)&&isBalanced(root.right);
    }
    public int getDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int left= getDepth(root.left);
        int right= getDepth(root.right);
        return Math.max(left,right)+1;
    }
    public static void main(String[] args) {
        int[] arr={1,2,4,0,0,5,0,0,3,0,0};
        int[] arr1={1,2,0,0,3,4,0,0,5,0,0};
        //按照方法run1这种情况最小深度等于2,按照方法run2这种情况最小深度为1;
        int[] arr2={1,2,0,0,0,0};
        TreeCommon common=new TreeCommon();
        TreeNode root = null;
        root = common.createTrees(arr1);
        _110_BalancedBinaryTree test=new _110_BalancedBinaryTree();
        int high = test.getDepth(root);
//        int high = min.run2(root);
        System.out.println(high);

    }
}
