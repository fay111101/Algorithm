package leetcode.search;

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
 *
 *
 */


public class _153_FindMinimumInRotatedSortedArry {


    public int findMin(int[] nums) {
        if(nums==null||nums.length==0) return -1;
        int mid=0;
        int left=0,right=nums.length-1;
        //控制nums[left]>=nums[right].使第一个指针永远指向第一个递增子区间，第二个指针永远指向第二个递增子区间
        while(nums[left]>=nums[right]&&left<right){
            //第一个指针已经到达第一个子区间的末尾
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

    public int findMin1(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start < end) { //注意这里和普通的二分查找不同，这里是start < end不是 start <= end.
            mid = start + (end - start)/2;
            if (nums[mid] > nums[end])
                start = mid + 1; //此时可以扔掉mid的值
            else
                end = mid;//此时不能扔掉mid的值
        }
        return nums[end]; //退出循环说明start与end相等，所以只剩一个元素可能，所以return [start]或者return [end]都可以了。
        //注意不能return mid，可以从{2,1}这个输入看出来。

    }

    //二分查找
    //https://www.cnblogs.com/luoxn28/p/5767571.html
    public int binarySerach(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == key) {
                return mid;
            }
            else if (array[mid] < key) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
