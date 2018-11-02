package leetcode.array;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class _16_SumClosest {

    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int closet = 0;
        int diff = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i+1;
            int right = nums.length - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                int newDiff = Math.abs(sum - target);
                if (newDiff < diff) {
                    diff = newDiff;
                    closet = sum;
                }
                if (sum == target) {
                    return closet;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }

        }
        return closet;

    }




    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, 4};
        int[] nums1 = {1, 1, -1, -1, 3};
//        System.out.println(threeSumClosest(nums,1));
//        System.out.println(threeSumClosest(nums1,3));
        System.out.println(threeSumClosest(nums, -3));
    }
}
