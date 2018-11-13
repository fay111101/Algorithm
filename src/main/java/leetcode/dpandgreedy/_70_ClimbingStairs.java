package leetcode.dpandgreedy;

/**
 * Created by fay on 2017/12/13.
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 */
public class _70_ClimbingStairs {

    public int climbStairs(int n) {
        if(n<2){
            return 1;
        }
        int[] dp=new int[n];
        dp[0]=1;
        dp[1]=2;
        for(int i=2;i<n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n-1];
    }


    public static void main(String[] args){
        _70_ClimbingStairs test=new _70_ClimbingStairs();
        System.out.print(test.climbStairs(5));
    }
}
