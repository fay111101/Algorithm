package leetcode.dpandgreedy;

/**
 * Created by fay on 2017/12/7.
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * For example,
 * Given:
 * s1 ="aabcc",
 * s2 ="dbbca",
 * When s3 ="aadbbcbcac", return true.
 * When s3 ="aadbbbaccc", return false.
 */
public class InterleavingString {
    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0) {
            return true;
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i >= 1 && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    if (i + j - 1 == 0) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
                if (j >= 1 && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    if (i + j - 1 == 0) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i][j - 1] || dp[i][j];
                    }
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static boolean isInterleave1(String s1, String s2, String s3) {
        if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0) {
            return true;
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= s1.length(); i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s1.charAt(i + 0 - 1);
        }
        for (int j = 1; j <= s2.length(); j++) {
            dp[0][j] = dp[0][j - 1] && s1.charAt(j - 1) == s1.charAt(j + 0 - 1);
        }
        for (int i = 1; i < s1.length(); i++) {
            for (int j = 1; j < s2.length(); i++) {
              /*  if(s1.charAt(i - 1) == s3.charAt(i + j - 1)){
                    dp[i][j] = dp[i - 1][j];
                }
                if(s2.charAt(j - 1) == s3.charAt(i + j - 1)){
                    dp[i][j]=dp[i][j-1];
                }*/
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                        (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
