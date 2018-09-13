package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its minimum depth = 2.
 * 给定一个二叉树，求出它的最小深度，最小深度是从根节点到最近的叶子节点的最短路径的节点数。
 */
public class _111_MinimumDepthofBinary {
    /**
     * 遍历一棵二叉树，从根部看起，查看它是否有左右结点。有五种情况
     * 1.没有根节点，那结果就是0
     * 2.有根节点，没有左右子树，结果为1
     * 3.没有左子树，有右子树。把右子树看成一棵新的树。
     * 4.没有右子树，有左子树。把左子树看成一棵新的树。
     * 5.既有左子树，又有右子树。那就把左右子树分别都看成新的树，最后比较谁的最近叶子的路径短，就取哪边。
     * 因为都把左右子树看成新的树了，所以每一棵树都可以用2-3-4-5来判断找出最近叶子的最短路径。
     * 每一棵树都调用这个判断的方法，所以就是递归
     * 【考察】：树的深度优先遍历结合递归的使用
     * @param root
     * @return
     * BUG Here!
     * 输入：
     * [1,2]
     * 输出：
     * 1
     * 预期：
     * 2
     */
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null&&root.right==null) return 1;
        if(root.left==null) return minDepth(root.right)+1;
        else if(root.right==null) return minDepth(root.left)+1;
        else return 1+Math.min(minDepth(root.left),minDepth(root.right));
    }
    public int run1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int high = 1;
        int current = 1;
        int next = 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        boolean flag = false;
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            current--;

            //此情况为从左到右的情况
            if (n.left != null) {
                q.offer(n.left);
                next++;
            }
            if (n.right != null) {
                q.offer(n.right);
                next++;
            }
            if(n.left==null&&n.right==null){
                return high;
            }
            if (current == 0) {
                high++;
                current = next;
                next = 0;
            }
        }
        return high;
    }

    public int run2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int high = 1;
        int current = 1;
        int next = 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        boolean flag = false;
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            current--;

            //此情况为从左到右的情况
            if (n.left != null) {
                q.offer(n.left);
                next++;
            }
            if (n.right != null) {
                q.offer(n.right);
                next++;
            }
            if(n.left==null&&n.right==null){

                if (next == 0 && current == next && n != root) {
                    high--;
                    return high;
                    //System.out.println(high);
                }
                return high;


            }
            if (current == 0) {
                high++;
                current = next;
                next = 0;
            }
        }
        return high;
    }


    public static void main(String[] args) {
        int[] arr={1,2,4,0,0,5,0,0,3,0,0};
        int[] arr1={1,2,0,0,3,4,0,0,5,0,0};
        //按照方法run1这种情况最小深度等于2,按照方法run2这种情况最小深度为1;
        int[] arr2={1,2,0,0,0,0};
        TreeCommon common=new TreeCommon();
        TreeNode root = null;
        root = common.createTrees(arr1);
        _111_MinimumDepthofBinary min = new _111_MinimumDepthofBinary();
        int high = min.minDepth(root);
//        int high = min.run2(root);
        System.out.println(high);

    }
}
