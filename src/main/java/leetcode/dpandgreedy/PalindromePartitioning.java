package leetcode.dpandgreedy;

import java.util.ArrayList;
import java.util.Collections;

/*Given a string s, partition s such that every substring of the partition is a
 palindrome.
Return all possible palindrome partitioning of s.
For example, given s ="aab",
Return
  [
    ["aa","b"],
    ["a","a","b"]
  ]*/
public class PalindromePartitioning {

    public static ArrayList<ArrayList<String>> partition(String s) {
        int[][] dp = new int[s.length()][s.length()];
        ArrayList<ArrayList<String>> result = new
                ArrayList<ArrayList<String>>();
        ArrayList<String> r = new ArrayList<String>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                int k = 0;
                //判断是否是回文
                for (; k < (j - i + 1) / 2; k++) {
                    if (s.charAt(i + k) != s.charAt(j - k)) break;
                }
                if (k == (j - i + 1) / 2) {
                    dp[i][j] = 1;
                }
            }
        }
        dfs(0, s, dp, r, result);
        return result;
    }

    public static void dfs(int i, String s, int[][] dp, ArrayList<String> r,
                           ArrayList<ArrayList<String>> result) {
        if (i == s.length()) {
            ArrayList<String> t = new ArrayList<String>(r);
            Collections.reverse(t);
            result.add(t);
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (dp[i][j] == 1) {
                r.add(0, s.substring(i, j + 1));
                dfs(j + 1, s, dp, r, result);
                //为了删除r中存放的信息以便下一次继续使用该r
                r.remove(0);
            }
        }
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

    public static boolean isPalindrome(String s) {
        char[] schar = s.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        ArrayList<Character> listtmp = new ArrayList<>();
        boolean flag = true;
        for (char c : schar) {
            list.add(c);
        }
        for (char c : list) {
            listtmp.add(c);
        }
        //Collections.copy(listtmp,list);
        /*Exception in thread "main" java.lang.IndexOutOfBoundsException:
        Source does not fit in dest
	at java.util.Collections.copy(Collections.java:556)*/
        Collections.reverse(listtmp);
        for (int i = 0; i < listtmp.size(); i++) {
            if (listtmp.get(i) != list.get(i)) {
                //System.out.println("!=");
                flag = false;
                return flag;
            }
        }
        return flag;
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
        ArrayList<ArrayList<String>> result = partition(s);
        for (ArrayList<String> res : result) {
            for (String s1 : res) {
                System.out.println(s1);
            }
            System.out.println("=====");
        }


    }
}
