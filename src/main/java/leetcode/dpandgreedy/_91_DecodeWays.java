package leetcode.dpandgreedy;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 * <p>
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 */
public class _91_DecodeWays {

    /**
     * 题目分析：本题假设给定的字符串为"s[1]s[2]……s[len]"，若我们用a[i-1]表示前i-1个字符的解码方法数，
     * 那么求解a[i]分为两步。第一，若第i个字符s[i]!='0'，那么第i个字符可以单独划分为一个字母，
     * 前i-1个字母的划分对其没有影响，即a[i] = a[i-1]；第二，若第i-1个字符和第i个字符可以组合成大于等于“10”，
     * 并且小于等于“26”的双字符，那么后两个字母组合一下，方法数为前i-2个字符的方法数，即a[i] = a[i] + a[i-2]。
     * @param s
     * @return
     */
    public static int numDecodings(String s) {

        if (s.length() == 0||s.charAt(0)=='0') {
            return 0;
        }
        int[] dp = new int[s.length() ];
        dp[0] = 1;

        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i)!='0'){
                dp[i]=dp[i-1];
            }
            if(s.charAt(i-1)=='1'||(s.charAt(i-1)=='2'&&s.charAt(i)>='0'&&s.charAt(i)<='6')){
                if(i==1){
                    dp[i]+=1;
                }else{
                    dp[i]+=dp[i-2];
                }
            }
        }
        return dp[s.length()-1];
    }

    public int numDecodings1(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int[] memo = new int[n+1];

        memo[n] = 1;
        memo[n-1] = s.charAt(n-1)!='0'?1:0;

        for(int i = n-2;i>=0;i--){
            if(s.charAt(i)=='0') continue;
            else
                memo[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? memo[i+1]+memo[i+2]:memo[i+1];
        }
        return memo[0];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("121"));
    }

}
