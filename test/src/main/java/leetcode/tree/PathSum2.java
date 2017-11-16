package leetcode.tree;

import java.util.ArrayList;

/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's
sum equals the given sum.
For example:
Given the below binary tree andsum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
*/
public class PathSum2 {
    ArrayList<ArrayList<Integer>> result=new
            ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> list=new ArrayList();
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum){
        if(root==null){
            return result;
        }
        getPath(root,sum);
        return result;
    }
    private void getPath(TreeNode root,int sum){
        if(root==null){
            return ;
        }
        list.add(root.val);
        if(root.left==null&&root.right==null&&root.val==sum){

            result.add(new ArrayList<>(list));
            //result.add(list);
            //list.remove(list.size()-1);
            //return;
        }
        //list.add(root.val);
        getPath(root.left,sum-root.val);
        getPath(root.right,sum-root.val);
        list.remove(list.size()-1);


    }
    public static void main(String[] args) {
        int[] arr={1,2,0,0,0,0};
        int[] arr0={1,-2,3,0,0,0,0};
        int[] arr3={1,-2,0,0,3,0,0};
        int[] arr2= {1, 2, 4, 0, 0, 4, 0, 0, 3, 0, 0};
        int[] arr1 = {1, 2, 0, 0, 3, 4, 0, 0, 5, 0, 0};
        TreeCommon common = new TreeCommon();
        TreeNode root = null;
        TreeNode root1 = null;
        TreeNode root2 = null;
        TreeNode root3 = null;
        root = common.createTrees(arr);
        root1 = common.createTrees(arr1);
        root2 = common.createTrees(arr2);
        root3 = common.createTrees(arr3);
        PathSum2  test=new PathSum2 ();
//        System.out.println(test.pathSum(root,7));
        System.out.println(test.pathSum(root2,7));
        //System.out.println(test.pathSum(root3,1));
        //System.out.println(test.pathSum(root1,1));
       // System.out.println(test.pathSum(root2,1));


    }
}
