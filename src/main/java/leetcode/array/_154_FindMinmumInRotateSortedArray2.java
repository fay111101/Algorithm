package leetcode.array;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * <p>
 * Find the minimum element.
 * <p>
 * The array may contain duplicates.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,5]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [2,2,2,0,1]
 * Output: 0
 * Note:
 * <p>
 * This is a follow up problem to Find Minimum in Rotated Sorted Array.
 * Would allow duplicates affect the run-time complexity? How and why?
 */
public class _154_FindMinmumInRotateSortedArray2 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int mid = 0;
        int left = 0, right = nums.length - 1;
        while (nums[left] >= nums[right] && left < right) {
            if (right - left == 1) {
                mid = right;
                break;
            }
            mid = (left + right) >> 1;
            if (nums[left] > nums[mid]) {
                right = mid;
            } else {
                left = mid;
            }
        }

        int min = nums[mid], len = nums.length;
        if (nums[0] == nums[len - 1] && nums[0] == nums[mid]) {
            for (int i = 0; i < len; i++) {
                if (nums[i] < min) {
                    min = nums[i];
                }
            }
        }
        return min;
    }

}
