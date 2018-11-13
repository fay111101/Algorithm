package leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * <p>
 * 返回 s 所有可能的分割方案。
 * <p>
 * 示例:
 * <p>
 * 输入: "aab"
 * 输出:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
public class _131_PalindromePartitioning {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(s, new ArrayList<String>());
        return res;
    }

    private void dfs(String s, List<String> list) {
        if (s.length() < 1) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            String str = s.substring(0, i);
            if (this.isPalindrom(str)) {
                list.add(str);
                dfs(s.substring(i), list);
                list.remove(list.size() - 1);
            } else {
                continue;
            }
        }
    }

    private boolean isPalindrom(String s) {
        //s必须是》=1的字符串
        int p1 = 0;
        int p2 = s.length() - 1;
        int len = (s.length() + 1) / 2;
        for (int i = 0; i < len; i++) {
            if (s.charAt(p1++) != s.charAt(p2--))
                return false;
        }
        return true;
    }


    public static boolean isPalindrome1(String s) {
        int len = s.length(), index = 0;
        if (len == 1) {
            return true;
        }
        if (len % 2 == 1) {
            index = len / 2 + 1;
        } else {
            index = len / 2;
        }

        if (s.substring(0, len / 2).equals(new StringBuffer(s.substring(index))
                .reverse().toString())) {
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        String str = "aaa";
        String str1 = "aba";
        String str2 = "abb";
        String str3 = "a";
        /*System.out.println(isPalindrome1(str3));
        System.out.println(isPalindrome1(str2));
        System.out.println(isPalindrome1(str1));
        System.out.println(isPalindrome1(str));*/
        String s = "eaba";
        StringBuffer sb = new StringBuffer(s);
        _131_PalindromePartitioning test = new _131_PalindromePartitioning();
        List<List<String>> result = test.partition(s);
        for (List<String> res : result) {
            for (String s1 : res) {
                System.out.println(s1);
            }
            System.out.println("=====");
        }


    }
}
/*
class Solution {
public:
    vector<vector<string>> partition(string s) {
        vector<string> path;
        vector<vector<string>> result;
        helper(s,0,path,result);
        return result;
    }

    void helper(string s,int pos,vector<string> & path,vector<vector<string>> & result)
    {
        if(pos==s.size())
        {
            result.push_back(path);
            return ;
        }
        for(int i=pos;i<s.size();i++)
        {
            if(isPalindrome(s.substr(pos,i-pos+1)))
            {
                path.push_back(s.substr(pos,i-pos+1));
                helper(s,i+1,path,result);
                path.pop_back();
            }
        }
    }

    bool isPalindrome(string s)
    {
        int first=0;
        int end=s.size()-1;
        while(first<end)
        {
            if(s[first++]!=s[end--])
                return false;
        }
        return true;
    }
};
 */