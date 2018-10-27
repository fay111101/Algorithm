package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

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

/**
 * 结合题目中的例子，简述思路如下：
      1.采用中序遍历，则从根节点5起，首先搜索左孩子节点，一直到达叶子节点为止，第一条合法路径为：5-4-11-7，检验路径和是否满足约束条件（sum==22）；
      2.若满足则将路径保存起来；
      3.然后，当前路径尾端数据弹出，剩余5-4-11，返回，相当于回到根节点11；
      4.继续搜索右孩子结点，2为叶子节点，因而合法路径为：5-4-11-2，检验其是否满足约束条件；
      5.....
 【注意事项】执行当前路径尾端数据弹出的操作有两个位置：
      1.遍历至叶子节点，形成合法路径，在检验路径是否满足约束条件并保存后，弹出末端数据，返回，如此便可回到最近的根节点，然后继续搜索该根节点的子节点；
      2.某一根节点的左右子节点遍历完毕，如根节点11的子节点7和2遍历完毕，须返回上一层，这时候需要弹出根节点11，
        则当前搜索路径变为：5-4；根节点4没有右叶子节点，弹出4，返回上一层5,根节点5有右子节点，继续中序遍历..

 */
public class _113_PathSum2 {


    List<List<Integer>> result = new
            ArrayList<>();
    ArrayList<Integer> list = new ArrayList();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return result;
        }
        getPath(root, sum);
        return result;
    }

    private void getPath(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            result.add(new ArrayList<>(list));
        }
        getPath(root.left, sum - root.val);
        getPath(root.right, sum - root.val);
        list.remove(list.size() - 1);
    }

    public List<List<Integer>> pathSum1(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> path = new ArrayList<>();
        int cursum = 0;
        findPath(root, sum, cursum, res, path);
        return res;
    }


    public void findPath(TreeNode root, int sum, int cursum, List<List<Integer>> res, List<Integer> path) {
        if (root == null) return;
        path.add(root.val);
        cursum += root.val;
        boolean isLeaf = root.left == null && root.right == null;
        if (isLeaf && cursum == sum) {

            res.add(new ArrayList<Integer>(path));
//            res.add(path);
        }
        if (root.left != null)
            findPath(root.left, sum, cursum, res, path);
        if (root.right != null)
            findPath(root.right, sum, cursum, res, path);

        path.remove(path.size() - 1);

    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 0, 0, 0};
        int[] arr0 = {1, -2, 3, 0, 0, 0, 0};
        int[] arr3 = {1, -2, 0, 0, 3, 0, 0};
        int[] arr2 = {1, 2, 4, 0, 0, 4, 0, 0, 3, 0, 0};
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
        _113_PathSum2 test = new _113_PathSum2();
//        System.out.println(test.pathSum(root,7));
        System.out.println(test.pathSum1(root2, 7));
        //System.out.println(test.pathSum(root3,1));
        //System.out.println(test.pathSum(root1,1));
        // System.out.println(test.pathSum(root2,1));


    }
}
