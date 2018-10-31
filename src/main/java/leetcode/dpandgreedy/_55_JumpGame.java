package main.java.leetcode.dpandgreedy;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * 示例 2:
 * <p>
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */
public class _55_JumpGame {

    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }
        int n = A.length;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], A[i - 1]) - 1;
            if (dp[i] < 0) {
                return false;
            }
        }
        return dp[n - 1] >= 0;
    }
}
