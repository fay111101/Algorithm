package leetcode.tree;
/*Given a binary tree and a sum, determine if the tree has a root-to-leaf path
such that adding up all the values along the path equals the given sum.
For example:
Given the below binary tree andsum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path5->4->11->2which sum is 22.*/
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        if(root.left==null&&root.right==null&&sum==root.val){
            return true;
        }
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,
                sum-root.val);
    }
    
    public static void main(String[] args) {
        int[] arr={1,2,0,0,0,0};
        int[] arr1= {1, 2, 4, 0, 0, 5, 0, 0, 3, 0, 0};
        int[] arr2 = {1, 2, 0, 0, 3, 4, 0, 0, 5, 0, 0};
        int[] arr3={1,0,0};
        TreeCommon common = new TreeCommon();
        TreeNode root = null;
        TreeNode root1 = null;
        TreeNode root2 = null;
        root = common.createTrees(arr);
        root1 = common.createTrees(arr1);
        root2 = common.createTrees(arr2);
        PathSum  test=new PathSum ();
        //System.out.println(test.hasPathSum(root,3));
        System.out.println(test.hasPathSum(root1,7));
        System.out.println(test.hasPathSum(root2,1));


    }
}
