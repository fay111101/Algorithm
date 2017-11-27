package leetcode.array;

import java.util.Arrays;

/* Given an array S of n integers, find three integers in S such that the sum is
closest to a given number, target. Return the sum of the three integers. You may
assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/
public class SumClosest {
    public int threeSumClosest(int[] num, int target) {
        int closet=num[0]+num[1]+num[2];
        int diff=Math.abs(closet-target);
        int sum=0;
        Arrays.sort(num);
        for(int i=0;i<num.length-2;i++){
            int left=i+1;
            int right=num.length-1;
            while(left<right){
                sum=num[i]+num[left]+num[right];
                int newDiff=Math.abs(sum-target);
                if(newDiff<diff){
                    diff=newDiff;
                    closet=sum;
                }
                if(sum<closet){
                    left++;
                }else{
                    right--;
                }
            }

        }
        return closet;

    }
}
