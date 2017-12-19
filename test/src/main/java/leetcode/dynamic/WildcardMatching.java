package main.java.leetcode.dynamic;

/**
 *
 Implement wildcard pattern matching with support for'?'and'*'.

 '?' Matches any single character.
 '*' Matches any sequence of characters (including the empty sequence).

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "*") → true
 isMatch("aa", "a*") → true
 isMatch("ab", "?*") → true
 isMatch("aab", "c*a*b") → false
 */
public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        if ((s == null && p == null) || (s.length() == 0 && p.length() == 0)){
            return true;
        }
        if (p.length() == 0 && s.length() != 0){
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            // 第一行，匹配字符为空，所以考虑待匹配字符为*的情况
            if (p.charAt(i - 1) == '*')
                dp[0][i] = dp[0][i - 1];
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
                    dp[i][j] = dp[i - 1][j - 1];
                if (p.charAt(j - 1) == '*')
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
            }
        }

        return dp[s.length()][p.length()];
    }
}
