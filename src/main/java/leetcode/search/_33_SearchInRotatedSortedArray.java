package leetcode.search;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 示例 1:
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class _33_SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1,mid;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            //左边是有序区域
            if (nums[mid] >= nums[left]) {
                if (nums[mid] > target && nums[left] <=target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                //右边是有序区域
                if (nums[mid] < target && nums[right] >=target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            }
        }
        return -1;

    }



    public static void main(String[] args) {
        int[] a={4,5,6,7,0,1,2};
        int target=5;
//        int target=3;
        _33_SearchInRotatedSortedArray test=new _33_SearchInRotatedSortedArray();
        System.out.println(test.search(a,target));
    }
}
