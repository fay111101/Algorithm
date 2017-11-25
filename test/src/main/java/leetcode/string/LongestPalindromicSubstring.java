package leetcode.string;

public class LongestPalindromicSubstring {
    //leetcode ac
    public String longestPalindrome1(String s) {
        if(s==null||s.length()==0){
            return null;
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

    private void findMaxPalindrome(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {

            i--;
            j++;
        }
        if (maxLen < j - i - 1) {
            left = i+1;
            maxLen = j - i - 1;
        }
    }

    public static void main(String[] args){
        LongestPalindromicSubstring test=new LongestPalindromicSubstring();
        System.out.print(test.longestPalindrome("zcbbababbca"));
    }
}
