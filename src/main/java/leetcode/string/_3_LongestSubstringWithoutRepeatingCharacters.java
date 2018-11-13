package leetcode.string;

import java.util.HashMap;

/**
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。

 示例 1:

 输入: "abcabcbb"
 输出: 3
 解释: 无重复字符的最长子串是 "abc"，其长度为 3。
 示例 2:

 输入: "bbbbb"
 输出: 1
 解释: 无重复字符的最长子串是 "b"，其长度为 1。
 示例 3:

 输入: "pwwkew"
 输出: 3
 解释: 无重复字符的最长子串是 "wke"，其长度为 3。
 请注意，答案必须是一个子串，"pwke" 是一个子序列 而不是子串。
 */


public class _3_LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        //记录字符上一次出现的位置
        int[] map = new int[256];
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            //想不通 map[s.charAt(i)]<left
            if (map[s.charAt(i)] == 0 || map[s.charAt(i)] < left) {
                max = Math.max(max, i - left + 1);
            } else {
                left = map[s.charAt(i)];
            }
            map[s.charAt(i)] = i + 1;
        }
        return max;
    }

    public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        //记录字符上一次出现的位置的后一个位置,该位置有可能成为下一个left的值
        int[] map = new int[256];
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            left = Math.max(left, map[s.charAt(i)]);
            System.out.println("left:" + left);
            max = Math.max(max, i - left + 1);
            map[s.charAt(i)] = i + 1;
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            //map.get(s.charAt(i))
            //Exception in thread "main" java.lang.NullPointerException
            //记住最左边的位置，如果出现重复字符则将最左边的位置换成该字符的位置
            left = Math.max(left, map.containsKey(s.charAt(i)) ? map.get(s.charAt
                    (i)) : 0);
//            System.out.println("left:"+left);
            max = Math.max(max, i - left + 1);
            map.put(s.charAt(i), i + 1);

        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcdb";
        String
                s1 = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorell" +
                "nmpapqfwkhopkmco";
        _3_LongestSubstringWithoutRepeatingCharacters test = new
                _3_LongestSubstringWithoutRepeatingCharacters();
        /*System.out.println(test.lengthOfLongestSubstring(s));
        System.out.println(test.lengthOfLongestSubstring1(s1));
        System.out.println(test.lengthOfLongestSubstring1(s));
        System.out.println(test.lengthOfLongestSubstring2(s));*/
        System.out.println(test.lengthOfLongestSubstring2(s1));
    }
}
