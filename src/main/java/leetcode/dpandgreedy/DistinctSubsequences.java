package leetcode.dpandgreedy;

import java.util.Arrays;

/* Given a string S and a string T, count the number of distinct subsequences of
 T in S.

A subsequence of a string is a new string which is formed from the original
string by deleting some (can be none) of the characters without disturbing the
relative positions of the remaining characters. (ie,"ACE"is a subsequence
of"ABCDE"while"AEC"is not).

Here is an example:
S ="rabbbit", T ="rabbit"

Return3.

*/
public class DistinctSubsequences {
    public int numDistinct(String S, String T) {
        if(S==null||T==null){
            return 0;
        }
        int m=T.length()+1,n=S.length()+1;
        int[][] dp=new int[m][n];
        for(int i=0;i<n;i++){
            dp[0][i]=1;
        }
        for(int i=1;i<m;i++){
            dp[i][0]=0;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(T.charAt(i-1)==S.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i][j-1];
                }else{
                    dp[i][j]=dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
    public static void main(String[] args){
        DistinctSubsequences test=new DistinctSubsequences();
        String S="rabbbit";
        String S1="ccc";
        String T="rabbit";
        String T1="c";
        System.out.println(test.numDistinct(S,T));
        System.out.println(test.numDistinct(S1,T1));
    }
}
