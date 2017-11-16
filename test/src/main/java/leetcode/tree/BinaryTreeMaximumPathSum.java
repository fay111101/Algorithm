package leetcode.tree;
/*Given a binary tree, find the maximum path sum.
The path may start and end at any node in the tree.
For example:
Given the below binary tree,
       1
      / \
     2   3

Return6.
       1
      / \
     2   3
    / \
   4  5
Return11
注意：树的节点的值root.val可以是负数
*/
public class BinaryTreeMaximumPathSum {
    int maxsum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        maxPath(root);
        return maxsum;
    }
    public int maxPath(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=maxPath(root.left);
        int right=maxPath(root.right);
        int sum=root.val;
        if(left>0){
            sum=sum+left;
        }
        if(right>0){
            sum=sum+right;
        }
        if(maxsum<sum){
            maxsum=sum;
        }
        return Math.max(left,right)>0?Math.max(left,right)+root.val:root.val;
    }
    public static void main(String[] args) {
        int[] arr={1,2,0,0,0,0};
        int[] arr0={1,-2,3,0,0,0,0};
        int[] arr1 = {1, 2, 0, 0, 3, 4, 0, 0, 5, 0, 0};
        int[] arr2= {1, 2, 4,0,0,5,0,0, 3, 0, 0};
        int[] arr3={1,2,0,0,3,0,0};
        int[] arr4={1,0,0};
        TreeCommon common = new TreeCommon();
        TreeNode root = null;
        TreeNode root1 = null;
        TreeNode root2 = null;
        TreeNode root3 = null;
        TreeNode root4 = null;
        root = common.createTrees(arr);
        root1 = common.createTrees(arr1);
        root2 = common.createTrees(arr2);
        root3 = common.createTrees(arr3);
        root4 = common.createTrees(arr4);
        BinaryTreeMaximumPathSum  test=new BinaryTreeMaximumPathSum();
        //System.out.println(test.maxPathSum(root1));
        //System.out.println(test.maxPathSum(root2));
        System.out.println(test.maxPathSum(root3));
        //System.out.println(test.maxPathSum(root4));
    }
}
