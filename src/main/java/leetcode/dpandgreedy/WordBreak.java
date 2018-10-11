package leetcode.dpandgreedy;
/*Given a string s and a dictionary of words dict, determine if s can be segmented
into a space-separated sequence of one or more dictionary words.
For example, given
s ="leetcode",
dict =["leet", "code"].
Return true because"leetcode"can be segmented as"leet code".*/

import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] res=new boolean[s.length()+1];
        res[0]=true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(res[j]&&(dict.contains(s.substring(j,i)))){
                    res[i]=true;
                    break;
                }
            }

        }
        return res[s.length()];
    }
}
