package leetcode.array;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 *
 * Find the minimum element.
 *
 * You may assume no _51_duplicate exists in the array.
 *
 * Example 1:
 *
 * Input: [3,4,5,1,2]
 * Output: 1
 * Example 2:
 *
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 */
public class _153_FindMinimumInRotatedSortedArry {

    public int findMin(int[] nums) {
        if(nums==null||nums.length==0) return -1;
        int mid=0;
        int left=0,right=nums.length-1;
        while(nums[left]>=nums[right]&&left<right){
            if(right-left==1){
                mid=right;
                break;
            }
            mid=(left+right)>>1;
            if(nums[mid]>nums[left]){
                left=mid;
            }else{
                right=mid;
            }
        }

        return nums[mid];
    }
}
