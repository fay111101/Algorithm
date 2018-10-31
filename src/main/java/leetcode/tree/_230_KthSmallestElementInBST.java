package leetcode.tree;

/**
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * 输出: 1
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 3
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 */
public class _230_KthSmallestElementInBST {


    private TreeNode temp;
    private int counter;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return temp.val;
    }

    public void inorder(TreeNode node, int k) {
        // perform in order tree traversal
        if (node == null)
            return; // base case
        inorder(node.left, k);
        if (++counter == k) {
            temp = node;
            return;
        }
        inorder(node.right, k);
    }

    public int kthSmallest1(TreeNode root, int k) {
        int mark = 0;
        return search(root, k, mark);
    }

    public boolean flag = false;

    public int search(TreeNode node, int k, int mark) {
        if (node.left != null && flag == false) {
            mark = search(node.left, k, mark);
        }

        if (mark + 1 == k && !flag) {
            flag = true;
            return node.val;
        }
        if (!flag)
            mark++;
        if (node.right != null && flag == false) {
            mark = search(node.right, k, mark);
        }
        return mark;
    }

    public static void main(String[] args) {
        int[] arr2 = {5, 3, 6, 2, 4, 0, 0, 1};
        TreeCommon common = new TreeCommon();
        TreeNode root2 = null;
        root2 = common.buildTree(arr2, 0);
        ;
        _230_KthSmallestElementInBST test = new _230_KthSmallestElementInBST();
//        System.out.println(test.pathSum(root,7));
        System.out.println(test.kthSmallest(root2, 7));
        //System.out.println(test.pathSum(root3,1));
        //System.out.println(test.pathSum(root1,1));
        // System.out.println(test.pathSum(root2,1));


    }
}
