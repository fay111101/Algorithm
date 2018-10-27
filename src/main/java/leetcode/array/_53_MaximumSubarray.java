package leetcode.array;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum
 * and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the
 * divide and conquer approach, which is more subtle.
 */
public class _53_MaximumSubarray {


    public int maxSubArray(int[] nums) {
        int currSum=0,result=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            currSum=Math.max(currSum+nums[i],nums[i]);
            result=Math.max(result,currSum);
        }
        return result;
    }

    public int maxSubArray1(int[] nums){
        int currSum=0;
        int result=nums[0];
        for(int i:nums){
            currSum+=i;
            result=Math.max(currSum,result);
            if(currSum<0){
                currSum=0;
            }
        }
        return result;
    }


}
