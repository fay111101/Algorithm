package leetcode.tree;

/**
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。

 例如，从根到叶子节点路径 1->2->3 代表数字 123。

 计算从根到叶子节点生成的所有数字之和。

 说明: 叶子节点是指没有子节点的节点。

 示例 1:

 输入: [1,2,3]
 1
 / \
 2   3
 输出: 25
 解释:
 从根到叶子节点路径 1->2 代表数字 12.
 从根到叶子节点路径 1->3 代表数字 13.
 因此，数字总和 = 12 + 13 = 25.
 示例 2:

 输入: [4,9,0,5,1]
 4
 / \
 9   0
 / \
 5   1
 输出: 1026
 解释:
 从根到叶子节点路径 4->9->5 代表数字 495.
 从根到叶子节点路径 4->9->1 代表数字 491.
 从根到叶子节点路径 4->0 代表数字 40.
 因此，数字总和 = 495 + 491 + 40 = 1026.
 */
public class _129_SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum=0;
        return preOrderSum(root,sum);

    }
    public  int preOrderSum(TreeNode root,int sum){

        if(root==null){
            return  0;
        }
        sum=root.val+sum*10;
        if(root.left==null&&root.right==null){
            return sum;
        }
        int left=preOrderSum(root.left,sum);
        int right=preOrderSum(root.right,sum);
        return left+right;
//        return preOrderSum(root.left,sum)+ preOrderSum(root.right,sum);
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 0, 0, 5, 0, 0, 3, 0, 0};
        int[] arr1 = {1, 2, 0, 0, 3, 4, 0, 0, 5, 0, 0};
        TreeCommon common = new TreeCommon();
        TreeNode root = null;
        root = common.createTrees(arr);
        _129_SumRootToLeafNumbers test=new _129_SumRootToLeafNumbers();
        System.out.println(test.sumNumbers(root));


    }
}
