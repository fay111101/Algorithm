package leetcode.string;
/* Implement regular expression matching with support for'.'and'*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
*/
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if(p==null||p.length()==0){
            return s==null||s.length()==0;
        }
        if(p.length()==1){
            return s.length()==1&&(p.charAt(0)==s.charAt(0)||p.charAt(0)=='.');
        }
        if(p.charAt(1)!='*'){
            if(s.isEmpty())
                return false;
            if(p.charAt(0)==p.charAt(0)||p.charAt(0)=='.'){
                return isMatch(s.substring(1),p.substring(1));
            }
        }
        //至少匹配一次
        while(!s.isEmpty()&&(p.charAt(0)==p.charAt(0)||p.charAt(0)=='.')){
            if(isMatch(s,p.substring(2))){
                return true;
            }
            s=s.substring(1);
        }
        //匹配0次
        return isMatch(s,p.substring(2));
    }


    public boolean isMatch1(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        boolean dp[][] = new boolean[slen + 1][plen + 1];
        dp[0][0] = true;

        for(int i=1; i<=plen; i++){
            if(p.charAt(i-1)=='*'){
                dp[0][i] = dp[0][i-2];
            }
        }

        for(int i=1; i<=slen; i++){
            for(int j=1; j<=plen; j++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1)=='*'){
                    if(s.charAt(i-1)!=p.charAt(j-2) && p.charAt(j-2)!='.'){
                        dp[i][j] = dp[i][j-2]; //匹配*前面的字符0次
                    }else{
                        //*前面字符匹配1次 || *前面字符匹配0次 || *前面字符匹配多次
                        dp[i][j] = dp[i][j - 1] || dp[i][j - 2] || dp[i - 1][j];
                    }

                }
            }
        }

        return dp[slen][plen];
    }
    public static void main(String[] args){
        String s="aab";
        String p=".*ab";
        String p1="c*a*b";
        RegularExpressionMatching test=new RegularExpressionMatching();
        System.out.println(test.isMatch1(s,p1));
    }
}
