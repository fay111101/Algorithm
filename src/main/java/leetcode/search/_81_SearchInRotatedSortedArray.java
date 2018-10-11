package leetcode.search;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 *
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 *
 * 示例 1:
 *
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 * 进阶:
 *
 * 这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
 * 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 *
 * 允许重复元素，如果A[m]>=A[l], 那么[l,m] 为递增序列的假设就不能成立了，比
 * 如[1,3,1,1,1]。
 * 如果A[m]>=A[l] 不能确定递增，那就把它拆分成两个条件：
 * • 若A[m]>A[l]，则区间[l,m] 一定递增
 * • 若A[m]==A[l] 确定不了，那就l++，往下看一步即可。
 */
public class _81_SearchInRotatedSortedArray {

    public boolean search(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return false;
        }
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return true;
            }
            if(nums[mid]>nums[left]){
                if(target<=nums[right]&&target>nums[mid]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }else if(nums[mid]<nums[left]){
                if(target>=nums[left]&&target<nums[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else{
                left++;
            }
        }
        return false;
    }
}
