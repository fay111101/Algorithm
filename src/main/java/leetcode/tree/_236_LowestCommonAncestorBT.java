package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 * _______3______
 * /              \
 * ___5__          ___1__
 * /      \        /      \
 * 6      _2       0       8
 * /  \
 * 7   4
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 * https://blog.csdn.net/qq_26437925/article/details/72627847
 * https://blog.csdn.net/qq_25827845/article/details/74612786
 */
public class _236_LowestCommonAncestorBT {

    /**
     * 本题与LeetCode 235的区别就是由二叉查找树变为了二叉树，即数据从有序变为了无序，
     * 那么就不能通过root的值和两个节点的值的大小关系来划分查找区域。
     * 在题235的代码基础做了些许变动，同样使用递归搜索的方法，当root非空时，
     * 对root->left和root->right分别进行搜索。若搜索结果均非空，说明两个节点分别位于左右子树之中，
     * LCA则为root；若只有一个结果为空，则LCA是另一个非空的节点；若结果均空，则返回NULL。
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }


    //https://blog.csdn.net/qq_26437925/article/details/72627847

    TreeNode result = null;

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        lca(root, p, q);
        return result;

    }


    /**
     * 遍历二叉树时，只有先访问给定两节点A、B后，才可能确定其最近共同父节点C，因而采用后序遍历。
     *
     * 可以统计任一节点的左右子树“是否包含A、B中的某一个”（也可以直接统计“包含了几个A、B”）。
     * 当后序遍历访问到某个节点D时，可得到三条信息：
     * (1）节点D是否是A、B两节点之一、（2）其左子树是否包含A、B两节点之一、
     * (3）其右子树是否包含A、B两节点之一。当三条信息中有两个为真时，
     * 就可以确定节点D的父节点（或节点D，如果允许一个节点是自身的父节点的话）
     * 就是节点A、B的最近共同父节点。另外，找到最近共同父节点C后应停止遍历其它节点。
     *
     * @param root
     * @param p
     * @param q    //     * @param result
     * @return
     */
    //在函数中将引用传递给另一个数值，详见C的一级指针和二级指针
    boolean lca(TreeNode root, TreeNode p, TreeNode q) {
        // left/right 左/右子树是否含有要判断的两节点之一
        boolean left = false, right = false;
        if (result == null && root.left != null)
            left = lca(root.left, p, q);
        if (result == null && root.right != null)
            right = lca(root.right, p, q);

        boolean mid = false;
        if (root.val == p.val || root.val == q.val)
            mid = true;
        boolean tmp = (left & right) || (right & mid) || (mid & left);
        if (result == null && tmp) {
            //相当于把引用给另一个值，因此返回空
            result = root;
            System.out.println(result);
        }

        return left | mid | right;
    }


    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null)
            return null;
        List<TreeNode> pathp = new ArrayList<>();
        List<TreeNode> pathq = new ArrayList<>();
        pathp.add(root);
        pathq.add(root);

        getPath(root, p, pathp);
        getPath(root, q, pathq);

        TreeNode lca = null;
        for (int i = 0; i < pathp.size() && i < pathq.size(); i++) {
            if (pathp.get(i) == pathq.get(i))
                lca = pathp.get(i);
            else
                break;
        }
        return lca;
    }

    private boolean getPath(TreeNode root, TreeNode n, List<TreeNode> path) {
        if (root == n)
            return true;

        if (root.left != null) {
            path.add(root.left);
            if (getPath(root.left, n, path))
                return true;
            path.remove(path.size() - 1);
        }

        if (root.right != null) {
            path.add(root.right);
            if (getPath(root.right, n, path))
                return true;
            path.remove(path.size() - 1);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr2 = {5, 3, 6, 2, 4, 0, 0, 1};
        int[] arr1 = {6};
        int[] arr = {3, 2, 4, 1};
        TreeCommon common = new TreeCommon();
        TreeNode root2, root1, root = null;
        root2 = common.buildTree(arr2, 0);
        root1 = common.buildTree(arr1, 0);
        root = common.buildTree(arr, 0);
        _236_LowestCommonAncestorBT test = new _236_LowestCommonAncestorBT();
        test.lowestCommonAncestor2(root2, root, root1);

        /**
         * BUG!!!
         * 输入：
         * [3,5,1,6,2,0,8,null,null,7,4]
         * 5
         * 4
         * 输出：
         * 3
         * 预期：
         * 5
         */
    }


}
/**
 * class Solution {
 * public:
 *
 * bool lca(TreeNode *root, TreeNode* va, TreeNode* vb, TreeNode *&result)
 * {
 * // left/right 左/右子树是否含有要判断的两节点之一
 * bool left = false, right = false;
 * if (!result && root->left != NULL)
 * left = lca(root->left,va,vb,result);
 * if (!result && root->right != NULL)
 * right = lca(root->right,va,vb,result);
 *
 * // mid 当前节点是否是要判断的两节点之一
 * bool mid = false;
 * if (root == va || root == vb)
 * mid = true;
 *
 * if (!result && int(left + right + mid) == 2)
 * {
 * result = root;// root就是后序遍历（左，右，根），当前遍历的那个节点
 * }
 * return left | mid | right ;
 * }
 *
 * TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q)
 * {
 * if (root == NULL)
 * return NULL;
 *
 * TreeNode *result = NULL;
 * lca(root, p, q,result);
 *
 * return result;
 * }
 * };
 */
