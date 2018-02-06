package leetcode.dynamic;

/**
 * Created by fay on 2017/12/13.
 * You are climbing a stair case. It takes n steps to reach to the top.
 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n<2){
            return 1;
        }
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args){
        ClimbingStairs test=new ClimbingStairs();
        System.out.print(test.climbStairs(5));
    }
}
