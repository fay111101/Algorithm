package leetcode.array;

import java.util.Arrays;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class _31_NextPermutation {

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i, j;
        for (i = n - 2; i >= 0; i--) {
            if (nums[i + 1] > nums[i]) {
                for (j = n - 1; j >= i; j--) {
                    if (nums[j] > nums[i]) {
                        break;
                    }
                }
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                Arrays.sort(nums, i + 1, n);
                return;
            }
        }
        Arrays.sort(nums);
    }

    public static void main(String[] args) {
        _31_NextPermutation test = new _31_NextPermutation();
        int[] num = {1, 0, 2, 3, 1};
        test.nextPermutation(num);
        for (int i : num) {
            System.out.println(i);
        }
    }
}
