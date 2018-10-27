package leetcode.string;

/**
 * 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。

 示例 1：

 输入: "babad"
 输出: "bab"
 注意: "aba"也是一个有效答案。
 示例 2：

 输入: "cbbd"
 输出: "bb"
 在真实的面试中遇到过这道题？

 是

 否
 https://www.jianshu.com/p/c82cada7e5b0
 设状态dp[j][i]表示索引j到索引i的子串是否是回文串。则转移方程为：
 dp[j][i] true j==i;
 dp[j][i] str[i]==str[j] i-j=1
 dp[j][i] str[i]==str[j]&&dp[j+1][i-1] i-j>1
 */
public class _5_LongestPalindromicSubstring {
    //leetcode ac
    public String longestPalindrome1(String s) {
        if(s==null){
            return null;
        }
        if (s.equals("")) {

            return "";
        }
        int size=s.length();
        int[][] dp=new int[size][size];
        int left=0;
        int right=0;
        int max=0;
        for(int j=0;j<size;j++){
            for(int i=0;i<=j;i++){
                if((s.charAt(i)==s.charAt(j))&&(j-i<=1||dp[i+1][j-1]!=0)){
                    dp[i][j]=j-i+1;
                    if(max<dp[i][j]){
                        max=dp[i][j];
                        left=i;
                        right=j;
                    }

                }
            }

        }
        return s.substring(left,right+1);
    }
    private int left, maxLen;
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2)
            return s;
        for (int i = 0; i < s.length() - 1; i++) {
            //考虑两种情况：1.中间是bab;2.中间是bb;
            findMaxPalindrome(s, i, i);
            findMaxPalindrome(s, i, i + 1);

        }

        return s.substring(left, left + maxLen);
    }

    private void findMaxPalindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {

            l--;
            r++;
        }
        if (maxLen < r - l - 1) {
            left = l+1;
            maxLen = r - l - 1;
        }
    }

    public static void main(String[] args){
        _5_LongestPalindromicSubstring test=new _5_LongestPalindromicSubstring();
//        System.out.print(test.longestPalindrome1("zcbbababbca"));
        System.out.print(test.longestPalindrome1(""));
    }
}
