package leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */

public class _49_GroupAnagrams {

    public List<List<String>> anagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String newStr = new String(ch);
            if (!map.containsKey(newStr)) {
                map.put(newStr, new ArrayList<>());
            }
            map.get(newStr).add(str);

        }
        for (String s : map.keySet()) {
            ArrayList<String> list = map.get(s);
            if (list.size() >= 1) result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        _49_GroupAnagrams test = new _49_GroupAnagrams();
        String[] strs = {"eat", "ate", "eta", "nat", "atn", "aaa"};
        List<List<String>> result = test.anagrams(strs);
//        for (String str : result) {
//            System.out.println(str);
//        }
    }

}
