package offer.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一颗二叉树和一个整数， * 打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class _25_FindPath {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        //List<List<Integer>> res=new ArrayList<ArrayList<Integer>>(); 出错
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> path = new ArrayList<>();
        int cursum = 0;
        findPath(root, sum, cursum, res, path);
        return res;
    }

    public void findPath(TreeNode root, int num, int cursum, List<List<Integer>> res, List<Integer> path) {
        if (root == null) return;
        path.add(root.val);
        cursum += root.val;
        boolean isLeaf = root.left == null && root.right == null;
        if (isLeaf && cursum == num) {
            //此步不new一个会出错！！
            res.add(new ArrayList<Integer>(path));
        }
        if (root.left != null)
            findPath(root.left, num, cursum, res, path);
        if (root.right != null)
            findPath(root.right, num, cursum, res, path);

        path.remove(path.size() - 1);

    }

}
