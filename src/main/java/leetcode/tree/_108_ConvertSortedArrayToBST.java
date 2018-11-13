package leetcode.tree;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p>
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two
 * subtrees of every node never differ by more than 1.
 * <p>
 * Example:
 * <p>
 * Given the sorted array: [-10,-3,0,5,9],
 * <p>
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 * 输出结果无标准答案
 */
public class _108_ConvertSortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return toBST(nums, 0, nums.length - 1);
    }

    public TreeNode toBST(int[] nums, int left, int right) {
        if (right < left) {
            return null;
        }

        int mid = (left + right) >> 1;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = toBST(nums, left, mid - 1);
        root.right = toBST(nums, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 8, 9, 10};
        _108_ConvertSortedArrayToBST test = new _108_ConvertSortedArrayToBST();
        TreeNode root = test.sortedArrayToBST(nums);

    }
}
