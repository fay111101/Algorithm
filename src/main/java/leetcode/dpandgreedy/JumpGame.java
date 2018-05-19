package main.java.leetcode.dpandgreedy;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Determine if you are able to reach the last index.

 For example:
 A =[2,3,1,1,4], returntrue.

 A =[3,2,1,0,4], returnfalse.
 */
public class JumpGame {
    public boolean canJump(int[] A) {
        if(A==null||A.length==0){
            return false;
        }
        int n=A.length;
        int[] dp=new int[n];
        for(int i=1;i<n;i++){
            dp[i]=Math.max(dp[i-1],A[i-1])-1;
            if(dp[i]<0){
                return false;
            }
        }
        return dp[n-1]>=0;
    }
}
