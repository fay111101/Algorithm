package leetcode.dynamic;

import java.util.ArrayList;
import java.util.Set;

/*
https://www.cnblogs.com/yuzhangcmu/p/4037299.html
Given a string s and a dictionary of words dict, add spaces in s to construct
a sentence where each word is a valid dictionary word.
Return all such possible sentences.
For example, given
s ="catsanddog",
dict =["cat", "cats", "and", "sand", "dog"].
A solution is["cats and dog", "cat sand dog"].*/
public class WordBreak2 {
    ArrayList<String> resultList=new ArrayList<>();
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        boolean[] res=getDep(s,dict);

        return resultList;
    }
    public boolean[] getDep(String s,Set<String> dict){
        int len=s.length()+1;
        boolean[] res=new boolean[len];
        res[0]=true;
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++ ){
                if(res[j]&&(dict.contains(s.substring(j,i)))){
                    res[i]=true;
                }
            }
        }
        return res;
    }
}

