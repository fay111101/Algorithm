package leetcode.array;

/**
 假设按照升序排序的数组在预先未知的某个点上进行了旋转。

 ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

 请找出其中最小的元素。

 注意数组中可能存在重复的元素。

 示例 1：

 输入: [1,3,5]
 输出: 1
 示例 2：

 输入: [2,2,2,0,1]
 输出: 0
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
