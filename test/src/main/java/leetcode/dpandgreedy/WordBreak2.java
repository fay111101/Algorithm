package leetcode.dpandgreedy;

import java.util.*;

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

    public ArrayList<String> res = new ArrayList<>();

    public ArrayList<String> wordBreak(String s, Set<String> wordDict) {
        ArrayList<String> dp[] = new ArrayList[s.length()+1];
        dp[0] = new ArrayList<String>();
        for(int i = 0; i < s.length(); i++){
            // 只在单词的后一个字母开始寻找，否则跳过
            if(dp[i]==null) continue;
            // 看从当前字母开始能组成哪个在字典里的词
            for(String word : wordDict){
                int len = word.length();
                if(i + len > s.length()) continue;
                String sub = s.substring(i, i+len);
                if(word.equals(sub)){
                    if(dp[i + len] == null){
                        dp[i + len] = new ArrayList<String>();
                    }
                    dp[i + len].add(word);
                }
            }
        }
        // 如果数组末尾不存在单词，说明找不到分解方法
        if(dp[s.length()]!=null) {
            backTrack(dp, s.length(), new ArrayList<String>());
        }
        return res;
    }

    private void backTrack(ArrayList<String> dp[], int end, ArrayList<String> tmp){
        if(end <= 0){
            String path = tmp.get(tmp.size()-1);
            for(int i = tmp.size() - 2; i >= 0; i--){
                path += " " + tmp.get(i);
            }
            res.add(path);
            return;
        }
        for(String word : dp[end]){
            tmp.add(word);
            backTrack(dp, end - word.length(), tmp);
            tmp.remove(tmp.size()-1);
        }
    }

    public static void main(String[] args){
        String s="catsanddog";
        Set<String> set=new LinkedHashSet<>();
        set.add("cat");
        set.add("cats");
        set.add("and");
        set.add("sand");
        set.add("dog");
        ArrayList<String> result = new ArrayList<>();
        WordBreak2 wb=new WordBreak2();
        result=wb.wordBreak(s,set);
        for(String str:result){
            System.out.println(str);
        }
    }

}

