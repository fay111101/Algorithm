package leetcode.dfsbfsbacktracing;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class _17_LetterComBinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits==null||digits.length()==0){
            return result;
        }
        String[] strs = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs",
                "tuv", "wxyz"};
        String res = new String();
        StringBuffer resbuffer = new StringBuffer();
        int level = 0;
        backtracking1(digits, strs, result, res, level);
//        backtracking(digits, strs, result, resbuffer, level);
        return result;
    }

    public void backtracking1(String digits, String[] strs, List<String>
            result, String res, int level) {
        if (level == digits.length()) {
            result.add(res);
            return;
        }
        char strChar = digits.charAt(level);
        String str = strs[strChar - '0'];
        for (char ch : str.toCharArray()) {
            //利用String的特点，每次拼接生成了一个新字符串
            backtracking1(digits, strs, result, res + ch, level + 1);
        }
    }

    public void backtracking(String digits, String[] strs, List<String>
            result, StringBuffer resbuffer, int level) {
        if (level == digits.length()) {
            result.add(resbuffer.toString());
            return;
        }
        char strChar = digits.charAt(level);
        String str = strs[strChar - '0'];
        for (char ch : str.toCharArray()) {
            //StringBuffer每次拼接在原有字符串的基础上做拼接，所以每次做回溯，需要删除字符
            backtracking(digits, strs, result, resbuffer.append(ch), level + 1);
            resbuffer.deleteCharAt(level);
        }
    }

    public static void main(String[] args) {
        _17_LetterComBinationsOfAPhoneNumber test = new
                _17_LetterComBinationsOfAPhoneNumber();
        String digits = "23";
        String digits1 = "234";
        String digits2 = "";
        List<String> list = test.letterCombinations(digits);
        List<String> list1 = test.letterCombinations(digits1);
        List<String> list2 = test.letterCombinations(digits2);
        for (String str : list) {
            System.out.println(str);
        }
    }
}
