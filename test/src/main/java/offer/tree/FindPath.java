package offer.tree;

import java.util.ArrayList;

/**
 * 输入一颗二叉树和一个整数， * 打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class FindPath {
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return res;
        }
        int currentNum=0;
        ArrayList<Integer> path=new ArrayList<Integer>();
        FindPath(root, path, res,target,currentNum);
        return res;
    }

    private static void FindPath(TreeNode root,ArrayList<Integer> path,ArrayList<ArrayList<Integer>> arr, int target, int currentNum) {
        if(root==null){
            return;
        }
        currentNum+=root.val;

        //如果是叶节点，并且路径上的和等于输入的值
        boolean leaf=(root.left==null)&&(root.right==null);
        if(leaf){
            if(currentNum==target){
                path.add(root.val);
                arr.add(new ArrayList<Integer>(path));
                path.remove(path.size()-1);
            }
            return;

        }
        //如果不是叶节点
        path.add(root.val);
        FindPath(root.left,path,arr,  target,  currentNum);
        FindPath(root.right,path,arr,  target,  currentNum);
        path.remove(path.size()-1);


    }
}
