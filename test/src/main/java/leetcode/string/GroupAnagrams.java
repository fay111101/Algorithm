package leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*Given an array of strings, return all groups of strings that are anagrams.
Note: All inputs will be in lower-case.*/
public class GroupAnagrams {
    public ArrayList<String> anagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();
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
            if (list.size() > 1) result.addAll(list);
        }
        return result;
    }

    public static void main(String[] args) {
        GroupAnagrams test = new GroupAnagrams();
        String[] strs = {"eat", "ate", "eta", "nat", "atn","aaa"};
        ArrayList<String> result = test.anagrams(strs);
        for (String str : result) {
            System.out.println(str);
        }
    }

}
