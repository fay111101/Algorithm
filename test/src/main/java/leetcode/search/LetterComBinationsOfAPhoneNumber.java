package leetcode.search;

import java.util.ArrayList;

/* Given a digit string, return all possible letter combinations that the
number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given
below.

Input:Digit string "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd",
"ce", "cf"].

Note:
Although the above answer is in lexicographical order, your answer could be
in any order you want. */
public class LetterComBinationsOfAPhoneNumber {
    public ArrayList<String> letterCombinations(String digits) {
        String[] strs = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs",
                "tuv",
                "wxyz"};
        ArrayList<String> result = new ArrayList<>();
        String res = new String();
        StringBuffer resbuffer=new StringBuffer();
        int level = 0;
        //backtracking1(digits, strs, result, res, level);
        backtracking(digits, strs, result, resbuffer, level);
        return result;
    }
    public void backtracking1(String digits, String[] strs, ArrayList<String>
            result, String res, int level) {
        if (level == digits.length()) {
            result.add(res);
            return;
        }
        char strChar = digits.charAt(level);
        String str = strs[strChar-'0'];
        for (char ch : str.toCharArray()) {
            //利用String的特点，每次拼接生成了一个新字符串
            backtracking1(digits, strs, result, res+ch, level + 1);
        }
    }
    public void backtracking(String digits, String[] strs, ArrayList<String>
            result, StringBuffer resbuffer, int level) {
        if (level == digits.length()) {
            result.add(resbuffer.toString());
            return;
        }
        char strChar = digits.charAt(level);
        String str = strs[strChar-'0'];
        for (char ch : str.toCharArray()) {
            //StringBuffer每次拼接在原有字符串的基础上做拼接，所以每次做回溯，需要删除字符
            backtracking(digits, strs, result, resbuffer.append(ch), level + 1);
            resbuffer.deleteCharAt(level);
        }
    }
    public static void main(String[] args){
        LetterComBinationsOfAPhoneNumber test=new
                LetterComBinationsOfAPhoneNumber();
        String digits="23";
        String digits1="234";
        String digits2="";
        ArrayList<String> list=test.letterCombinations(digits);
        ArrayList<String> list1=test.letterCombinations(digits1);
        ArrayList<String> list2=test.letterCombinations(digits2);
        for(String str:list){
            System.out.println(str);
        }
    }
}
